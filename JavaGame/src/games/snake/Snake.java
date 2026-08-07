package games.snake;

import entities.Entity;
import java.awt.Rectangle;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Collections;
import java.util.Deque;


public class Snake extends Entity{

    private int score = 0;
    private final int tileSize;
    private final Deque<Coordinate> bodySnake = new ArrayDeque<>();
    
    public Snake(Coordinate initialPosition, int tileSize){
        clearBodySnake();
        setCol(initialPosition.getCol());
        setRow(initialPosition.getRow());
        bodySnake.add(initialPosition);
        bodySnake.add(new Coordinate(initialPosition.getCol() + 1, initialPosition.getRow()));

        this.tileSize = tileSize;
    }

    public void increaseScore(int increase){
        score += increase;
    }

    public void addBody(Coordinate coordinate){
        bodySnake.add(new Coordinate(coordinate.getCol(),coordinate.getRow()));
    }

    public void addBodyLast(Coordinate coordinate){
        bodySnake.addLast(new Coordinate(coordinate.getCol(), coordinate.getRow()));
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

    public void clearBodySnake(){
        bodySnake.clear();
    }

    public Rectangle getCollider(){
        Coordinate head = bodySnake.peekLast();

        if(head == null){
            return null;
        }

        return new Rectangle(head.getCol() * 20, head.getRow() * 20, tileSize,tileSize);
    }
}
