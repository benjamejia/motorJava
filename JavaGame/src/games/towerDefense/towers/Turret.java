package games.towerDefense.towers;

import games.towerDefense.enemies.Enemy;
import games.towerDefense.projectils.Projectil;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
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
        Projectil projectil = new Projectil(getCol(), getRow(), 10, objective, origin);
        bulletsActive.add(projectil);
    }

    public Rectangle getCollider(){
        return new Rectangle(getCol() * Grid.TILE_SIZE - Grid.TILE_SIZE,getRow() * Grid.TILE_SIZE - Grid.TILE_SIZE, Grid.TILE_SIZE * getRange(),Grid.TILE_SIZE * getRange());
    }

}
