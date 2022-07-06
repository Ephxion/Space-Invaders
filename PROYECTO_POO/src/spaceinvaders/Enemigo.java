package spaceinvaders;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Enemigo extends ObjetoJuego{

    int cuadro;
    Rectangle bounds;
    boolean marcadoBorrar;

    public Enemigo(int x, int y) {
        super.x = x;
        super.y = y;
        marcadoBorrar = false;
        this.cuadro = 0;
        imagen = null;
        width = 70;
        height = 70;
        agregarImagen(2);
        bounds = new Rectangle(x, y, height, width);
    }

    public void setVelocidad(int vx, int vy){
        if (x < 400)
            this.vx = -vx;
        this.vy = vy;
    }

    public void mover(int ancho, int alto) {
        x += vx;
        y += vy;
        if (x < 0 || x > ancho - bounds.getWidth()) {
            vx = -vx;
        }
        if (y > alto) {
            marcadoBorrar = true;
        }
        bounds.setLocation(x, y);
    }

    public void paint(Graphics2D g) {
        //g.drawImage(imagen, x, y, x + 32, y + 32, cuadro * 32, 0, cuadro * 32 + 32, 32, null);
        g.drawImage(imagen, x, y, width, height,null);
        cuadro++;
        if (cuadro > 2) {
            cuadro = 0;
        }
    }

}
