package main;

import objekte.Fundi;
import objekte.Thesari;


public class VendosAsetet {
    KontrolleriLojes gp;

    public VendosAsetet(KontrolleriLojes gp){
        this.gp = gp;
    }

    public void setObjekte(){

        gp.obj[0] = new Thesari();
        gp.obj[0].x = 12 * gp.tileSize;
        gp.obj[0].y = 7 * gp.tileSize;

        gp.obj[1] = new Thesari();
        gp.obj[1].x = 5 * gp.tileSize;
        gp.obj[1].y = 13 * gp.tileSize;

        gp.obj[2] = new Fundi();
        gp.obj[2].x = 18 * gp.tileSize;
        gp.obj[2].y = 13 * gp.tileSize;
    }
}
