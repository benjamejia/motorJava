package games.towerDefense.enemies;

import entities.Entity;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import world.Coordinate;
import world.Grid;

public class Enemy extends Entity {
    private double health;
    private double damage;
    private final int gold;
    private int currentStep;

    private Coordinate target;
    private double speed = 300.0;
    
    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public Enemy(int col, int row){
        super(col, row);
        health = 20;
        damage = 10;
        gold = 15;
        currentStep = 0;
    }

    public void update(double deltaTime, Coordinate[] path){
        if(currentStep >= path.length) return;

        target = path[currentStep];

        double dx = target.getX() - getX(); 
        double dy = target.getY() - getY();

        double distance = Math.sqrt(
            dx * dx + 
            dy * dy
        );

        double step = speed * deltaTime;

        if(distance < step){
            setX(target.getX());
            setY(target.getY());
            currentStep++;
        }else{
            double vectorUx = dx / distance;
            double vectorUy = dy / distance;

            setX(getX() + vectorUx * (step));
            setY(getY() + vectorUy * (step));
        }
    }

    public void draw(Graphics2D g2){
         g2.fillRect(
                (int)getX(),
                (int)getY(),
                Grid.TILE_SIZE, 
                Grid.TILE_SIZE
        );
        g2.drawRect(getCollider().x, getCollider().y, getCollider().width, getCollider().height);
    }

    public boolean isDeath(){
        return health <= 0;
    }

    public boolean hasReachedEnd(int pathLenght){
        return currentStep >= pathLenght;
    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    
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
        return new Rectangle((int)this.getX(), (int)this.getY(),Grid.TILE_SIZE,Grid.TILE_SIZE);
    }
}