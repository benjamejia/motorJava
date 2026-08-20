package games.towerDefense.level;

import games.towerDefense.Player;
import games.towerDefense.enemies.Enemy;
import games.towerDefense.projectils.Bullet;
import games.towerDefense.towers.Tower;
import games.towerDefense.towers.Turret;
import java.awt.Graphics2D;
import java.awt.Point;
import java.util.ArrayList;
import java.util.List;
import world.Coordinate;
import world.Grid;

public class Level {

    private Player player;
    private Tower tower;
    private final Round round;
    private final List<Tower> towers;
    private final Grid map;

    public Level(){
        round = new Round();
        towers = new ArrayList<>();
        map = new Grid();
        map.initializedMap(tower);
    }

    public void update(double  deltaTime){
        round.update(deltaTime);

        List<Enemy> enemies = round.getEnemies();

        synchronized (towers) {
            for(Tower tw : towers){
                tw.update(deltaTime,enemies);
            }
        }
    }

    public void draw(Graphics2D g2){
        round.draw(g2);

        synchronized (towers) {
            for(Tower tw : towers){
                tw.draw(g2);
            }
        }
    }

    public void addTower(Point point){
        Coordinate towerCoordinate = new Coordinate(point.x / Grid.TILE_SIZE, point.y / Grid.TILE_SIZE);
        Coordinate[] pathEnemies = round.getPath();
        for(Coordinate c : pathEnemies){
            if(towerCoordinate.getCol() == c.getCol() && towerCoordinate.getRow() == c.getRow()) return;
        }
        synchronized (towers) {
            map.addObject(
                new Turret("Torreta", 50, 1, point.x / Grid.TILE_SIZE, point.y / Grid.TILE_SIZE, Bullet::new),
                towerCoordinate
            );
        }
    }

    public Player getPlayer() {
        return player;
    }

    public Round getRound() {
        return round;
    }

    public List<Tower> getTower() {
        return towers;
    }
}
