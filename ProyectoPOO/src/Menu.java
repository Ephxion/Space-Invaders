import javax.swing.*;
import java.awt.*;

public class Menu extends Canvas{

    public  int resx=1000;
    public  int resy=1000;
    public  int star=10;

    public void menuJuego() {
        Menu m=new Menu();
        JFrame f =new JFrame();
        f.add(m);
        f.setSize(resx,resy);
        Container c = f.getContentPane();
        c.setBackground(new Color(0, 0, 0));
        //f.setLayout(null);
        f.setVisible(true);
        setForeground(Color.WHITE);


    }

    public void paint(Graphics g) {
        //Graphics star = new Graphics(g.fillRect(10,10,10,10));
        for (int i = 0; i < 1000; i++) {
            int a = getRandomNumber(1, star);
            //this.G=getGraphics();
            //G.fillRect(getR
            // andomNumber(star,resx),getRandomNumber(star,resy),a,a);
            //getGraphics().fillRect(getRandomNumber(star,resx),getRandomNumber(star,resy),a,a);

            g.fillRect(getRandomNumber(star, resx), getRandomNumber(star, resy), a, a);
        }
    }

    public void paintStar(Graphics g) {
        g.fillRect(0,0,0,0);
    }
    /*public void estrella() {
        setForeground(Color.WHITE);
        //Graphics star = new Graphics(g.fillRect(10,10,10,10));
        for (int i = 0; i < 1000; i++) {
            int a = getRandomNumber(1,star);
            //this.G=getGraphics();
            this.G.fillRect(getRandomNumber(star,resx),getRandomNumber(star,resy),a,a);

        }
    }*/


    public void menuRecord(){}
    public int getRandomNumber(int min, int max)
    {
        int n =(int) (Math.random() * (max - min))+min;
        return n;
    }

}