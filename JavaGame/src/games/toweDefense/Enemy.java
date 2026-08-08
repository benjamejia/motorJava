package games.toweDefense;

import entities.Entity;
import java.awt.Rectangle;

import core.GamePanel;

public class Enemy extends Entity {
    private int health;
    private int damage;
    
    private final int gold;
    private int currentStep = 0;
    
    public int getCurrentStep() {
        return currentStep;
    }
    
    public void setCurrentStep(int currentStep) {
        this.currentStep = currentStep;
    }
    
    public Enemy(int col, int row, int health, int gold, int damage){
        setCol(col);
        setRow(row);
        this.health = health;
        this.gold = gold;
        this.damage = damage;
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

    public int getDamage() {
        return damage;
    }
    
    public void setDamage(int damage) {
        this.damage = damage;
    }

    public Rectangle getCollider(){
        return new Rectangle(this.getCol() * GamePanel.SIZE_WIDTH, this.getRow() * GamePanel.SIZE_HEIGHT);
    }
}