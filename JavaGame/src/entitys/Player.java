package entitys;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import main.GamePanel;

public class Player extends Entity {

    GamePanel gp;
    int sizeWidth = 5;
    int sizeHeight = 60;

    public Player(GamePanel gp){
        this.gp = gp;

        x = 50;
        y = 50;
        speedX = 1;
        speedY = 1;
    }

    public void update(){
        //this.x += this.speedX;
        //this.y += this.speedY;
    }

    public Rectangle rectangle(){
        return new Rectangle(x,y,sizeWidth,sizeHeight);
    }

    public void draw(Graphics2D graphics2d){
        graphics2d.setColor(Color.white );
        graphics2d.fillRect(x, y, sizeWidth, sizeHeight);
    }
}
