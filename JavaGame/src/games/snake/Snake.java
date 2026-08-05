package games.snake;

import entities.Entity;
import java.awt.Rectangle;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;


public class Snake extends Entity{

    private int score = 0;
    private final int sizeWidth = 25;
    private final int sizeHeight = 25;
    private final Deque<Coordinate> bodySnake = new ArrayDeque<>();
    
    public Snake(Coordinate initialPosition){
        bodySnake.add(initialPosition);
    }

    public void increaseScore(int increase){
        score += increase;
    }

    public void addBody(Coordinate coordinate){
        bodySnake.add(new Coordinate(coordinate.getX(),coordinate.getY()));
    }

    public void addBodyLast(Coordinate coordinate){
        bodySnake.addLast(new Coordinate(coordinate.getX(), coordinate.getY()));
    }

    public void removeHead(){
        bodySnake.poll();
    }

    public Collection<Coordinate> getBodySnake() {
        return Collections.unmodifiableCollection(bodySnake);
    }

    public Coordinate getLastSnakeElement(){
        return bodySnake.getLast();
    }

    public Coordinate getFisrtSnakeElemente(){
        return  bodySnake.getFirst();
    }

    public int getScore(){
        return score;
    }

    public void resetScore(){
        score = 0;
    }

    public int getSizeWidth(){
        return sizeWidth;
    }

    public int getSizeheigth(){
        return sizeHeight;
    }

    public void clearBodySnake(){
        bodySnake.clear();
    }

    public Rectangle getCollider(){
        Coordinate head = bodySnake.peekLast();

        if(head == null){
            return null;
        }

        return new Rectangle(head.getX(),head.getY(),sizeWidth,sizeHeight);
    }
}
