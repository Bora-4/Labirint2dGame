import main.KontrolleriLojes;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;

public class MenaxhimKutie {
    public Kuti[] kuti;
    KontrolleriLojes gp;

    public int nrKutiveHarta[][];

    public MenaxhimKutie(KontrolleriLojes gp) {
        this.gp = gp;

        kuti = new Kuti[10];
        nrKutiveHarta = new int[gp.maxScreenCol][gp.maxScreenRow];
        getKutiImage();
        loadRandomHarta("harta/harta1.txt", "harta/harta2.txt", "harta/harta3.txt", "harta/harta4.txt", "harta/harta5.txt", "harta/harta_test.txt");
    }

    public void getKutiImage() {
        try {
            kuti[0] = new Kuti();
            kuti[0].image = ImageIO.read(getClass().getResourceAsStream("/kuti/toka.png"));

            kuti[1] = new Kuti();
            kuti[1].image = ImageIO.read(getClass().getResourceAsStream("/kuti/mur.png"));
            kuti[1].collision = true;
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadRandomHarta(String... filePaths) {
        Random random = new Random();
        String randomFilePath = filePaths[random.nextInt(filePaths.length)];

        try {
            InputStream is = getClass().getResourceAsStream(randomFilePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(is));

            int kolona = 0;
            int rreshta = 0;

            while (kolona < gp.maxScreenCol && rreshta < gp.maxScreenRow) {
                String line = br.readLine();
                while (kolona < gp.maxScreenCol) {
                    String numbers[] = line.split(" ");
                    int nr = Integer.parseInt(numbers[kolona]);
                    nrKutiveHarta[kolona][rreshta] = nr;
                    kolona++;
                }
                if (kolona == gp.maxScreenCol) {
                    kolona = 0;
                    rreshta++;
                }
            }
            br.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void draw(Graphics2D g2) {
        int kolona = 0;
        int rreshta = 0;
        int x = 0;
        int y = 0;

        while (kolona < gp.maxScreenCol && rreshta < gp.maxScreenRow) {
            int nrKutish = nrKutiveHarta[kolona][rreshta];

            g2.drawImage(kuti[nrKutish].image, x, y, gp.tileSize, gp.tileSize, null);
            kolona++;
            x += gp.tileSize;

            if (kolona == gp.maxScreenCol) {
                kolona = 0;
                x = 0;
                rreshta++;
                y += gp.tileSize;
            }
        }
    }
}
