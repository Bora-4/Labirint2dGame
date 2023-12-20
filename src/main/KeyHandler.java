package main;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {

    public boolean levizLart, levizPoshte, levizMajtas, levizDjathtas;
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();

        if(code == KeyEvent.VK_W){
            levizLart = true;
        }
        if(code == KeyEvent.VK_S){
            levizPoshte = true;
        }
        if(code == KeyEvent.VK_A){
            levizMajtas = true;
        }
        if(code == KeyEvent.VK_D){
            levizDjathtas = true;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

        int code = e.getKeyCode();

        if(code == KeyEvent.VK_W){
            levizLart = false;
        }
        if(code == KeyEvent.VK_S){
            levizPoshte = false;
        }
        if(code == KeyEvent.VK_A){
            levizMajtas = false;
        }
        if(code == KeyEvent.VK_D){
            levizDjathtas = false;
        }
    }
}
