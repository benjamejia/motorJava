package scenes;

import core.GamePanel;
import core.KeyHandler;
import games.snake.SnakeScene;
import games.toweDefense.TD_Scene;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import ui.GameButton;
import ui.GameLabel;

public class MenuScene extends Scene{

    SceneManager sceneManager;
    KeyHandler keyHandler;
    List<GameButton> listButtons;
    GameLabel gameLabel;

    public MenuScene(SceneManager sm, KeyHandler kh){
        this.sceneManager = sm;
        this.keyHandler = kh;
        listButtons = new ArrayList<>(); 
    }

    @Override
    public void init() {
        gameLabel = new GameLabel((GamePanel.SIZE_WIDTH - 200)/2, 90, 200, 100, "MI MOTOR", false, 50);

        listButtons.add(new GameButton((GamePanel.SIZE_WIDTH - 300)/2, 200, "Tower Defense", 300, 100, () -> {
            sceneManager.setCurrentScene(new TD_Scene(keyHandler, sceneManager));
            sceneManager.deleteLastScene();
        }));

        listButtons.add(new GameButton((GamePanel.SIZE_WIDTH - 300)/2, 320, "Snake", 300, 100, () -> {
            sceneManager.setCurrentScene(new SnakeScene(sceneManager, keyHandler));
            sceneManager.deleteLastScene();
        }));

        listButtons.add(new GameButton((GamePanel.SIZE_WIDTH - 300)/2, 440, "Salir", 300, 100, () -> {
            System.exit(0);
        }));
    }

    @Override
    public void update(double deltaTime) {
    }

    @Override
    public void draw(Graphics2D g2) {
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
    public void onMouseMove(MouseEvent e) {
        for(GameButton btn : listButtons){
            btn.onMouseMove(e);
        }
    }

    @Override
    public void onMousePressed(MouseEvent e) {
        for(GameButton btn : listButtons){
            btn.onMousePressed(e);
        }
    }

    @Override
    public void onMouseReleased(MouseEvent e) {
        for(GameButton btn : listButtons){
            btn.onMouseReleased(e);
        }
    }

}
