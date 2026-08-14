package games.toweDefense;

import java.awt.geom.Ellipse2D;
import entities.Entity;
import games.toweDefense.towers.Turret;
import world.Grid;

public class Projectil extends Entity {

    Enemy objective;
    Turret origin;
    double damage;

    public Projectil(int col, int row, double damage, Enemy objective, Turret origin){
        this.objective = objective;
        this.origin = origin;
        this.damage = damage;

        setX(col * Grid.TILE_SIZE);
        setY(row * Grid.TILE_SIZE);
    }

    public double getDamage() {
        return damage;
    }

    public void setDamage(double damage) {
        this.damage = damage;
    }

    public void shoot(Enemy objective, Turret origin){
        double diferencialX = objective.getX() - origin.getX();
        double diferencialY = objective.getY() - origin.getY();

        double sqrtDx = diferencialX * diferencialX;
        double sqrtDy = diferencialY * diferencialY;

        double distance = Math.sqrt(sqrtDx + sqrtDy);

        double vectorUx = diferencialX / distance;
        double vectorUy = diferencialY / distance;

        setX(getX() + vectorUx);
        setY(getY() + vectorUy);
    }

    public Ellipse2D getCollider(){
        return new Ellipse2D.Double(getX(),getY(),20,20);
    }
}
