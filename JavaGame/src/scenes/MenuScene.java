package scenes;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

import core.KeyHandler;

public class MenuScene extends Scene{

    SceneManager sceneManager;
    KeyHandler keyHandler;
    private int sizeWidth;
    private int sizeHeight;

    public MenuScene(SceneManager sm, KeyHandler kh, int sizeWidth, int sizeHeight){
        this.sceneManager = sm;
        this.keyHandler = kh;
        this.sizeWidth = sizeWidth;
        this.sizeHeight = sizeHeight;
    }

    @Override
    public void init() {
        System.out.println("Menu funcionando");
    }

    @Override
    public void update() {
        if(keyHandler.consumeKey(KeyEvent.VK_ESCAPE)){
            sceneManager.deleteCurrentScene();
        }
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(new Color(0, 100, 200)); // Azul personalizado
        g.setFont(new Font("Arial", Font.BOLD, 24));
        g.drawString("Menu pausa", sizeWidth / 2 - 70, sizeHeight / 2 - 50);
    }

    @Override
    public void dispose() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'dispose'");
    }

}
