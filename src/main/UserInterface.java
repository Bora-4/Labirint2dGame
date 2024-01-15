//package main;
//
//import objekte.Thesari_1;
//
//import java.awt.*;
//import java.awt.image.BufferedImage;
//
//public class UserInterface {
//    KontrolleriLojes gp;
//    Font cascadia;
//    BufferedImage imazhThesari;
//    public UserInterface(KontrolleriLojes gp){
//        this.gp = gp;
//        cascadia = new Font("Cascadia Mono" , Font.PLAIN, 40);
//        Thesari_1 thesari1 = new Thesari_1();
//        imazhThesari = thesari1.image;
//    }
//
//    public void draw(Graphics2D g2){
//        g2.setFont(cascadia);
//        g2.setColor(Color.CYAN);
//        int imageY = 5;
//        g2.drawImage(imazhThesari, 10,  imageY, gp.tileSize, gp.tileSize, null);
//        g2.drawString(": " + gp.lojtar.hasThesar1, 10 + gp.tileSize, 10 + gp.tileSize / 2 );
//    }
//}