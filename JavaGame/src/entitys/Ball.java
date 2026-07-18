package entitys;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import main.GamePanel;

public class Ball extends Entity {
    
    GamePanel gp;
    int size = 5;

    public Ball(GamePanel gp){
        this.gp = gp;
        x = 500;
        y = 0;
        speedX = -1;
        speedY = 1;
    }

    public void update(){
        this.x += speedX;
        this.y += speedY;

        if(this.x <= 0 || this.x >= this.gp.getWidth() - size){
            speedX *= -1;
        }
        if(this.y <= 0 || this.y >= this.gp.getHeight() - size){
            speedY *= -1;
        }

        if(getCollider().intersects(gp.player.rectangle())){
            speedX *= -1;
            x = this.gp.player.x + this.gp.player.sizeWidth;
        };
    }

    public Rectangle getCollider(){
        return new Rectangle(x,y,size,size);
    }

    public void draw(Graphics2D g2){
        g2.setColor(Color.white);
        g2.fillOval(x, y, 5, 5);
    }
}
