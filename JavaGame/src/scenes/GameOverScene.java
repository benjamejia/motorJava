package scenes;

import core.GamePanel;
import core.KeyHandler;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class GameOverScene extends Scene{

    SceneManager sceneManager;
    KeyHandler keyHandler;

    public GameOverScene(SceneManager sm, KeyHandler kh){
        this.sceneManager = sm;
        this.keyHandler = kh;
    }

    @Override
    public void init() {
    }

    @Override
    public void update(double deltaTime) {
        if(keyHandler.consumeKey(KeyEvent.VK_ENTER)){
            sceneManager.deleteCurrentScene();
        }
    }

    @Override
    public void draw(Graphics2D g) {
        g.setColor(Color.RED); 
        g.setFont(new Font("Arial", Font.BOLD, 24));
        g.drawString("Game Over", GamePanel.SIZE_WIDTH / 2 - 70, GamePanel.SIZE_HEIGHT / 2 - 50);
    }

    @Override
    public void dispose() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'dispose'");
    }

    @Override
    public void onMouseMove(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'onMouseMove'");
    }

    @Override
    public void onMousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'onMousePressed'");
    }

    @Override
    public void onMouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'onMouseReleased'");
    }

}
