package spaceinvaders;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Principal extends JPanel implements Stage, KeyListener {

    ArrayList<Enemigo> enemigos;
    ArrayList<Disparo> balas;
    ArrayList<Integer> puntajesTope;
    Jugador jugador;
    Escenario escenario;
    int vidas = 3, puntos = 0, nivel = 1;
    int mVel = 3;
    boolean seguir = true;

    public Principal() {
        enemigos = new ArrayList<>();
        balas = new ArrayList<>();
        puntajesTope = new ArrayList<>();
        jugador = new Jugador(400, 500);
        escenario = new Escenario(this);
    }

    public void llenarPuntajesTope() {
        for (int i = 0; i < NIVELES; i++) {
            if (i == 0) {
                puntajesTope.add(100);
            } else {
                puntajesTope.add(puntajesTope.get(i - 1) * 2);
            }
        }
    }

    public boolean cambioNivel() {
        boolean cambio = false;
        if (puntos >= puntajesTope.get(nivel - 1)) {
            cambio = true;
        }
        return cambio;
    }

    public void imprimirGano() {
        seguir = false;
        limpiar();
        Graphics2D g2d = (Graphics2D) getGraphics();
        g2d.setColor(Color.GREEN);
        g2d.setFont(new Font("Roboto", Font.BOLD, 20));
        g2d.drawString("GANASTE", 350, 250);
        g2d.drawString("SCORE: " + puntos, 350, 350);
    }

    public void imprimirPerdio() {
        seguir = false;
        limpiar();
        Graphics2D g2d = (Graphics2D) getGraphics();
        g2d.setColor(Color.RED);
        g2d.setFont(new Font("Roboto", Font.BOLD, 20));
        g2d.drawString("GAME OVER", 350, 250);
        g2d.drawString("SCORE: " + puntos, 350, 350);
    }

    public void crearEnemigos() {
        int x = (int) (Math.random() * ANCHO);
        int y = 0;
        Enemigo m = new Enemigo(x, y);
        m.setVelocidad(mVel, mVel);
        enemigos.add(m);
    }

    public void crearMisil() {
        if (balas.size() < 10) {
            int x = jugador.x;
            int y = jugador.y;
            Disparo m = new Disparo(x, y);
            balas.add(m);
        }
    }

    public void actualizarMundo() {
        for (int i = 0; i < enemigos.size(); i++) {
            enemigos.get(i).mover(ANCHO, ALTO);
            if (enemigos.get(i).marcadoBorrar) {
                enemigos.remove(i);
            }
        }
        for (int i = 0; i < balas.size(); i++) {
            balas.get(i).mover(ANCHO, ALTO);
            if (balas.get(i).marcadoBorrar) {
                balas.remove(i);
            }
        }
        jugador.mover();
    }

    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        escenario.paint(g2d);
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2d.setColor(Color.BLACK);
        g2d.setFont(new Font("Roboto", Font.BOLD, 20));
        g2d.drawString("SCORE: " + puntos, 50, 50);
        g2d.drawString("NIVEL: " + nivel, 600, 50);
        for (int i = 0; i < enemigos.size(); i++) {
            enemigos.get(i).paint(g2d);
        }
        for (int i = 0; i < balas.size(); i++) {
            balas.get(i).paint(g2d);
        }
        jugador.paint(g2d);
    }

    public void colisiones() {
        boolean cambio = false;
        for (int i = 0; i < enemigos.size(); i++) {
            for (int j = 0; j < balas.size(); j++) {
                if (balas.get(j).bounds.intersects(enemigos.get(i).bounds)) {
                    enemigos.get(i).marcadoBorrar = true;
                    balas.get(j).marcadoBorrar = true;
                    puntos += 10;
                    cambio = cambioNivel();
                }
            }
        }

        for (int i = 0; i < enemigos.size(); i++) {
            if (enemigos.get(i).bounds.intersects(jugador.bounds)) {
                vidas--;
                Explosion explosion = new Explosion(jugador.x, jugador.y);
                explosion.paint(getGraphics());
                explosion = null;
                limpiar();
            }
        }

        if (cambio) {
            mVel += 5;
            nivel++;
            for (int i = 0; i < enemigos.size(); i++) {
                enemigos.get(i).setVelocidad(mVel, mVel);
            }
        }
        if (vidas == 0) {
            imprimirPerdio();
        }
        if (nivel > 5) {
            imprimirGano();
        }
    }

    public void limpiar() {
        jugador = null;
        jugador = new Jugador(400, 500);
        enemigos.clear();
        balas.clear();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        int velocidad = 100;
        JFrame frame = new JFrame("Space invaders");
        frame.setSize(ANCHO, ALTO);
       // frame.setResizable(false);
        frame.setBackground(Color.black);
        Container c = frame.getContentPane();
        c.setBackground(new Color(0, 0, 0));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        Principal spaceInvaders = new Principal();
        spaceInvaders.setPreferredSize(new Dimension(frame.getWidth(), frame.getHeight()));
        spaceInvaders.setLayout(null);
        spaceInvaders.llenarPuntajesTope();
        frame.add(spaceInvaders);
        frame.setVisible(true);
        frame.addKeyListener(spaceInvaders);
        frame.setFocusable(true);
        int tiempo = 0;
        while (spaceInvaders.seguir) {
            spaceInvaders.actualizarMundo();
            spaceInvaders.repaint();
            spaceInvaders.colisiones();
            Thread.sleep(velocidad);
            tiempo += 100;
            if (tiempo >= 1000) {
                spaceInvaders.crearEnemigos();
                tiempo = 0;
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //player.keyPressed(e);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_SPACE) {
            crearMisil();
        } else {
            jugador.keyPressed(e);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        jugador.keyReleased(e);
    }

}
