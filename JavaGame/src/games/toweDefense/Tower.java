package games.toweDefense;

import java.awt.Rectangle;

import core.GamePanel;
import entities.Entity;

public class Tower extends Entity{
    private int damage;
    private int range;
    private final int cost;

    public Tower(int col, int row, int damage, int range, int cost){
        setCol(col);
        setRow(row);
        this.damage = damage;
        this.range = range;
        this.cost = cost;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public int getDamage(){
        return damage;
    }

    public int getRange(){
        return range;
    }

    public int getCost(){
        return cost;
    }

    public Rectangle getCollider(){
        return new Rectangle(getCol() * GamePanel.SIZE_WIDTH, getRow() * GamePanel.SIZE_HEIGHT);
    }
}
