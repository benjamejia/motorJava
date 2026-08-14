package scenes;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import core.GamePanel;
import core.KeyHandler;

public class MenuScene extends Scene{

    SceneManager sceneManager;
    KeyHandler keyHandler;

    public MenuScene(SceneManager sm, KeyHandler kh){
        this.sceneManager = sm;
        this.keyHandler = kh;
    }

    @Override
    public void init() {
    }

    @Override
    public void update() {
        if(keyHandler.consumeKey(KeyEvent.VK_ENTER)){
            sceneManager.deleteCurrentScene();
        }
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.RED); 
        g.setFont(new Font("Arial", Font.BOLD, 24));
        g.drawString("Game Over", GamePanel.SIZE_WIDTH / 2 - 70, GamePanel.SIZE_HEIGHT / 2 - 50);
    }

    @Override
    public void dispose() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'dispose'");
    }

}
