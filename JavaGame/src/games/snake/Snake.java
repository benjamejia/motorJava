package games.snake;

import core.GamePanel;
import core.KeyHandler;
import entities.Entity;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.util.ArrayDeque;
import java.util.Deque;


public class Snake extends Entity{

    private int score = 0;
    private final int sizeWidth = 25;
    private final int sizeHeight = 25;
    private final Deque<Coordinate> bodySnake = new ArrayDeque<>();
    
    public Snake(){
        setX(50);
        setY(50);
        bodySnake.add(new Coordinate(getX(), getY())); // cola
        bodySnake.add(new Coordinate(getX() + sizeWidth, getY()));
    }

    public void increaseScore(int increase){
        score += increase;
    }

    public void addBody(Coordinate coordinate){
        bodySnake.add(new Coordinate(coordinate.getX(),coordinate.getY()));
    }

    public Coordinate getLastSnakeElement(){
        return bodySnake.getLast();
    }

    public Coordinate getFisrtSnakeElemente(){
        return  bodySnake.getFirst();
    }

    public int getSizeWidth(){
        return sizeWidth;
    }

    public int getSizeheigth(){
        return sizeHeight;
    }

    public void update(){
        getCollider();

        switch (kh.getTeclaActual()) {
            case KeyEvent.VK_D -> {
                bodySnake.add(new Coordinate(bodySnake.getLast().getX() + sizeWidth, bodySnake.getLast().getY()));
                bodySnake.pollFirst();
            }

            case KeyEvent.VK_W -> {
                bodySnake.add(new Coordinate(bodySnake.getLast().getX(), bodySnake.getLast().getY() - sizeHeight));
                bodySnake.pollFirst();
            }

            case KeyEvent.VK_S -> {
                bodySnake.add(new Coordinate(bodySnake.getLast().getX(), bodySnake.getLast().getY() + sizeHeight));
                bodySnake.pollFirst();
            }

            case KeyEvent.VK_A -> {
                bodySnake.add(new Coordinate(bodySnake.getLast().getX() - sizeWidth, bodySnake.getLast().getY()));
                bodySnake.pollFirst();
            }

            default -> {
            }
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
            g2.setColor(Color.WHITE);
            g2.fillRect(coordinate.getX(), coordinate.getY(), sizeWidth, sizeHeight);
        }

        g2.drawString("Score: " + score, 500, 20);
    }
}
