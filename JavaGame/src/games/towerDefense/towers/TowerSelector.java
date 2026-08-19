package games.towerDefense.towers;

import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

public class TowerSelector {
    private List<Tower> towers;
    private Rectangle bounds;
    private String text;
    private boolean isPressed;

    public TowerSelector(){
    }

    public void draw(Graphics2D g2){

    }

    public void addTower(Tower tower){
        towers.add(tower);
    }

    public List<Tower> getTowers(){
        return towers;
    }
}
