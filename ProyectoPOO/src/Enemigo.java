import java.util.ArrayList;

public class Enemigo {
    public int nivel;
    public int hp;
    public int ataque;
    public int velocidad;
    public int tamano;
    public ArrayList<Skin> skins;

    public Enemigo (int nivel, int hp, int ataque, int velocidad){
        this.nivel = nivel;
        this.hp = hp;
        this.ataque = ataque;
        this.velocidad = velocidad;
    }
}
