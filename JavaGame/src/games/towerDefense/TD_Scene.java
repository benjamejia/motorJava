package games.towerDefense;

import core.GamePanel;
import core.KeyHandler;
import games.towerDefense.enemies.Enemy;
import games.towerDefense.projectils.Projectil;
import games.towerDefense.towers.Turret;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import scenes.PauseScene;
import scenes.Scene;
import scenes.SceneManager;
import world.Coordinate;
import world.Grid;

public class TD_Scene extends Scene{

    KeyHandler keyHandler;
    SceneManager sceneManager;
    Turret tower;

    private List<Enemy> enemies;

    private int money;
    private int round;
    private double mainHealth = 50;

    
    private boolean roundStarted = false;
    
    private final int[][] pathRaw = {
    {0, 1}, {0, 2}, {0, 3}, {0, 4}, {0, 5},
    
    {1, 5}, {2, 5}, {3, 5}, {4, 5}, {5, 5},
    {6, 5}, {7, 5}, {8, 5}, {9, 5}, {10, 5},
    {11, 5}, {12, 5}, {13, 5}, {14, 5}, {15, 5},
    {16, 5}, {17, 5}, {18, 5},
    
    {18, 6}, {18, 7}, {18, 8}, {18, 9}, {18, 10},
    {18, 11}, {18, 12}
    };

    private Coordinate[] pathEnemies; 

    private int enemiesPerRound = 5;
    private int enemiesPendient = 0;

    private int spawnTimer = 5;
    private double spawnDelay = 5;

    public TD_Scene(KeyHandler kh, SceneManager sm){
        this.keyHandler = kh;
        this.sceneManager = sm;
    }

    @Override
    public void init() {
        money = 100;
        round = 0;
        enemies = new ArrayList<>();
        pathEnemies =  Coordinate.fromArray(pathRaw);
        addTower("Turret", 3, 4, 7, 3);
    }

    @Override
    public void update(double deltaTime) {
        if(keyHandler.consumeKey(KeyEvent.VK_ESCAPE)){
            sceneManager.setCurrentScene(new PauseScene(sceneManager, keyHandler));
        }

        if(keyHandler.consumeKey(KeyEvent.VK_ENTER)){
            if(!roundStarted && enemiesPendient == 0){
                nextRound();
            }
            return;
        }

        if(roundStarted){
            if(enemiesPendient > 0){
                spawnTimer++;
                if(spawnTimer >= spawnDelay && enemies.size() < enemiesPendient){
                    enemies.add(new Enemy(0, 0));
                    spawnTimer = 0;
                }    
            }

            moveEnemies(deltaTime);
            updateProjectiles(deltaTime);

            if(enemiesPendient == 0 && enemies.isEmpty()){
                tower.getBulletsActive().clear();
                roundStarted = false;
            }

        }
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.GREEN);
        g.fillRect(tower.getCol() * Grid.TILE_SIZE, tower.getRow() * Grid.TILE_SIZE,Grid.TILE_SIZE,Grid.TILE_SIZE);

        g.setColor(Color.RED);
        for(Enemy enemy : enemies){
            g.setColor(Color.RED);
            if (enemy != null) {
                g.fillRect(
                    (int)enemy.getCol() * Grid.TILE_SIZE,
                    (int)enemy.getRow() * Grid.TILE_SIZE,
                    Grid.TILE_SIZE, 
                    Grid.TILE_SIZE
                );
            }
        }

        g.setColor(Color.BLUE);
        for(Projectil projectil : tower.getBulletsActive()){
            g.fillOval((int)projectil.getX(), (int)projectil.getY(), 20,20);
        }

        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.BOLD, 28));
        g.drawString("Enemies alive: " + enemiesPendient, 40, GamePanel.SIZE_HEIGHT - 40);
        g.drawString("Round: " + round, GamePanel.SIZE_WIDTH - 160, 40);
        g.drawString("Money: " + money, GamePanel.SIZE_WIDTH - 180, 80);

        g.setColor(Color.BLUE);
        g.drawString("Health tower: " + mainHealth, GamePanel.SIZE_WIDTH - 250, GamePanel.SIZE_HEIGHT - 40);
    }

    @Override
    public void dispose() {
    }

    public void updateProjectiles(double deltaTime) {
        Iterator<Projectil> iterator =
            tower.getBulletsActive().iterator();

        while (iterator.hasNext()) {

            Projectil projectil = iterator.next();
            projectil.update(deltaTime);
            
            Enemy enemy = projectil.getObjective();

            if (enemy == null) {
                iterator.remove();
                continue;
            }

            if (projectil.getCollider().intersects(
                    enemy.getCollider())) {

                enemy.setHealth(enemy.getHealth() - projectil.getDamage());

                iterator.remove();
            }
        }
    }

    public void nextRound(){
        round++;
        enemiesPendient += enemiesPerRound + round * 1.2;
        roundStarted = true;
        spawnDelay = spawnDelay - 0.1;
        tower.getBulletsActive().clear();
    }

    public void makeDamage(Turret tower, Enemy enemy){
        if(enemy.getCollider().intersects(tower.getCollider())){
            tower.attack(enemy, tower);
        }
    }

    public void moveEnemies(double deltaTime) {
    Iterator<Enemy> iterator = enemies.iterator();

    while (iterator.hasNext()) {
        Enemy enemy = iterator.next();
        int step = enemy.getCurrentStep();

            if(step < pathEnemies.length){
                enemy.setCoordinate(pathEnemies[enemy.getCurrentStep()]);
                enemy.setCurrentStep(enemy.getCurrentStep() + 1);
            }else{
                iterator.remove();
                setMainHealth(getMainHealth() - enemy.getDamage());
                enemiesPendient--;
            }

            makeDamage(tower, enemy);

            if(enemy.getHealth() <= 0){
                setMoney(getMoney() + enemy.getGold());
                setEnemiesPendient(getEnemiesPendient() - 1);
                iterator.remove();
            }
        }
    }

    public void addTower(String name, int cost, int range, int col, int row ){
        tower = new Turret(name, cost,range,col,row);
        setMoney(getMoney() - cost);
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getNumberEnemies() {
        return enemiesPendient;
    }

    public void setEnemiesPerRound(int numberEnemies) {
        this.enemiesPerRound = numberEnemies;
    }

     public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public double getMainHealth() {
        return mainHealth;
    }

    public void setMainHealth(double mainHealth) {
        this.mainHealth = mainHealth;
    }

        public int getEnemiesPendient() {
        return enemiesPendient;
    }

    public void setEnemiesPendient(int enemiesPendient) {
        this.enemiesPendient = enemiesPendient;
    }

    @Override
    public void onMouseMove(MouseEvent e) {

    }

    @Override
    public void onMousePressed(MouseEvent e) {

    }

    @Override
    public void onMouseReleased(MouseEvent e) {

    }
}
