package games.towerDefense.towers;

import entities.Entity;
import games.towerDefense.enemies.Enemy;

public abstract class Tower extends Entity{

    String name;
    int cost;
    int range;

    public Tower(String name, int cost, int range, int col, int row){
        this.name = name;
        this.cost = cost;
        this.range = range;
        super(col,row);
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public abstract void attack(Enemy enemy, Turret tower);
    
}
