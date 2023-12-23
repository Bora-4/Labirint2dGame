package entity;

import java.awt.*;
import java.awt.image.BufferedImage;

public class Entity {

    public int x, y;
    public int shpejtesia;

    public BufferedImage lart1, lart2, poshte1, poshte2, majtas1, majtas2, djathtas1, djathtas2;
    public String drejtimi;

    public int spriteCounter = 0;
    public int spriteNum = 1;
    public Rectangle solidArea;
    public int solidAreaDefaultX, solidAreaDefaultY;
    public boolean collisionOn = false;


}
