package games.towerDefense.towers;

import games.towerDefense.enemies.Enemy;
import games.towerDefense.projectils.Projectil;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import util.ProjectilFactory;
import world.Grid;

public class Turret extends Tower {

    protected final List<Projectil> bulletsActive;
    private final ProjectilFactory projectilFactory;

    public Turret(String name, int cost, int range, int col, int row, Projectil typeAmmo, ProjectilFactory projectilFactory) {
        super(name, cost, range, col, row, typeAmmo);
        this.projectilFactory = projectilFactory;
        bulletsActive = new ArrayList<>();
    }

    public void update(double deltaTime){
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

    public void draw(Graphics2D g2){
        for(Projectil projectil : bulletsActive){
            projectil.draw(g2);
        }
    }

    public List<Projectil> getBulletsActive() {
        return bulletsActive;
    }

    @Override
    public void attack(Enemy objective, Turret origin){
        Projectil projectil = projectilFactory.create(getCol(), getRow(), 10, objective, origin);
        bulletsActive.add(projectil);
    }

    public Rectangle getCollider(){
        return new Rectangle(getCol() * Grid.TILE_SIZE - Grid.TILE_SIZE,getRow() * Grid.TILE_SIZE - Grid.TILE_SIZE, Grid.TILE_SIZE * getRange(),Grid.TILE_SIZE * getRange());
    }

}
