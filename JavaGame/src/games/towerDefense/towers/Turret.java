package games.towerDefense.towers;

import games.towerDefense.enemies.Enemy;
import games.towerDefense.projectils.Projectil;
import java.awt.Graphics2D;
import java.awt.geom.Ellipse2D;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import util.ProjectilFactory;
import world.Grid;

public class Turret extends Tower {

    private double attackTime = 0.0;
    private final double shootInterval = .80;
    protected final List<Projectil> bulletsActive;

    public Turret(String name, int cost, int range, int col, int row, ProjectilFactory projectilFactory) {
        super(name, cost, range, col, row, projectilFactory);
        bulletsActive = new ArrayList<>();
    }

    @Override
    public void update(double deltaTime, List<Enemy> enemies){
            attackTime += deltaTime;

            if(attackTime >= shootInterval){
               synchronized (enemies) {
                for(Enemy enemy : enemies) {
                    if(enemy != null && !enemy.isDeath() && enemyOnRange(enemy)){
                        attack(enemy, this);
                        attackTime = 0;
                        break;
                    }
                }
            }
            }
            synchronized (bulletsActive) {
                Iterator<Projectil> iterator =
                    bulletsActive.iterator();
        
                while (iterator.hasNext()) {
        
                    Projectil projectil = iterator.next();
                    projectil.update(deltaTime);
                    
                    Enemy enemy = projectil.getObjective();
        
                    if (enemy == null) {
                        iterator.remove();
                        continue;
                    }

                    if (projectil.getCollider().intersects(
                            enemy.getCollider())) {
        
                        enemy.setHealth(enemy.getHealth() - projectil.getDamage());
                        iterator.remove();
                    }
                }
            }
    }

    @Override
    public void draw(Graphics2D g2){
        g2.fillRect((int)getX(), (int)getY(),Grid.TILE_SIZE,Grid.TILE_SIZE);

        synchronized (bulletsActive) {
            for(Projectil projectil : bulletsActive){
                projectil.draw(g2);
            }
        }
    }

    public List<Projectil> getBulletsActive() {
        return bulletsActive;
    }

    @Override
    public void attack(Enemy objective, Turret origin){
        Projectil projectil = projectilFactory.create(getCol(), getRow(), objective, origin);
        synchronized (bulletsActive) {
            bulletsActive.add(projectil);
        }
    }

    public boolean enemyOnRange(Enemy enemy){
        return (getCollider().intersects(enemy.getCollider()));
    }

    public Ellipse2D getCollider() {
        // Centro exacto de la torre en píxeles
        double centerX = (getCol() + 0.5) * Grid.TILE_SIZE;
        double centerY = (getRow() + 0.5) * Grid.TILE_SIZE;

        // Radio en píxeles (ej. range casillas de distancia)
        double radiusInPixels = (range + 0.5) * Grid.TILE_SIZE;
        double diameter = radiusInPixels * 2;

        return new Ellipse2D.Double(
            centerX - radiusInPixels,
            centerY - radiusInPixels,
            diameter,
            diameter
        );
    }

    public double getShootInterval() {
        return shootInterval;
    }
}
