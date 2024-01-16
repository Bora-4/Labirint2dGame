package main;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyHandler implements KeyListener {
    KontrolleriLojes gp;

    public boolean levizLart, levizPoshte, levizMajtas, levizDjathtas;
    public KeyHandler(KontrolleriLojes gp){
        this.gp = gp;
    }
    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

        int code = e.getKeyCode();
        //title state
        if(gp.gameState == gp.titleState){
            if(code == KeyEvent.VK_W){
                gp.userInterface.nrKomande--;
                if(gp.userInterface.nrKomande < 0){
                    gp.userInterface.nrKomande = 1;
                }
            }
            if(code == KeyEvent.VK_S) {
                gp.userInterface.nrKomande++;
                if(gp.userInterface.nrKomande > 1){
                    gp.userInterface.nrKomande = 0;
                }
            }
            if(code == KeyEvent.VK_ENTER){
                if(gp.userInterface.nrKomande ==0){
                    gp.gameState = gp.playState;

                }
                if(gp.userInterface.nrKomande == 1){
                    System.exit(0);
                }
            }
        }

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
        if(code == KeyEvent.VK_P){
            if(gp.gameState == gp.playState){
                gp.gameState = gp.pauseState;
            }
            else if(gp.gameState == gp.pauseState){
                gp.gameState = gp.playState;
            }
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
