package games.towerDefense;

import core.KeyHandler;
import games.towerDefense.level.Level;
import games.towerDefense.projectils.Bullet;
import games.towerDefense.towers.Turret;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import scenes.PauseScene;
import scenes.Scene;
import scenes.SceneManager;
import ui.TowerUpgradePanel;
import world.Grid;

public class SceneTD extends Scene {

    private final KeyHandler keyHandler;
    private final SceneManager sceneManager;
    private final Level level;
    private final TowerUpgradePanel towerUpgradePanel = new TowerUpgradePanel(20,20);

    public SceneTD(KeyHandler kh, SceneManager sm){
        this.keyHandler = kh;
        this.sceneManager = sm;
        level = new Level();
        towerUpgradePanel.setTower(new Turret("Torreta", 50, 1, 10 / Grid.TILE_SIZE, 10 / Grid.TILE_SIZE, Bullet::new));
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
        towerUpgradePanel.draw(g2);
    }

    @Override
    public void onMouseMove(MouseEvent e) {
        
    }

    @Override
    public void onMousePressed(MouseEvent e) {
        level.addTower(e.getPoint());
    }

    @Override
    public void onMouseReleased(MouseEvent e) {
       
    }

    @Override
    public void dispose() {
       
    }

}
