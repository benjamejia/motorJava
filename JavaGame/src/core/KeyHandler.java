package core;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    private boolean up,down,space,left,right;
    private int teclaActual = KeyEvent.VK_D; 
    private int teclaPresionada = 0;

    public void setTeclaPresionada(int teclaPresionada) {
        this.teclaPresionada = teclaPresionada;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int codigo = e.getKeyCode();
        teclaActual = e.getKeyCode();
        if(codigo == KeyEvent.VK_W) up = true;
        if(codigo == KeyEvent.VK_S) down = true;
        if(codigo == KeyEvent.VK_LEFT) left = true;
        if(codigo == KeyEvent.VK_RIGHT) right = true;
        if(codigo == KeyEvent.VK_SPACE) space = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int codigo = e.getKeyCode();
        teclaPresionada = e.getKeyCode();
        if(codigo == KeyEvent.VK_W) up = false;
        if(codigo == KeyEvent.VK_S) down = false;
        if(codigo == KeyEvent.VK_LEFT) left = false;
        if(codigo == KeyEvent.VK_RIGHT) right = false;
        if(codigo == KeyEvent.VK_SPACE) space = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {
       int codigo = e.getKeyCode();
        if(codigo == KeyEvent.VK_W) up = true;
        if(codigo == KeyEvent.VK_S) down = true;
        if(codigo == KeyEvent.VK_LEFT) left = true;
        if(codigo == KeyEvent.VK_RIGHT) right = true;
        if(codigo == KeyEvent.VK_SPACE) space = true;
    }

    public boolean consumeKey(int keyCode){
        if(teclaPresionada == keyCode){
            teclaPresionada = 0;
            return true;
        }
        return false;
    }

    public int getTeclaActual(){
        return teclaActual;
    }

    public int getTeclaPresionada(){
        return teclaPresionada;
    }

    public boolean isUp(){
        return up;
    }

    public boolean isDown(){
        return down;
    }

    public boolean isLeft(){
        return left;
    }

    public boolean isRight(){
        return right;
    }

    public boolean isSpace(){
        return space;
    }
}
