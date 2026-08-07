package games.snake;

import entities.Entity;
import java.awt.Rectangle;
import java.util.Random;

public class Fruit extends Entity {

    Random random = new Random();

    private final int tileSize;

    public Fruit(Coordinate intialPosition, int tileSize){
        setCol(intialPosition.getCol());
        setRow(intialPosition.getRow());

        this.tileSize = tileSize;
    }
    
    public Rectangle getCollider(){
        return new Rectangle(getCol() * 20,getRow() * 20,tileSize,tileSize);
    }
}
