package games.pong;

import core.GamePanel;
import core.KeyHandler;
import entities.Entity;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Player extends Entity{
    
    GamePanel gp;
    KeyHandler kh;
    private final int sizeWidth = 5;
    private final int sizeHeight = 60;
    private final int lifes;
    private int speedY;

    public Player(GamePanel gp, KeyHandler kh){
        super();
        this.gp = gp;
        this.kh = kh;
        setX(50);
        setY(50);
        lifes = 3;
    }

    public void update(){
        if(kh.isUp() == true) setY(getY() - speedY);
        if(kh.isDown() == true) setY(getY() + speedY);
        if(kh.isSpace() == true){
            speedY = 2; 
        }else{
            speedY = 1;
        }

        if(getY() < 0){
            setY(0);
        }else if(getY() + sizeHeight > this.gp.getHeight()){
           setY(gp.getHeight() - sizeHeight);
        }

        // if(gp.ball.x == 1){
        //     lifes --;
        //     gp.ball.x = 500;
        //     gp.ball.y = 0;
        //     gp.ball.speedX = -1;
        //     gp.ball.speedY = 1;
        // }else if(lifes == 0){
        //     gp.ball.x = 500;
        //     gp.ball.y = 0;
        //     gp.ball.speedX = 0;
        //     gp.ball.speedY = 0;
        // }
    }

    public Rectangle rectangle(){
        return new Rectangle(getX(),getY(),sizeWidth,sizeHeight);
    }

    public void draw(Graphics2D graphics2d){
        graphics2d.setColor(Color.white );
        graphics2d.fillRect(getX(),getY(), sizeWidth, sizeHeight);
        graphics2d.drawString("HP:" + lifes, 500, 20);
    }

}
