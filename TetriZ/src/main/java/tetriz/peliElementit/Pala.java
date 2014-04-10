package tetriz.peliElementit;

import java.awt.Color;
import java.util.Arrays;

/**
 *
 * @author Antti
 */
public class Pala {

    TetrisPalatyypit palaTyyppi;
    Color vari;
    Nelio[] neliot;

    int aloitusKordinaattiX;
    int aloitusKordinaattiY;
    /**
     *
     * @param aloitusKordinaattiX
     * @param aloitusKordinaattiY
     * @param tyyppi
     */
    public Pala(int aloitusKordinaattiX, int aloitusKordinaattiY, TetrisPalatyypit tyyppi) {
        this.aloitusKordinaattiX = aloitusKordinaattiX;
        this.aloitusKordinaattiY = aloitusKordinaattiY;
        this.palaTyyppi = tyyppi;
        this.vari = this.palaTyyppi.vari;
        
        luoNeliot();
    }

    /**
     * Luo palan aloitusKordinaatteja käyttäen. TetrisPalaTyyppi luodaan
     * satunnaisesti.
     *
     * @param aloitusKordinaattiX
     * @param aloitusKordinaattiY
     */
    public Pala(int aloitusKordinaattiX, int aloitusKordinaattiY) {
        this(aloitusKordinaattiX, aloitusKordinaattiY, TetrisPalatyypit.values()[(int) (Math.random() * TetrisPalatyypit.values().length)]);
    }

    //Kyseinen toiminto enumille, mutta aloitusKordinaatit... (?)
    private void luoNeliot() {
        this.neliot = new Nelio[4];
        
        int i = 0;
        for (Nelio n : this.palaTyyppi.neliot) {
            this.neliot[i] = new Nelio(n.palautaX() + (this.aloitusKordinaattiX - 2), n.palautaY() + this.aloitusKordinaattiY, n.palautaVari());
            i++;
        }
    }

    /**
     * Palauttaa palan neliot.
     *
     * @return palan neliot
     */
    public Nelio[] palautaPalanNeliot() {
        return this.neliot;
    }

    public Color palautaVari() {
        return this.vari;
    }

    /**
     * Palauttaa värin kordinaatiston kohdasta (x,y).
     *
     * @param x
     * @param y
     * @return vari kordinaatiston kohdasta
     */
    public Color palautaVariKordinaatista(int x, int y) {
        for (Nelio nelio : neliot) {
            if (nelio.palautaX() == x && nelio.palautaY() == y) {
                return nelio.palautaVari();
            }
        }
        return null;
    }

    /**
     * Metodi liikuttaa kaikkia palan nelioita alas kasvattamalla kaikkien
     * neliöiden Y:n arvoa yhdellä.
     */
    public void liikuAlas() {
        for (Nelio n : this.neliot) {
            n.asetaY(n.palautaY() + 1);
            //n.alas();
        }
    }

    /**
     * Metodi liikuttaa kaikkia palan nelioita oikealle.
     */
    public void liikuOikealle() {
        for (Nelio n : this.neliot) {
            n.asetaX(n.palautaX() + 1);
        }
    }

    /**
     * Metodi liikuttaa kaikkia palan nelioita vasemmalle.
     */
    public void liikuVasemmalle() {
        for (Nelio n : neliot) {
            n.asetaX(n.palautaX() - 1);
        }
    }

    //TODO
    /**
     *
     */
    public void rotaatio() {

    }
}
