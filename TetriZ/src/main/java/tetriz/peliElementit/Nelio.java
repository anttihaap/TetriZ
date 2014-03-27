package tetriz.peliElementit;

import java.awt.Color;

public class Nelio {

    //Nelion kordinaatit:
    private int X;
    private int Y;
    
    //Nelion vari:
    private final Color vari;

    public Nelio(int x, int y, Color vari) {
        this.X = x;
        this.Y = y;
        this.vari = vari;
    }

    public int palautaX() {
        return this.X;
    }

    public int palautaY() {
        return this.Y;
    }

    public Color palautaVari() {
        return this.vari;
    }

    public void alas() {
        this.Y++;
    }

    public void oikealle() {
        this.X++;
    }

    public void vasemmalle() {
        this.X--;
    }
}
