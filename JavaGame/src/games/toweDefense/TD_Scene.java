package games.toweDefense;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import core.KeyHandler;
import scenes.GameOverScene;
import scenes.Scene;
import scenes.SceneManager;

public class TD_Scene extends Scene{

    KeyHandler keyHandler;
    SceneManager sceneManager;

    Tower tower;
    Enemy enemy;
    TowerSelector towerSelector;

    private int money;
    private int round;
    private int numberEnemies;
    private final int sizeWidth;
    private final int sizeHeight;

    Tower torret = new Tower(0, 0, 1, 5, 45);
    Tower sniper = new Tower(0, 0, 4, 10, 55);

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

        towerSelector = new TowerSelector();
        towerSelector.addTower(torret);
        towerSelector.addTower(sniper);
    }

    @Override
    public void update() {
        if(numberEnemies == 0){
            
        }
        //Pausa
        if(keyHandler.consumeKey(KeyEvent.VK_ESCAPE)){
            sceneManager.setCurrentScene(new GameOverScene(sceneManager,keyHandler,sizeWidth,sizeHeight));
        }
    }

    @Override
    public void draw(Graphics g) {
        g.drawString("Score: " + money, sizeWidth - 100, sizeHeight - 30);
        g.drawString("Round " + round, sizeWidth - 100, sizeHeight - 40);
    }

    @Override
    public void dispose() {
    }

    public void startRound(){

    }

}
