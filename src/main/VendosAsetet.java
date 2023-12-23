package main;

import objekte.Thesari_1;


public class VendosAsetet {
    KontrolleriLojes gp;

    public VendosAsetet(KontrolleriLojes gp){
        this.gp = gp;
    }

    public void vendosThesar(){

        gp.obj[0] = new Thesari_1();
        gp.obj[0].x = 18 * gp.tileSize;
        gp.obj[0].y = 12 * gp.tileSize;

        gp.obj[1] = new Thesari_1();
        gp.obj[1].x = 5 * gp.tileSize;
        gp.obj[1].y = 13 * gp.tileSize;
    }
}
