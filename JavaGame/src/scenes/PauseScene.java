package scenes;

import core.GamePanel;
import core.KeyHandler;
import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.List;
import ui.GameButton;
import ui.GameLabel;

public class PauseScene extends Scene{

    SceneManager sceneManager;
    KeyHandler keyHandler;
    List<GameButton> listButtons;
    GameLabel gameLabel;

    public PauseScene(SceneManager sm, KeyHandler kh){
        this.sceneManager = sm;
        this.keyHandler = kh;
        listButtons = new ArrayList<>(); 
    }

    @Override
    public void init() {
        gameLabel = new GameLabel((GamePanel.SIZE_WIDTH - 200)/2, 90, 200, 100, "Pause", false, 50);

        listButtons.add(new GameButton((GamePanel.SIZE_WIDTH - 300)/2, 200, "Resume", 300, 100, () -> {
            sceneManager.deleteCurrentScene();
        }));

        listButtons.add(new GameButton((GamePanel.SIZE_WIDTH - 300)/2, 320, "Salir", 300, 100, () -> {
            sceneManager.clearStack();
            sceneManager.setCurrentScene(new MenuScene(sceneManager, keyHandler));
        }));
    }

    @Override
    public void update(double deltaTime) {
    }

    @Override
    public void draw(Graphics2D g2) {
        g2.setColor(new Color(50, 100, 200, 180));
        g2.fillRect(0, 0, GamePanel.SIZE_WIDTH,GamePanel.SIZE_HEIGHT);
        gameLabel.draw(g2);

        for(GameButton btn: listButtons){
            btn.draw(g2);
        }
    }

    @Override
    public void dispose() {
        listButtons.clear();
    }

    @Override
    public void onMouseMove(java.awt.event.MouseEvent e) {
        for(GameButton btn : listButtons){
            btn.onMouseMove(e);
        }
    }

    @Override
    public void onMousePressed(java.awt.event.MouseEvent e) {
        for(GameButton btn : listButtons){
            btn.onMousePressed(e);
        }
    }

    @Override
    public void onMouseReleased(java.awt.event.MouseEvent e) {
        for(GameButton btn : listButtons){
            btn.onMouseReleased(e);
        }
    }
}
