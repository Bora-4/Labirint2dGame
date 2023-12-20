package entity;

import main.KeyHandler;
import main.KontrolleriLojes;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Lojtari extends Entity {
    KontrolleriLojes gp;
    KeyHandler keyH;

    public Lojtari(KontrolleriLojes gp, KeyHandler keyH){

        this.gp = gp;
        this.keyH = keyH;

        setDefaultValues();
        getImazhLojtari();
    }

    public void setDefaultValues(){

        x = 100;
        y = 100;
        shpejtesia = 4;
        drejtimi = "poshte";

    }

    public void getImazhLojtari(){

        try{
            lart1 = ImageIO.read(getClass().getResourceAsStream("/lojtari/leviz_lart_1.png"));
            lart2 = ImageIO.read(getClass().getResourceAsStream("/lojtari/leviz_lart_2.png"));
            poshte1 = ImageIO.read(getClass().getResourceAsStream("/lojtari/leviz_poshte_1.png"));
            poshte2 = ImageIO.read(getClass().getResourceAsStream("/lojtari/leviz_poshte_2.png"));
            majtas1 = ImageIO.read(getClass().getResourceAsStream("/lojtari/leviz_majtas_1.png"));
            majtas2 = ImageIO.read(getClass().getResourceAsStream("/lojtari/leviz_majtas_2.png"));
            djathtas1 = ImageIO.read(getClass().getResourceAsStream("/lojtari/leviz_djathtas_1.png"));
            djathtas2 = ImageIO.read(getClass().getResourceAsStream("/lojtari/leviz_djathtas_2.png"));

        }catch(IOException e){
            e.printStackTrace();
        }
    }
    public void update(){

        if(keyH.levizLart == true){
            drejtimi = "lart";
            y -= shpejtesia;
        } else if (keyH.levizPoshte == true) {
            drejtimi = "poshte";
            y += shpejtesia;
        } else if (keyH.levizMajtas == true) {
            drejtimi = "majtas";
            x -= shpejtesia;
        } else if (keyH.levizDjathtas == true) {
            drejtimi = "djathtas";
            x += shpejtesia;
        }

    }
    public void draw(Graphics2D g2){

        //g2.setColor(Color.white);
        //g2.fillRect(x, y, gp.tileSize, gp.tileSize);

        BufferedImage image = null;

        switch(drejtimi){
            case "lart":
                image = lart1;
                break;
            case "poshte":
                image = poshte1;
                break;
            case "majtas":
                image = majtas1;
                break;
            case "djathtas":
                image = djathtas1;
                break;
        }

        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }
}
