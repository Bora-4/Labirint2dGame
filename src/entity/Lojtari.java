package entity;

import main.*;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Lojtari extends Entity {
    KontrolleriLojes gp;
    KeyHandler keyH;
    public int hasThesar = 0;
    //deklaroj dhe inicializoj me 0 nje variabel te tille si kjo me siper per thesaret qe do beje anasia sprite


    public Lojtari(KontrolleriLojes gp, KeyHandler keyH) {

        this.gp = gp;
        this.keyH = keyH;

        solidArea = new Rectangle(10, 20, 40, 40);
        solidArea.x = 10;
        solidArea.y = 20;
        solidAreaDefaultX = solidArea.x;
        solidAreaDefaultY = solidArea.y;
        solidArea.width = 40;
        solidArea.height = 40;

        setDefaultValues();
        getImazhLojtari();
    }

    public void setDefaultValues() {

        x = gp.tileSize;
        y = gp.tileSize;
        shpejtesia = 4;
        drejtimi = "poshte";

    }

    public void getImazhLojtari() {

        try {
            lart1 = ImageIO.read(getClass().getResourceAsStream("/lojtari/leviz_lart_1.png"));
            lart2 = ImageIO.read(getClass().getResourceAsStream("/lojtari/leviz_lart_2.png"));
            poshte1 = ImageIO.read(getClass().getResourceAsStream("/lojtari/leviz_poshte_1.png"));
            poshte2 = ImageIO.read(getClass().getResourceAsStream("/lojtari/leviz_poshte_2.png"));
            majtas1 = ImageIO.read(getClass().getResourceAsStream("/lojtari/leviz_majtas_1.png"));
            majtas2 = ImageIO.read(getClass().getResourceAsStream("/lojtari/leviz_majtas_2.png"));
            djathtas1 = ImageIO.read(getClass().getResourceAsStream("/lojtari/leviz_djathtas_1.png"));
            djathtas2 = ImageIO.read(getClass().getResourceAsStream("/lojtari/leviz_djathtas_2.png"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void update() {

        if (keyH.levizLart == true || keyH.levizPoshte == true || keyH.levizDjathtas == true || keyH.levizMajtas == true) {
            if (keyH.levizLart == true) {
                drejtimi = "lart";
            } else if (keyH.levizPoshte == true) {
                drejtimi = "poshte";
            } else if (keyH.levizMajtas == true) {
                drejtimi = "majtas";
            } else if (keyH.levizDjathtas == true) {
                drejtimi = "djathtas";
            }

            //kontrolloj nqs ka collision ne kuti
            collisionOn = false;
            gp.kontrollCollision.kontrolloKuti(this);

            //kontrolloj collision thesari
            int objIndex = gp.kontrollCollision.kontrolloThesarin(this, true);
            merrThesarin(objIndex);
            //nqs collision eshte false, lojtari mund te levize
            if (collisionOn == false) {
                switch (drejtimi) {
                    case "lart":
                        y -= shpejtesia;
                        break;
                    case "poshte":
                        y += shpejtesia;
                        break;
                    case "majtas":
                        x -= shpejtesia;
                        break;
                    case "djathtas":
                        x += shpejtesia;
                        break;
                }
            }
            spriteCounter++;
            if (spriteCounter > 12) { //cdo 12 frames ndryshon figura
                if (spriteNum == 1) {
                    spriteNum = 2;
                } else if (spriteNum == 2) {
                    spriteNum = 1;
                }
                spriteCounter = 0;
            }
        }

    }

    public void merrThesarin(int i) {
        if (i != 299 && gp.obj[i] != null) {
            String emriObjektit = gp.obj[i].name; // Accessing name property here

            switch (emriObjektit) {
                case "Thesari":
                    gp.playSE(0);
                    hasThesar++;
                    gp.obj[i] = null;
                    System.out.println("Thesare te mbledhura:" + hasThesar);
                    break;

            }
        }
    }

    public void draw(Graphics2D g2) {


        BufferedImage image = null;

        switch (drejtimi) {
            case "lart":
                if (spriteNum == 1) {
                    image = lart1;
                }
                if (spriteNum == 2) {
                    image = lart2;
                }
                break;
            case "poshte":
                if (spriteNum == 1) {
                    image = poshte1;
                }
                if (spriteNum == 2) {
                    image = poshte2;
                }
                break;
            case "majtas":
                if (spriteNum == 1) {
                    image = majtas1;
                }
                if (spriteNum == 2) {
                    image = majtas2;
                }
                break;
            case "djathtas":
                if (spriteNum == 1) {
                    image = djathtas1;
                }
                if (spriteNum == 2) {
                    image = djathtas2;
                }
                break;
        }

        g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);
    }
}