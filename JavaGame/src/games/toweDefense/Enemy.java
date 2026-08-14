package games.toweDefense;

import entities.Entity;
import java.awt.Rectangle;

import core.GamePanel;

public class Enemy extends Entity {
    private double health;
    private double damage;

    public Enemy(int col, int row, int health, int gold, double damage){
        setCol(col);
        setRow(row);
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
        return new Rectangle(this.getCol() * GamePanel.SIZE_WIDTH, this.getRow() * GamePanel.SIZE_HEIGHT);
    }
}