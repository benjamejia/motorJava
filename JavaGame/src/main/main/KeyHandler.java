package main;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean arriba,abajo,espacio;//,izquierda,derecha;

    @Override
    public void keyPressed(KeyEvent e) {
        int codigo = e.getKeyCode();
        if(codigo == KeyEvent.VK_W) arriba = true;
        if(codigo == KeyEvent.VK_S) abajo = true;
        if(codigo == KeyEvent.VK_SPACE) espacio = true;
        //if(codigo == KeyEvent.VK_LEFT) izquierda = true;
        //if(codigo == KeyEvent.VK_RIGHT) derecha = true;
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int codigo = e.getKeyCode();
        if(codigo == KeyEvent.VK_W) arriba = false;
        if(codigo == KeyEvent.VK_S) abajo = false;
        if(codigo == KeyEvent.VK_SPACE) espacio = false;
        //if(codigo == KeyEvent.VK_LEFT) izquierda = false;
        //if(codigo == KeyEvent.VK_RIGHT) derecha = false;
    }

    @Override
    public void keyTyped(KeyEvent e) {
       
    }

}
