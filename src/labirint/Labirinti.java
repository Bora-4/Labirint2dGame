package labirint;

import main.KontrolleriLojes;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Labirinti {
    public Kuti[] kuti;
    KontrolleriLojes gp;

    public int nrKutiveHarta[][];

    public Labirinti(KontrolleriLojes gp){
        this.gp = gp;

        kuti = new Kuti[10];
        nrKutiveHarta = new int[gp.maxScreenCol][gp.maxScreenRow];
        getKutiIamge();
        gjeneroLabirint("/harta/harta1.txt");
        /*loadRandomHarta("harta/harta1.txt", "harta/harta2.txt", "harta/harta3.txt", "harta/harta4.txt", "harta/harta5.txt");*/

    }

    public void getKutiIamge(){
        try{
            kuti[0] = new Kuti();
            kuti[0].image = ImageIO.read(getClass().getResourceAsStream("/labirint/toka.png"));

            kuti[1] = new Kuti();
            kuti[1].image = ImageIO.read(getClass().getResourceAsStream("/labirint/mur.png")); //e ndryshoj ne kuti solid (dmth nuk mund te kaloj permes saj)
            kuti[1].collision = true;


        }catch(IOException e){
            e.printStackTrace();
        }
    }

    public void gjeneroLabirint(String filePath){
        try{
            InputStream is = getClass().getResourceAsStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int kolona = 0;
            int rreshta = 0;

            while(kolona < gp.maxScreenCol && rreshta < gp.maxScreenRow) {
                String line = br.readLine();
                while (kolona < gp.maxScreenCol) {
                    String numbers[] = line.split(" ");
                    int nr = Integer.parseInt(numbers[kolona]);
                    nrKutiveHarta[kolona][rreshta] = nr;
                    kolona++;

                }
                if(kolona == gp.maxScreenCol){
                    kolona = 0;
                    rreshta++;

                }
            }
            br.close();

        }catch(Exception e){

        }
    }

    public void draw(Graphics2D g2){

        int kolona = 0;
        int rreshta = 0;
        int x = 0;
        int y = 0;

        while(kolona < gp.maxScreenCol && rreshta < gp.maxScreenRow){
            int nrKutish = nrKutiveHarta[kolona][rreshta];

            g2.drawImage(kuti[nrKutish].image, x, y, gp.tileSize, gp.tileSize, null);
            kolona++;
            x += gp.tileSize;

            if(kolona == gp.maxScreenCol){
                kolona = 0;
                x = 0;
                rreshta++;
                y += gp.tileSize;

            }
        }
    }
}