package objekte;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Thesari extends SuperObject {

    public Thesari(){

        name ="Thesari";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objektet/thesari.png"));

        }catch(IOException e){
            e.printStackTrace();
        }

    }
}
