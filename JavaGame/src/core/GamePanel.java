package core;

import games.toweDefense.TD_Scene;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;

import scenes.SceneManager;



public class GamePanel extends JPanel implements Runnable {

    Thread gameThread;
    KeyHandler kh = new KeyHandler();
    SceneManager sceneManager = new SceneManager();

    private final int fps = 8;
    public static final int SIZE_WIDTH = 1790;
    public static final int SIZE_HEIGHT = 980;

    public GamePanel(){
        this.addKeyListener(kh);
        this.setFocusable(true);
        this.setPreferredSize(new Dimension(SIZE_WIDTH, SIZE_HEIGHT));
        this.setBackground(Color.BLACK);

        TD_Scene initialScene = new TD_Scene(kh, sceneManager);
        sceneManager.setCurrentScene(initialScene);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double drawInterval = 1000000000.0 / fps;
        double delta = 0;
        long lastTime = System.nanoTime();
        long currentTime;

        while (gameThread != null) {

            currentTime = System.nanoTime();

            delta += (currentTime - lastTime) / drawInterval;

            lastTime = currentTime;

            if (delta >= 1) {
                update();
                repaint();
                delta--;
            }
        }
    }

    public void update() {
        sceneManager.update();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        sceneManager.draw(g2);
        
    }

}
