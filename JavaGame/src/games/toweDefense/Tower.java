package games.toweDefense;

import entities.Entity;

public class Tower extends Entity{
    private int damage;
    private int range;
    private int cost;

    public Tower(int x, int y, int damage, int range, int cost){
        setX(x);
        setY(y);
        this.damage = damage;
        this.range = range;
        this.cost = cost;
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
}
