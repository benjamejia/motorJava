package games.towerDefense.projectils;

import games.towerDefense.enemies.Enemy;
import games.towerDefense.towers.Turret;
import java.awt.Color;
import java.awt.Graphics2D;

public class Bullet extends Projectil {

    public Bullet(int col, int row, double damage, Enemy objective, Turret origin){
        super(col, row, damage, objective, origin);
        this.speed = 50;
    }

    @Override
    public void draw(Graphics2D g2){
        g2.setColor(Color.GRAY);
        g2.fillOval((int)getX(), (int)getY(), 20,20);
    }

}
