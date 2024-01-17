package objekte;

import javax.imageio.ImageIO;
import java.io.IOException;

public class Fundi extends SuperObject{
    public Fundi(){
        name = "Fundi";
        try{
            image = ImageIO.read(getClass().getResourceAsStream("/objektet/moon_fundi.png"));
        }catch(IOException e){
            e.printStackTrace();
        }

    }
}
