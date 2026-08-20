package games.towerDefense.towers;

import entities.Entity;
import games.towerDefense.enemies.Enemy;
import java.awt.Graphics2D;
import java.util.List;
import util.ProjectilFactory;
import world.Grid;

public class Tower extends Entity{
    protected String name;
    protected int cost;
    protected int range;
    protected ProjectilFactory projectilFactory;

    public Tower(String name, int cost, int range, int col, int row, ProjectilFactory projectilFactory){
        this.name = name;
        this.cost = cost;
        this.range = range;
        this.projectilFactory = projectilFactory;
        super(col,row);
    }

    public void update(double deltaTime, List<Enemy> enemies){}

    public void draw(Graphics2D g2){
        g2.fillRect((int)getX(), (int)getY(),Grid.TILE_SIZE,Grid.TILE_SIZE);
    }

    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public int getRange() {
        return range;
    }

    public void setRange(int range) {
        this.range = range;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void attack(Enemy enemy, Turret tower){
        
    };
    
}
