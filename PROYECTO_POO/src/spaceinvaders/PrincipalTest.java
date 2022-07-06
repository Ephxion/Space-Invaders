package spaceinvaders;

import org.junit.jupiter.api.*;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
class PrincipalTest {

    @BeforeEach
    void setUp() {
        System.out.println("Iniciando prueba.");
    }

    @AfterEach
    void tearDown() {
        System.out.println("Prueba finalizada");
    }

    @Test
    @DisplayName("Comprobar si se cambia de nivel al cumplir con el puntaje necesario.")
    void cambioNivel() {

        boolean cambio = false;
        int nivel = 1;
        int puntos = 101;
        ArrayList<Integer> puntajesTope = new ArrayList<>();
        puntajesTope.add(100);

        if (puntos >= puntajesTope.get(nivel - 1)) {
            cambio = true;
        }


        assertEquals(true, cambio);
    }

    @Test
    @DisplayName("Verificar que el enemigo se creo exitosamente.")
    void crearEnemigos() {

        int ANCHO = 20;
        int mVel = 4;
        ArrayList<Enemigo> enemigos = new ArrayList<>();

        int x = (int) (Math.random() * ANCHO);
        int y = 0;
        Enemigo m = new Enemigo(x, y);
        m.setVelocidad(mVel, mVel);
        enemigos.add(m);

        assertFalse(enemigos.isEmpty());
    }

    @Test
    @DisplayName("Verificar que se cree 1 bala mientras existan menos de 10")
    void crearBala() {

        ArrayList<Disparo> balas = new ArrayList<>();
        Jugador jugador = new Jugador(20,50);

        if (balas.size() < 10) {
            int x = jugador.x;
            int y = jugador.y;
            Disparo m = new Disparo(x, y);
            balas.add(m);
        }

        assertEquals(1, balas.size());

    }

    @Test
    @DisplayName("Verificar que las listas de vaciaran de forma exitosa.")
    void limpiar() {

        ArrayList<Enemigo> enemigos = new ArrayList<>();
        ArrayList<Disparo> balas = new ArrayList<>();

        enemigos.add(new Enemigo(4, 6));
        balas.add(new Disparo(2,5));

        enemigos.clear();
        balas.clear();

        assertTrue(enemigos.isEmpty());
        assertTrue(balas.isEmpty());

    }

    @Test
    @DisplayName("Verificar si se crearon los puntajes de tope para cada nivel")
    void llenarPuntajesTope(){

        int NIVELES = 2;
        ArrayList<Integer> puntajesTope = new ArrayList<>();

        for (int i = 0; i < NIVELES; i++) {
            if (i == 0) {
                puntajesTope.add(100);
            } else {
                puntajesTope.add(puntajesTope.get(i - 1) * 2);
            }
        }

        assertEquals(false, puntajesTope.isEmpty());
        assertEquals(2, puntajesTope.size());
    }
}