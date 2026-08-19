package core;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import scenes.MenuScene;
import scenes.SceneManager;
import util.Time;

public class GamePanel extends JPanel implements Runnable {

    Thread gameThread;
    KeyHandler kh = new KeyHandler();
    SceneManager sceneManager;
    MouseAdapter mouseAdapter;

    private final int fps = 8;
    public static final int SIZE_WIDTH = 1790;
    public static final int SIZE_HEIGHT = 980;

    public GamePanel(){
        this.addKeyListener(kh);
        this.setFocusable(true);
        this.setPreferredSize(new Dimension(SIZE_WIDTH, SIZE_HEIGHT));
        this.setBackground(Color.BLACK);
        this.sceneManager = new SceneManager();
        this.sceneManager.setCurrentScene(new MenuScene(sceneManager, kh));

        MouseAdapter mouseHandler = new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                if (sceneManager.getCurrentScene() != null) {
                    sceneManager.getCurrentScene().onMouseMove(e);
                }
            }
            @Override
            public void mousePressed(MouseEvent e) {
                if (sceneManager.getCurrentScene() != null) {
                    sceneManager.getCurrentScene().onMousePressed(e);
                }
            }
            @Override
            public void mouseReleased(MouseEvent e) {
                if (sceneManager.getCurrentScene() != null) {
                    sceneManager.getCurrentScene().onMouseReleased(e);
                }
            }
        };

        addMouseListener(mouseHandler);
        addMouseMotionListener(mouseHandler);
    }

    public void startGameThread() {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        double beginTime = Time.getTime();
        double endTime;
        double dt = 0.0;
        while(gameThread != null){
            update(dt);
            repaint();
            endTime = Time.getTime();
            dt = endTime - beginTime;
            beginTime = endTime;
        }
    }

    public void update(double deltaTime) {
        sceneManager.update(deltaTime);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D) g;

        sceneManager.draw(g2);   
    }

}
