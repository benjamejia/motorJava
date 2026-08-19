package games.towerDefense.projectils;

import entities.Entity;
import games.towerDefense.enemies.Enemy;
import games.towerDefense.towers.Tower;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;

public class Projectil extends Entity {

    protected Enemy objective;
    protected Tower origin;
    protected double damage;
    protected double speed = 200;
    
    public Projectil(int col, int row, double damage, Enemy objective, Tower origin){
        super(col, row);
        this.damage = damage;
        this.objective = objective;
        this.origin = origin;
    }

    public void update(double deltaTime){
        if(objective == null){
            return;
        }

        double diferencialX = objective.getX() - origin.getX();
        double diferencialY = objective.getY() - origin.getY();

        double distance = Math.sqrt(
            diferencialX * diferencialX +
            diferencialY * diferencialY
        );

        if(distance > 0){
            double vectorUx = diferencialX / distance;
            double vectorUy = diferencialY / distance;

            setX(getX() + vectorUx * (speed * deltaTime));
            setY(getY() + vectorUy * (speed * deltaTime));
        }
    }

    public void draw(Graphics2D g2){
        
    }

    public Enemy getObjective() {
        return objective;
    }
    
    public double getSpeed() {
        return speed;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public Ellipse2D getCollider(){
        return new Ellipse2D.Double(getX(),getY(),20,20);
    }
}
