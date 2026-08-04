package games.snake;

import core.GamePanel;
import entities.Entity;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.util.Random;

public class Fruit extends Entity {

    GamePanel gp;
    Random random = new Random();
    private final int size = 20;

    public Fruit(GamePanel gp){
        this.gp = gp;
        setX(50);
        setY(100);
    }

    public Rectangle getCollider(){
        return new Rectangle(getX(),getY(),size,size);
    }

    public void foodSpawn(){
        setX(random.nextInt(gp.getWidth() - size * 2));
        setY(random.nextInt(gp.getHeight() - size * 2));
    }
    
    public void draw(Graphics2D g2){
        g2.setColor(Color.red);
        g2.fillOval(getX(), getY(), size, size);
    }
}
