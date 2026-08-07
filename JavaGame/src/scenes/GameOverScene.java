package scenes;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import core.KeyHandler;

public class GameOverScene extends Scene{

    SceneManager sceneManager;
    KeyHandler keyHandler;
    private int sizeWidth;
    private int sizeHeight;

    public GameOverScene(SceneManager sm, KeyHandler kh, int sizeWidth, int sizeHeight){
        this.sceneManager = sm;
        this.keyHandler = kh;
        this.sizeWidth = sizeWidth;
        this.sizeHeight = sizeHeight;
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
        g.drawString("Game Over", sizeWidth / 2 - 70, sizeHeight / 2 - 50);
    }

    @Override
    public void dispose() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'dispose'");
    }

}
