package main;

import objekte.Thesari;
import objekte.Fundi;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class UserInterface {
    KontrolleriLojes gp;
    Graphics2D g2;
    Font cascadia;
    BufferedImage imazhThesari;
    BufferedImage backgroundImage; // Added for the background image
    public int nrKomande = 0;
    public boolean lojaMbaroi = false;
    public UserInterface(KontrolleriLojes gp) {
        this.gp = gp;
        cascadia = new Font("Cascadia Mono", Font.PLAIN, 40);
        Thesari thesari = new Thesari();
        imazhThesari = thesari.image;

        // Load the background image
        try {
            backgroundImage = ImageIO.read(new File("C:\\Users\\User\\IdeaProjects\\Labirint2dGame\\res\\background\\nata.jpg"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {

//        if(lojaMbaroi == true) {
//
//            g2.setFont(cascadia);
//            g2.setColor(Color.ORANGE);
//
//            String teksti;
//            int gjatesiaTekstit;
//            int x;
//            int y;
//
//            teksti = "FITUAT!";
//            gjatesiaTekstit = (int)g2.getFontMetrics().getStringBounds(teksti, g2).getWidth(); //na jep gjatesine e tekstit
//
//            x = gp.screenWidth/2 - gjatesiaTekstit/2;
//            y = gp.screenHeight/2 - (gp.tileSize*3);
//            g2.drawString(teksti, x, y);
//
//            gp.gameThread = null;
//
//        }

        g2.setFont(cascadia);
        g2.setColor(Color.ORANGE);
        g2.drawImage(imazhThesari, 5, 1, gp.tileSize, gp.tileSize, null);
        g2.drawString(": " + gp.lojtar.hasThesar, 5 + gp.tileSize, 14 + gp.tileSize / 2);

        this.g2 = g2;
        //title state
        if(gp.gameState == gp.titleState){
            drawTitleScreen();
        }
        //gjendja play
        if (gp.gameState == gp.playState) {
            // do playstate stuff later
        }
        //gjendja pause
        else if (gp.gameState == gp.pauseState) {
            drawPauseScreen();
        }
    }

    public void drawTitleScreen() {
        // Draw the background image
        g2.drawImage(backgroundImage, 0, 0, gp.screenWidth, gp.screenHeight, null);

        // Emri i titullit
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 70F));
        String text = "Sailor Moon Labyrinth";
        int x = getXperTekstinQendror(text);
        int y = gp.tileSize * 3;

        //shadow
        g2.setColor(Color.PINK);
        g2.drawString(text, x+3, y+3);

        //ngjyra kryesore
        g2.setColor(Color.MAGENTA);
        g2.drawString(text, x, y);

        //imazhi i Sailor Moon
        x = gp.screenWidth/2 - (gp.tileSize*3) ;
        y += gp.tileSize*2;
        g2.drawImage(gp.lojtar.poshte1, x, y, gp.tileSize*5, gp.tileSize*5, null);

        //MENU
        g2.setFont(g2.getFont().deriveFont(Font.BOLD, 60F));
        text = "Start";
        x = getXperTekstinQendror(text) ;
        y += gp.tileSize * 7;
        g2.drawString(text, x, y);
        if(nrKomande == 0){
            g2.drawString(">", x-gp.tileSize, y);
        }

        text = "Quit";
        x = getXperTekstinQendror(text) ;
        y += gp.tileSize;
        g2.drawString(text, x, y);
        if(nrKomande == 1){
            g2.drawString(">", x-gp.tileSize, y);
        }

    }

    public void drawPauseScreen() {
        g2.setFont(g2.getFont().deriveFont(Font.PLAIN, 80F));
        String text = "PAUSED";
        int x = getXperTekstinQendror(text);
        int y = gp.screenHeight / 2;

        g2.drawString(text, x, y);
    }

    public int getXperTekstinQendror(String text) {
        int gjatesia = (int) g2.getFontMetrics().getStringBounds(text, g2).getWidth();
        int x = gp.screenWidth / 2 - gjatesia / 2;
        return x;
    }
}
