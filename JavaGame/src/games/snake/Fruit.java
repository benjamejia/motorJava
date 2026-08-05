package games.snake;

import entities.Entity;
import java.awt.Rectangle;
import java.util.Random;

public class Fruit extends Entity {

    Random random = new Random();

    private final int size = 20;

    public Fruit(Coordinate intialPosition){
        setX(intialPosition.getX());
        setY(intialPosition.getY());
    }

    public int getSize(){
        return size;
    }

    public Rectangle getCollider(){
        return new Rectangle(getX(),getY(),size,size);
    }
}
