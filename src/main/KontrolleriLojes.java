package main;

import entity.Lojtari;

import java.awt.*;
import javax.swing.JPanel;


public class KontrolleriLojes extends JPanel implements Runnable{

    final int originalTileSize = 20;
    final int scale = 3;

    public final int tileSize = originalTileSize * scale;
    final int maxScreenCol = 20;
    final int maxScreenRow = 15;
    final int screenWidth = tileSize * maxScreenCol;
    final int screenHeight = tileSize * maxScreenRow;

    //fps
    int fps = 60;
    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    Lojtari lojtar = new Lojtari(this, keyH);

    //set player's default position
    int lojtariX = 100;
    int lojtariY = 100;
    int lojtariShpejtesia = 4;
    public KontrolleriLojes(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void startGameThread(){
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {

        double drawInterval = 1000000000/fps; //perdorim nanosekonda, per llogaritje precise (0.01666 sekonda)
        double nextDrawTime = System.nanoTime() + drawInterval;

        while(gameThread != null){

            //1 Update: update information such as character position
            update();
            //2 Draw: draw the screen with updated information
            repaint();

            try {
                double remainingTime = nextDrawTime - System.nanoTime();
                remainingTime = remainingTime/1000000;

                if(remainingTime < 0){
                    remainingTime = 0;
                }
                Thread.sleep((long)remainingTime);

                nextDrawTime += drawInterval;
            } catch (InterruptedException e){
                e.printStackTrace();
            }
        }

    }

    public void update(){

       lojtar.update();

    }

    public void paintComponent(Graphics g){

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        lojtar.draw(g2);

        g2.dispose();

    }
}
