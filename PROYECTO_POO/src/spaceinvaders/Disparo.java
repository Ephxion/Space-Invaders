package spaceinvaders;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Disparo extends ObjetoJuego{

    Rectangle bounds;
    boolean marcadoBorrar;

    public Disparo(int x, int y) {
        super.x = x;
        super.y = y;
        vy = -30;
        marcadoBorrar = false;
        agregarImagen(1);
        width = 8;
        height = 10;
        bounds = new Rectangle(x, y, width, height);
    }

    public void mover(int ancho, int alto) {
        y += vy;
        if (y < 0) {
            marcadoBorrar = true;
        }
        bounds.setLocation(x, y);
    }

    public void paint(Graphics2D g) {
        g.drawImage(imagen, x, y, 5,20, null);
    }



}
