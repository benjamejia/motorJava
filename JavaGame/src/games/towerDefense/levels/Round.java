package games.towerDefense.levels;

import core.GamePanel;
import games.towerDefense.enemies.Enemy;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import world.Coordinate;
import world.Grid;

public class Round {
    private int round;
    private final List<Enemy> enemies;
    private boolean roundStarted;
    private final Coordinate[] pathEnemies;
    private int enemiesPerRound;

    private int enemiesPendient;
    private int enemiesKilled = 0;
    private double spawnTimer = 0;
    private final double spawnObjectiveTime = 2;

    public Round(){
        round = 0;
        enemies = new ArrayList<>();
        roundStarted = false;
        pathEnemies = Coordinate.fromArray(pathRaw);
        enemiesPerRound = 10;
    }

    public void update(double  deltaTime){
        if(roundStarted){
            addEnemies(deltaTime);
            moveEnemies(deltaTime);
        }
    }

    public void draw(Graphics2D g2){
        g2.setColor(Color.RED);
        synchronized (enemies) {
            for(Enemy enemy : enemies){
                g2.setColor(Color.RED);
                if (enemy != null) {
                    g2.fillRect(
                        (int)enemy.getX(),
                        (int)enemy.getY(),
                        Grid.TILE_SIZE, 
                        Grid.TILE_SIZE
                    );
                }
            }
        }

        g2.setColor(Color.WHITE);
        g2.setFont(new Font("Arial", Font.BOLD, 28));
        g2.drawString("Enemies alive: " + enemiesPendient, 40, GamePanel.SIZE_HEIGHT - 40);
        g2.drawString("Round: " + round, GamePanel.SIZE_WIDTH - 160, 40);
    }

    public void addEnemies(double  deltaTime){
        if(enemiesPendient <= 0){
            roundStarted = false;
            return;
        }else if(spawnTimer >= spawnObjectiveTime && enemies.size() < enemiesPendient){
            synchronized (enemies) {
                enemies.add(new Enemy(0, 0));
            }
            spawnTimer = 0;
        }
        spawnTimer += deltaTime;
    }

    public void moveEnemies(double  deltaTime){
        synchronized (enemies) {
            if(enemies.isEmpty())   return;
            Iterator<Enemy> iterator = enemies.iterator();
            while(iterator.hasNext()){
                Enemy e = iterator.next();
    
                e.update(deltaTime, pathEnemies);
    
                if(e.hasReachedEnd(pathEnemies.length)){
                    iterator.remove();
                    enemiesPendient--;
                    continue;
                }
    
                if(e.isDeath()){
                    iterator.remove();
                    enemiesKilled++;
                    enemiesPendient--;
                }
            }
        }
    }
    

    public void startRound(){
        if(roundStarted){
            return;
        }
        round++;
        enemiesPendient = enemiesPerRound;
        roundStarted = true;
    }

    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public List<Enemy> getEnemies() {
        return enemies;
    }

    public boolean isRoundStarted() {
        return roundStarted;
    }

    public void setRoundStarted(boolean roundStarted) {
        this.roundStarted = roundStarted;
    }

    public int getEnemiesPerRound() {
        return enemiesPerRound;
    }

    public void setEnemiesPerRound(int enemiesPerRound) {
        this.enemiesPerRound = enemiesPerRound;
    }

    public int getEnemiesPendient() {
        return enemiesPendient;
    }

    public void setEnemiesPendient(int enemiesPendient) {
        this.enemiesPendient = enemiesPendient;
    }
    
    public Coordinate[] getPath() {
        return pathEnemies;
    }

    private final int[][] pathRaw = {
    {0, 1}, {0, 2}, {0, 3}, {0, 4}, {0, 5},
    
    {1, 5}, {2, 5}, {3, 5}, {4, 5}, {5, 5},
    {6, 5}, {7, 5}, {8, 5}, {9, 5}, {10, 5},
    {11, 5}, {12, 5}, {13, 5}, {14, 5}, {15, 5},
    {16, 5}, {17, 5}, {18, 5},
    
    {18, 6}, {18, 7}, {18, 8}, {18, 9}, {18, 10},
    {18, 11}, {18, 12}
    };

    public int getEnemiesKilled() {
        return enemiesKilled;
    }

    public void setEnemiesKilled(int enemiesKilled) {
        this.enemiesKilled = enemiesKilled;
    }
}
