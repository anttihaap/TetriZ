package tetriz.peliElementit;

import java.awt.Color;

/**
 *
 * @author Antti
 */
public class Nelio {

    //Nelion kordinaatit:
    private int X;
    private int Y;
    
    //Nelion vari:
    private final Color vari;

    /**
     *
     * @param x
     * @param y
     * @param vari
     */
    public Nelio(int x, int y, Color vari) {
        this.X = x;
        this.Y = y;
        this.vari = vari;
    }

    /**
     * Palauttaa nelion X-positioarvon.
     * @return
     */
    public int palautaX() {
        return this.X;
    }

    /**
     * Palauttaa nelion Y-positioarvon.
     * @return
     */
    public int palautaY() {
        return this.Y;
    }
    
    public void asetaX(int x) {
        this.X = x;
    }
    
    public void asetaY(int y) {
        this.Y = y;
    }

    /**
     * Palauttaa nelion värin.
     * @return
     */
    public Color palautaVari() {
        return this.vari;
    }

}
