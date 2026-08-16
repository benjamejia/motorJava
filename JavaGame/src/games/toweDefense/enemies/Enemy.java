package games.toweDefense.enemies;

import entities.Entity;
import world.Grid;

import java.awt.Rectangle;

public class Enemy extends Entity {
    private double health;
    private double damage;

    public Enemy(int col, int row, int health, int gold, double damage){
        super(col, row);
        this.health = health;
        this.gold = gold;
        this.damage = damage;
    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    private final int gold;
    private int currentStep = 0;
    
    public int getCurrentStep() {
        return currentStep;
    }
    
    public void setCurrentStep(int currentStep) {
        this.currentStep = currentStep;
    } 
    
    public double getHealth(){
        return health;
    }
    
    public void setHealth(double health) {
        this.health = health;
    }
    
    public int getGold(){
        return gold;
    }

    public Rectangle getCollider(){
        return new Rectangle(this.getCol() * Grid.TILE_SIZE, this.getRow() * Grid.TILE_SIZE,Grid.TILE_SIZE,Grid.TILE_SIZE);
    }
}