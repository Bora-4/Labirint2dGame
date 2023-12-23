package main;

import entity.Lojtari;
import kuti.MenaxhimKutie;
import objekte.Thesaret;

import java.awt.*;
import javax.swing.JPanel;


public class KontrolleriLojes extends JPanel implements Runnable{

    final int originalTileSize = 20;
    final int scale = 3;

    public final int tileSize = originalTileSize * scale;
    public final int maxScreenCol = 20;
    public final int maxScreenRow = 15;
    public final int screenWidth = tileSize * maxScreenCol;
    public final int screenHeight = tileSize * maxScreenRow;



    //fps
    int fps = 60;
    MenaxhimKutie kutiM = new MenaxhimKutie(this);
    KeyHandler keyH = new KeyHandler();
    Thread gameThread;
    public KontrolluesCollision kontrollCollision = new KontrolluesCollision(this);
    public VendosAsetet vendosAsetet = new VendosAsetet(this);
    public Lojtari lojtar = new Lojtari(this, keyH);
    public Thesaret obj[] = new Thesaret[10]; // 10 dmth qe ne mund te shfaqim ne ekran 10 objekte ne te njejten kohe


    public KontrolleriLojes(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void setupGame(){
        vendosAsetet.vendosThesar();
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

        //kuti
        kutiM.draw(g2);

        //thesari
        for(int i = 0; i < obj.length; i++){
            if(obj[i] != null){
                obj[i].draw(g2,this);
            }
        }

        //lojtari
        lojtar.draw(g2);

        g2.dispose();

    }
}
