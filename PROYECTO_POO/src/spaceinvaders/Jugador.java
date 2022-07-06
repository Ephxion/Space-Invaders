package spaceinvaders;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.*;

public class Jugador extends ObjetoJuego implements Stage{


    Rectangle bounds;
    boolean izquierda;
    boolean derecha;
    final int jVel=10;

    public Jugador(int x, int y) {
        super.x = x;
        super.y = y;
        vx = 0;
        y=500;
        width=80;
        height=80;
        agregarImagen(3);
            bounds = new Rectangle(x, y, width, height);
    }

    public void mover()
    {
        vx = 0;

        if(derecha) {vx = 15;}
        if(izquierda) {vx = -15;}

        x = x + vx;

        if (x < 0) {
            x = 0;
        }
        if (x > ANCHO - imagen.getWidth(null)*2) {
            x = ANCHO - imagen.getWidth(null)*2;
        }

        if (y < 0) {
            y = 0;
        }
        if (y > ALTO - imagen.getHeight(null)) {
            y = ALTO - imagen.getHeight(null);
        }
        bounds.setLocation(x, y);
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            derecha = true;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            izquierda = true;
        }
    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            derecha = false;
        }
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                izquierda = false;
        }
    }

    public void paint(Graphics2D g) {
        g.drawImage(imagen, x, (ALTO - (ALTO/5)),height, width, null);
    }

}
