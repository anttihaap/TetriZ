package tetriz.peliElementit;

import java.awt.image.BufferedImage;

/**
 * Kuvastaa palan yhtä neliota. Ominaisuuksia: kuva ja piste (x,y).
 * @author Antti
 */
public class Nelio {

    //Nelion kordinaatit:
    private int X;
    private int Y;
    
    //Nelion kuva
    private final BufferedImage kuva;

    /**
     * Konstruktori luo uuden nelion käyttäen sille annettuja ominaisuuksia.
     * @param x
     * @param y
     * @param kuva
     */
    public Nelio(int x, int y, BufferedImage kuva) {
        X = x;
        Y = y;
        this.kuva = kuva;
    }

    /**
     * Palauttaa nelion X-positioarvon.
     * @return
     */
    public int palautaX() {
        return X;
    }

    /**
     * Palauttaa nelion Y-positioarvon.
     * @return
     */
    public int palautaY() {
        return Y;
    }
    
    /**
     * Asettaa X:n arvon.
     * @param x
     */
    public void asetaX(int x) {
        this.X = x;
    }
    
    /**
     * Asettaa X:n arvon.
     * @param y
     */
    public void asetaY(int y) {
        this.Y = y;
    }

    /**
     * Palauttaa nelion kuvan.
     * @return
     */
    public BufferedImage palautaKuva() {
        return kuva;
    }
}