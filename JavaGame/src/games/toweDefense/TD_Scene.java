package games.toweDefense;

import core.KeyHandler;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import scenes.MenuScene;
import scenes.Scene;
import scenes.SceneManager;

public class TD_Scene extends Scene{

    KeyHandler keyHandler;
    SceneManager sceneManager;

    private Tower tower;
    private Enemy enemy;

    private int money;
    private int round;
    private int numberEnemies;

    private final int sizeWidth;
    private final int sizeHeight;

    public TD_Scene(KeyHandler kh, SceneManager sm, int sizeW, int sizeH){
        this.keyHandler = kh;
        this.sceneManager = sm;
        this.sizeWidth = sizeW;
        this.sizeHeight = sizeH;
    }

    @Override
    public void init() {
        money = 0;
        round = 0;
        numberEnemies = 0;
    }

    @Override
    public void update() {
        if(numberEnemies == 0){
            
        }
        //Pausa
        if(keyHandler.consumeKey(KeyEvent.VK_ESCAPE)){
            sceneManager.setCurrentScene(new MenuScene(sceneManager,keyHandler,sizeWidth,sizeHeight));
        }
    }

    public int[] path;

    @Override
    public void draw(Graphics g) {
        for(int i = 0; i < path.length; i++){
            g.fillOval(i, i, i, i);
        }
        g.drawString("Score: " + money, sizeWidth - 100, sizeHeight - 30);
        g.drawString("Round " + round, sizeWidth - 100, sizeHeight - 40);
    }

    @Override
    public void dispose() {
    }

    public void startRound(){

    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getNumberEnemies() {
        return numberEnemies;
    }

    public void setNumberEnemies(int numberEnemies) {
        this.numberEnemies = numberEnemies;
    }

     public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }
}
