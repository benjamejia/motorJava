package core;

import games.snake.SnakeScene;
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

    private final int fps = 13;
    private final int sizeWidth = 600;
    private final int sizeHeight = 500;

    public GamePanel(){
        this.addKeyListener(kh);
        this.setFocusable(true);
        this.setPreferredSize(new Dimension(sizeWidth, sizeHeight));
        this.setBackground(Color.BLACK);

        SnakeScene initialScene = new SnakeScene(sceneManager, kh, sizeWidth, sizeHeight);
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
