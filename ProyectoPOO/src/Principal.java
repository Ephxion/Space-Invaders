import java.awt.*;

public class Principal {

    static Menu menus = new Menu();
    static DB base = new DB();
    public static void main(String[] args) {
        base.asignarDatos();
        base.guardarJSON();
        menus.menuJuego();
    }
}