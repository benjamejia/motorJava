package games.towerDefense.towers;

import entities.Entity;
import games.towerDefense.enemies.Enemy;
import games.towerDefense.projectils.Projectil;

public class Tower extends Entity{
    String name;
    int cost;
    int range;
    Projectil ammo;

    public Tower(String name, int cost, int range, int col, int row, Projectil typeAmmo){
        this.name = name;
        this.cost = cost;
        this.range = range;
        this.ammo = typeAmmo;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void attack(Enemy enemy, Turret tower){
        
    };

    public Projectil getAmmo() {
        return ammo;
    }

    public void setAmmo(Projectil ammo) {
        this.ammo = ammo;
    }
    
}
