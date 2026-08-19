package games.towerDefense;

import core.KeyHandler;
import games.towerDefense.levels.Level;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import scenes.PauseScene;
import scenes.Scene;
import scenes.SceneManager;
import world.Grid;

public class SceneTD extends Scene {

    private final KeyHandler keyHandler;
    private final SceneManager sceneManager;
    private final Level level;

    public SceneTD(KeyHandler kh, SceneManager sm){
        this.keyHandler = kh;
        this.sceneManager = sm;
        level = new Level();
    }
    

    @Override
    public void init() {
    }

    @Override
    public void update(double deltaTime) {
        if(keyHandler.consumeKey(KeyEvent.VK_ESCAPE)){
            sceneManager.setCurrentScene(new PauseScene(sceneManager, keyHandler));
        }

        if(keyHandler.consumeKey(KeyEvent.VK_ENTER)){
            level.getRound().startRound();
        }

        if(level.getRound().isRoundStarted()){
            level.update(deltaTime);
        }
    }

    @Override
    public void draw(Graphics2D g2) {
        level.draw(g2);
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

    @Override
    public void dispose() {
       
    }

}
