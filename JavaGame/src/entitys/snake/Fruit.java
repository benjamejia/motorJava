package entitys.snake;

import entitys.Entity;
import main.GamePanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import java.util.Random;

public class Fruit extends Entity {

    GamePanel gp;
    Random random = new Random();
    private int size = 10;

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

    public void drawColliders(Graphics g) {
        Color oldColor = g.getColor(); 
        
        g.setColor(Color.RED); 

        
        g.drawRect(getX(), getY(), size, size);
    

        g.setColor(oldColor);
    }
    
    public void draw(Graphics2D g2){
        g2.setColor(Color.red);
        g2.fillOval(getX(), getY(), size, size);
    }
}
