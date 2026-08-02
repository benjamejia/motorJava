package main;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import entitys.snake.Fruit;
import entitys.snake.Snake;


public class GamePanel extends JPanel implements KeyListener, Runnable {

    int fps = 10;
    Thread gameThread;
    KeyHandler kh = new KeyHandler();
    public Snake snake = new Snake(this, kh);
    public Fruit fruit = new Fruit(this);
    //public Player player = new Player(this, kh);
    //public Ball ball = new Ball(this);

    public GamePanel(){
        this.addKeyListener(kh);
        this.setFocusable(true);
        this.setPreferredSize(new Dimension(600, 500));
        this.setBackground(Color.BLACK);
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
        snake.update();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        snake.draw(g2);
        fruit.draw(g2);
        fruit.drawColliders(g2);
    }

    @Override
    public void keyPressed(KeyEvent e) {
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

}
