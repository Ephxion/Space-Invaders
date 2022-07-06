package spaceinvaders;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class ObjetoJuego {
    int width;
    int height;
    int x, y, vx, vy;
    Image imagen;
    String[] rutas = {
            "recursos/explosion.png",
            "recursos/bala.png",
            "recursos/enemy.png",
            "recursos/nave.png"};

    public void agregarImagen(int x){
        try {
            this.imagen = ImageIO.read(getClass().getClassLoader().getResource(rutas[x]));
        } catch (IOException ex) {
            Logger.getLogger(Enemigo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
