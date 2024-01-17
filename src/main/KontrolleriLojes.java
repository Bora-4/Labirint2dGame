package main;

import entity.Lojtari;
import kuti.MenaxhimKutie;
import objekte.SuperObject;

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
//    public boolean lojaMbaroi;


    //fps
    int fps = 60;

    //Sistemi
    MenaxhimKutie kutiM = new MenaxhimKutie(this);
    KeyHandler keyH = new KeyHandler(this);
    Muzike muzike = new Muzike();
    Muzike efektZanor = new Muzike();
    public KontrolluesCollision kontrollCollision = new KontrolluesCollision(this);
    public VendosAsetet vendosAsetet = new VendosAsetet(this);
    public UserInterface userInterface = new UserInterface(this);
    Thread gameThread;

    //lojatari dhe objektet
    public Lojtari lojtar = new Lojtari(this, keyH);
    public SuperObject obj[] = new SuperObject[10]; // 10 dmth qe ne mund te shfaqim ne ekran 10 objekte ne te njejten kohe

    //gjendja e lojes
    public int gameState;
    public final int titleState = 0;
    public final int playState = 1;
    public final int pauseState = 2;


    public KontrolleriLojes(){
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);
        this.addKeyListener(keyH);
        this.setFocusable(true);
    }

    public void setupGame(){

        vendosAsetet.setObjekte();

        playMusic(1);
        gameState = titleState;

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

        if(gameState == playState){
            lojtar.update();
        }
        if(gameState == pauseState){
            //asgje
        }

    }

    public void paintComponent(Graphics g){

        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        //titulli i ekranit
        if(gameState == titleState){
            userInterface.draw(g2);

        }
        //others
        else{
            //kuti
            kutiM.draw(g2);

            //objektet
            for(int i = 0; i < obj.length; i++){
                if(obj[i] != null){
                    obj[i].draw(g2,this);
                }
            }

            //lojtari
            lojtar.draw(g2);

            //user interface
            userInterface.draw(g2);

        }



        g2.dispose();

    }
    public void playMusic(int i) {

        muzike.setFile(i);
        muzike.play();
        muzike.loop();
    }
    public void stopMusic() {
        muzike.stop();
    }
    public void playSE(int i) {

        efektZanor.setFile(i);
        efektZanor.play();
    }
}