package games.toweDefense;

import entities.Entity;

public class Enemy extends Entity {
    private int health;
    private int gold;
    
    public Enemy(int x, int y, int health, int gold){
        setX(x);
        setY(y);
        this.health = health;
        this.gold = gold;
    }

    public int getHealth(){
        return health;
    }

    public int getGold(){
        return gold;
    }
}
