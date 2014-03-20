package tetriz.peliElementit;

import java.awt.Color;

public class Nelio {

    //Nelion kordinaatit:
    public int X;
    public int Y;
    
    //Nelion vari:
    public Color vari;

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

    public void asetaKordinaatit(int x, int y) {
        this.Y = y;
        this.X = x;
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
