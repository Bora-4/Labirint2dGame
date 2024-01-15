package objekte;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Thesari_1 extends Thesaret{

    public Thesari_1(){

        name ="Thesari";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/thesare/thesari.png"));

        }catch(IOException e){
            e.printStackTrace();
        }

    }
}
