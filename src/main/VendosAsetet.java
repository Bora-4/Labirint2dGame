package main;

import objekte.Fundi;
import objekte.Thesari;
import labirint.Labirinti;


public class VendosAsetet {
    KontrolleriLojes gp;
    Labirinti labirinti;


    public VendosAsetet(KontrolleriLojes gp){
        this.gp = gp;
        this.labirinti = new Labirinti(gp);
    }

    public void setObjekte(){
        int labirintiZgjedhur = labirinti.getLabirintiIndex();

        if(labirintiZgjedhur == 0) {
            gp.obj[0] = new Thesari();
            gp.obj[0].x = 3 * gp.tileSize;
            gp.obj[0].y = 6 * gp.tileSize;

            gp.obj[1] = new Thesari();
            gp.obj[1].x = 5 * gp.tileSize;
            gp.obj[1].y = 13 * gp.tileSize;

            gp.obj[2] = new Thesari();
            gp.obj[2].x = 14 * gp.tileSize;
            gp.obj[2].y = 11 * gp.tileSize;

            gp.obj[3] = new Thesari();
            gp.obj[3].x = 11 * gp.tileSize;
            gp.obj[3].y = 6 * gp.tileSize;

            gp.obj[4] = new Thesari();
            gp.obj[4].x = 7 * gp.tileSize;
            gp.obj[4].y = 1 * gp.tileSize;


        } else if (labirintiZgjedhur == 1) {
            gp.obj[0] = new Thesari();
            gp.obj[0].x = 5 * gp.tileSize;
            gp.obj[0].y = 1 * gp.tileSize;

            gp.obj[1] = new Thesari();
            gp.obj[1].x = 7 * gp.tileSize;
            gp.obj[1].y = 13 * gp.tileSize;

            gp.obj[2] = new Thesari();
            gp.obj[2].x = 9 * gp.tileSize;
            gp.obj[2].y = 13 * gp.tileSize;

            gp.obj[3] = new Thesari();
            gp.obj[3].x = 6 * gp.tileSize;
            gp.obj[3].y = 7 * gp.tileSize;

            gp.obj[4] = new Thesari();
            gp.obj[4].x = 15 * gp.tileSize;
            gp.obj[4].y = 3 * gp.tileSize;

        } else if (labirintiZgjedhur == 2) {
            gp.obj[0] = new Thesari();
            gp.obj[0].x = 12 * gp.tileSize;
            gp.obj[0].y = 4 * gp.tileSize;

            gp.obj[1] = new Thesari();
            gp.obj[1].x = 10 * gp.tileSize;
            gp.obj[1].y = 13 * gp.tileSize;

            gp.obj[2] = new Thesari();
            gp.obj[2].x = 5 * gp.tileSize;
            gp.obj[2].y = 7 * gp.tileSize;

            gp.obj[3] = new Thesari();
            gp.obj[3].x = 9 * gp.tileSize;
            gp.obj[3].y = 7 * gp.tileSize;

            gp.obj[4] = new Thesari();
            gp.obj[4].x = 18 * gp.tileSize;
            gp.obj[4].y = 5 * gp.tileSize;

        }else if (labirintiZgjedhur == 3) {
            gp.obj[0] = new Thesari();
            gp.obj[0].x = 2 * gp.tileSize;
            gp.obj[0].y = 3 * gp.tileSize;

            gp.obj[1] = new Thesari();
            gp.obj[1].x = 10 * gp.tileSize;
            gp.obj[1].y = 1 * gp.tileSize;

            gp.obj[2] = new Thesari();
            gp.obj[2].x = 16 * gp.tileSize;
            gp.obj[2].y = 5 * gp.tileSize;

            gp.obj[3] = new Thesari();
            gp.obj[3].x = 5 * gp.tileSize;
            gp.obj[3].y = 9 * gp.tileSize;

            gp.obj[4] = new Thesari();
            gp.obj[4].x = 14 * gp.tileSize;
            gp.obj[4].y = 13 * gp.tileSize;

        }else if (labirintiZgjedhur == 4) {
            gp.obj[0] = new Thesari();
            gp.obj[0].x = 1 * gp.tileSize;
            gp.obj[0].y = 10 * gp.tileSize;

            gp.obj[1] = new Thesari();
            gp.obj[1].x = 5 * gp.tileSize;
            gp.obj[1].y = 13 * gp.tileSize;

            gp.obj[2] = new Thesari();
            gp.obj[2].x = 12 * gp.tileSize;
            gp.obj[2].y = 1 * gp.tileSize;

            gp.obj[3] = new Thesari();
            gp.obj[3].x = 16 * gp.tileSize;
            gp.obj[3].y = 3 * gp.tileSize;

            gp.obj[4] = new Thesari();
            gp.obj[4].x = 11 * gp.tileSize;
            gp.obj[4].y = 7 * gp.tileSize;

        }
        gp.obj[5] = new Fundi();
        gp.obj[5].x = 18 * gp.tileSize;
        gp.obj[5].y = 13 * gp.tileSize;
    }
}
