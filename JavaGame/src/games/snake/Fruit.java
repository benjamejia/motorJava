package games.snake;

import entities.Entity;
import java.awt.Rectangle;
import world.Grid;

public class Fruit extends Entity {

    public Fruit(Coordinate initialPosition){
        super(initialPosition.getCol(),initialPosition.getRow());
    }
    
    public Rectangle getCollider(){
        return new Rectangle(getCol() * 20,getRow() * 20,Grid.TILE_SIZE,Grid.TILE_SIZE);
    }
}
