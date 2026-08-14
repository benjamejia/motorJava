package games.toweDefense.towers;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

import games.toweDefense.Enemy;
import games.toweDefense.Projectil;
import games.toweDefense.Tower;
import world.Grid;

public class Turret extends Tower {

    List<Projectil> bulletsActive;

    public Turret(String name, int cost, int range, int col, int row) {
        super(name, cost, range, col, row);

        bulletsActive = new ArrayList<>();
    }

    public List<Projectil> getBulletsActive() {
        return bulletsActive;
    }

    public void setBulletsActive(List<Projectil> bulletsActive) {
        this.bulletsActive = bulletsActive;
    }

    @Override
    public void attack(Enemy objective, Turret origin){
        Projectil projectil = new Projectil(getCol(), getRow(), getCol(), objective, origin);
        projectil.shoot(objective, origin);
        bulletsActive.add(projectil);
        
        if(projectil.getCollider().intersects(getCollider())){
            objective.setHealth(objective.getHealth() - projectil.getDamage());
            bulletsActive.removeFirst();
        }
    }

    public Rectangle getCollider(){
        return new Rectangle(getCol() * Grid.TILE_SIZE - Grid.TILE_SIZE,getRow() * Grid.TILE_SIZE - Grid.TILE_SIZE, Grid.TILE_SIZE * getRange(),Grid.TILE_SIZE * getRange());
    }

}
