package spaceinvaders;

import java.awt.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

//import static spaceinvaders.Stage.*;

public class Escenario extends Canvas implements Stage {

    Image imagen = null;
    public  int star=4;
    Principal principal;


    public Escenario(Principal principal) {
        this.principal = principal;
    }

   public void paint(Graphics2D g) {
        setForeground(Color.red);
        for (int i=0; i<1000; i++) {
            int a = getRandomNumber(1, star);
            g.fillRect(getRandomNumber(star, ANCHO), getRandomNumber(star, ANCHO), a, a);
            g.setColor(new Color(75, 75, 75));
        }
       g.drawImage(imagen, 0, 0, principal.getWidth(), principal.getHeight(), null);
    }

    public int getRandomNumber(int min, int max)
    {
        int n =(int) (Math.random() * (max - min))+min;
        return n;
    }

    public int getRes() { return ANCHO; }

}
