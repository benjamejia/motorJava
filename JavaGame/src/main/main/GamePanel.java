package main;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import entitys.Ball;
import entitys.Player;

public class GamePanel extends JPanel implements KeyListener, Runnable {

    int playerSpeedX = 1;
    int playerSpeedY = 1;
    Thread gameThread;
    public Player player = new Player(this);
    public Ball ball = new Ball(this);

    public GamePanel(){
        this.setPreferredSize(new Dimension(600, 500));
        this.setBackground(Color.BLACK);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        double drawInterval = 1000000000.0 / 200; // 60 FPS
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
        player.update();
        ball.update();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;
        player.draw(g2);
        ball.draw(g2);
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
