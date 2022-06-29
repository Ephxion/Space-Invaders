import java.util.ArrayList;

public class Jugador {
    public String _nombre;
    public int nivel;
    public int hp;
    public int ataque;
    public int velocidad;
    public int puntuacion;
    public ArrayList<Skin> skins;
    public ArrayList<Arma> armas;

    public Jugador(String nombre, int nivel, int hp
                    , int ataque, int velocidad, int puntuacion){
        this._nombre = nombre;
        this.nivel = nivel;
        this.hp = hp;
        this.ataque = ataque;
        this.velocidad = velocidad;
        this.puntuacion = puntuacion;
    }

    @Override
    public String toString(){
        return "Jugador{"+
                "nombre=" + _nombre +
                ", hp=" + hp + '\'' +
                ", ataque=" + ataque + '\'' +
                ", velocidad=" + velocidad + '\'' +
                ", puntuacion=" + puntuacion + '\'' +
                '}';
    }
}
