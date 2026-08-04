package games.pong;

import core.GamePanel;
import entities.Entity;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Ball extends Entity {
    
    GamePanel gp;
    private final int size = 5;
    private int  speedX = 10;
    private int  speedY = 10;

    public Ball(GamePanel gp){
        this.gp = gp;
        setX(500);
        setY(0);
    }

    public void update(){
        setX(getX() + speedX);
        setY(getY() + speedY);

        if(getX() <= 0 || getX() >= this.gp.getWidth() - size){
            speedX *= -1;
        }
        if(getY() <= 0 || getY() >= this.gp.getHeight() - size){
            speedY *= -1;
        }

        //if(getCollider().intersects(gp.player.rectangle())){
        //     speedX *= -1;
        //     x = this.gp.player.x + this.gp.player.sizeWidth;
        // };
    }

    public Rectangle getCollider(){
        return new Rectangle(getX(),getY(),size,size);
    }

    public void draw(Graphics2D g2){
        g2.setColor(Color.white);
        g2.fillOval(getX(),getY(), 5, 5);
    }
}
