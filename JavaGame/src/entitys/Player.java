package entitys;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import main.GamePanel;
import main.KeyHandler;

public class Player extends Entity{

    GamePanel gp;
    KeyHandler kh;
    int sizeWidth = 5;
    int sizeHeight = 60;
    int lifes;

    public Player(GamePanel gp, KeyHandler kh){
        this.gp = gp;
        this.kh = kh;
        x = 50;
        y = 50;
        speedX = 1;
        speedY = 1;
        lifes = 3;
    }

    public void update(){
        if(kh.arriba == true) y -= speedY;
        if(kh.abajo == true) y += speedY;
        if(kh.espacio == true){
            speedY = 2; 
        }else{
            speedY = 1;
        }

        if(y < 0){
            y = 0;
        }else if(y + sizeHeight > this.gp.getHeight()){
            y = gp.getHeight() - sizeHeight;
        }

        if(gp.ball.x == 1){
            lifes --;
            gp.ball.x = 500;
            gp.ball.y = 0;
            gp.ball.speedX = -1;
            gp.ball.speedY = 1;
        }else if(lifes == 0){
            gp.ball.x = 500;
            gp.ball.y = 0;
            gp.ball.speedX = 0;
            gp.ball.speedY = 0;
        }
    }

    public Rectangle rectangle(){
        return new Rectangle(x,y,sizeWidth,sizeHeight);
    }

    public void draw(Graphics2D graphics2d){
        graphics2d.setColor(Color.white );
        graphics2d.fillRect(x, y, sizeWidth, sizeHeight);
        graphics2d.drawString("HP:" + lifes, 500, 20);
    }

}
