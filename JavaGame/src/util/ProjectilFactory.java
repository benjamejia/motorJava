package util;

import games.towerDefense.enemies.Enemy;
import games.towerDefense.projectils.Projectil;
import games.towerDefense.towers.Turret;

@FunctionalInterface
public interface ProjectilFactory {
    Projectil create(int col, int row, double damage, Enemy objective, Turret origin);
}
