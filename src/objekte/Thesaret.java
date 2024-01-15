package objekte;

import main.KontrolleriLojes;

import java.awt.Rectangle;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;

public class Thesaret {
    public BufferedImage image;
    public String name;
    public boolean collision = false;
    public int x, y;
    public Rectangle solidArea = new Rectangle (0, 0, 60, 60);
    public int solidAreaDefaultX = 0;
    public int SolidAreaDefaultY = 0;

    public void draw(Graphics2D g2, KontrolleriLojes gp){

            g2.drawImage(image, x, y, gp.tileSize, gp.tileSize, null);

    }
}
