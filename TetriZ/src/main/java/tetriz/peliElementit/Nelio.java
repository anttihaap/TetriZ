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

    /**
     * Palauttaa nelion värin.
     * @return
     */
    public Color palautaVari() {
        return this.vari;
    }

    /**
     * Metodi kasvattaa Y:n arvoa yhdellä (liikkuu alas).
     */
    public void alas() {
        this.Y++;
    }

    /**
     * Metodi kasvattaa X:n arvoa yhdellä (liikkuu oikealle).
     */
    public void oikealle() {
        this.X++;
    }

    /**
     * Metodi vähentää X:n arvoa yhdellä (liikkuu vasemmalle).
     */
    public void vasemmalle() {
        this.X--;
    }
}
