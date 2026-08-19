package games.towerDefense.levels;

import games.towerDefense.Player;
import games.towerDefense.towers.Tower;
import games.towerDefense.towers.Turret;
import java.awt.Graphics2D;

public class Level {

    private Player player;
    private final Round round;
    private final Tower tower;

    public Level(){
        round = new Round();
        tower = new Turret("Turret", 3, 4, 7, 3);
    }

    public void update(double  deltaTime){
        round.update(deltaTime);
    }

    public void draw(Graphics2D g2){
        round.draw(g2);
    }

    public Player getPlayer() {
        return player;
    }

    public Round getRound() {
        return round;
    }

    public Tower getTower() {
        return tower;
    }
}
