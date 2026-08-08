package games.toweDefense;

import entities.Entity;
import java.awt.Rectangle;

public class Enemy extends Entity {
    private int health;
    private final int gold;
    
    public Enemy(int col, int row, int health, int gold){
        setCol(col);
        setRow(row);
        this.health = health;
        this.gold = gold;
    }

    public int getHealth(){
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getGold(){
        return gold;
    }

    Rectangle getCollision(){
        return new Rectangle();
    }
}
