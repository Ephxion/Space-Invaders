package spaceinvaders;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Explosion extends ObjetoJuego{


    public Explosion(int x, int y){
        super.x = x;
        super.y = y;
        width=80;
        height=80;
        imagen = null;
        agregarImagen(0);
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
            g2d.drawImage(imagen, x, y, width, height,null);
            try {
                Thread.sleep(200);
            } catch (InterruptedException ex) {
                Logger.getLogger(Explosion.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
}

