package entitys.snake;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Random;

import entitys.Entity;
import main.GamePanel;
import main.KeyHandler;


public class Snake extends Entity{

    GamePanel gp;
    KeyHandler kh;
    Random random = new Random();
    private int score = 0;
    private int sizeWidth = 25;
    private int sizeHeight = 25;
    private Deque<Coordinate> bodySnake = new ArrayDeque<>();
    
    public Snake(GamePanel gp,KeyHandler kh){
        
        this.gp = gp;
        this.kh = kh;

        setX(50);
        setY(50);
        bodySnake.add(new Coordinate(getX(), getY())); // cola
        bodySnake.add(new Coordinate(getX() + sizeWidth, getY()));
        bodySnake.add(new Coordinate(70, getY()));
        bodySnake.add(new Coordinate(80, getY()));

    }

    public void grow(){
        switch (kh.getTeclaActual()) {
            case KeyEvent.VK_D:
                    bodySnake.addLast(new Coordinate(bodySnake.getLast().getX() + sizeWidth, bodySnake.getLast().getY()));
                break;

            case KeyEvent.VK_W:
                    bodySnake.addLast(new Coordinate(bodySnake.getLast().getX(), bodySnake.getLast().getY() - sizeHeight));
                break;

            case KeyEvent.VK_S:
                    bodySnake.addLast(new Coordinate(bodySnake.getLast().getX(), bodySnake.getLast().getY() + sizeHeight));
                break;

            case KeyEvent.VK_A:
                    bodySnake.addLast(new Coordinate(bodySnake.getLast().getX() - sizeWidth, bodySnake.getLast().getY()));
                break;

            default:
                break;
        }
    }

    public void update(){
        getCollider();

        switch (kh.getTeclaActual()) {
            case KeyEvent.VK_D:
                    bodySnake.add(new Coordinate(bodySnake.getLast().getX() + sizeWidth, bodySnake.getLast().getY()));
                    bodySnake.pollFirst();
                break;

            case KeyEvent.VK_W:
                    bodySnake.add(new Coordinate(bodySnake.getLast().getX(), bodySnake.getLast().getY() - sizeHeight));
                    bodySnake.pollFirst();
                break;

            case KeyEvent.VK_S:
                    bodySnake.add(new Coordinate(bodySnake.getLast().getX(), bodySnake.getLast().getY() + sizeHeight));
                    bodySnake.pollFirst();
                break;

            case KeyEvent.VK_A:
                    bodySnake.add(new Coordinate(bodySnake.getLast().getX() - sizeWidth, bodySnake.getLast().getY()));
                    bodySnake.pollFirst();
                break;

            default:
                break;
        }

        if(getCollider().intersects(gp.fruit.getCollider())){
            gp.fruit.foodSpawn();
            grow();
            score += 10;
        }
    }

    public Rectangle getCollider(){
        Coordinate head = bodySnake.peekLast();

        if(head == null){
            return null;
        }

        return new Rectangle(head.getX(),head.getY(),sizeWidth,sizeHeight);
    }

    public void draw(Graphics2D g2){
        for(Coordinate coordinate : bodySnake) {
            g2.fillRect(coordinate.getX(), coordinate.getY(), sizeWidth, sizeHeight);
            g2.setColor(Color.WHITE);
        }

        g2.drawString("Score: " + score, 500, 20);
    }
    
    public void drawColliders(Graphics g) {
        Color oldColor = g.getColor(); 
        
        g.setColor(Color.RED); 

        for (Coordinate coordinate : bodySnake) {
            g.drawRect(coordinate.getX(), coordinate.getY(), sizeWidth, sizeHeight);
        }

        g.setColor(oldColor);
    }
}
