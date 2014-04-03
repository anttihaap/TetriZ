package tetriz.peliElementit;

import java.awt.Color;

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

        //Luodaan palalle väri ja neliot TetrisPalaTyypin mukaisesti:
        this.vari = this.palaTyyppi.vari;
        this.neliot = new Nelio[4];
        luoPalanNeliot();
    }

    /**
     *
     * @param aloitusKordinaattiX
     * @param aloitusKordinaattiY
     */
    public Pala(int aloitusKordinaattiX, int aloitusKordinaattiY) {
        this(aloitusKordinaattiX, aloitusKordinaattiY, TetrisPalatyypit.values()[(int) (Math.random() * TetrisPalatyypit.values().length)]);
    }

    //Kyseinen toiminto enumille, mutta aloitusKordinaatit... (?)
    private void luoPalanNeliot() {
        switch (palaTyyppi) {
            case NELIOPALA:
                this.neliot[0] = new Nelio(aloitusKordinaattiX - 1, aloitusKordinaattiY, this.vari);
                this.neliot[1] = new Nelio(aloitusKordinaattiX - 1, aloitusKordinaattiY + 1, this.vari);
                this.neliot[2] = new Nelio(aloitusKordinaattiX, aloitusKordinaattiY, this.vari);
                this.neliot[3] = new Nelio(aloitusKordinaattiX, aloitusKordinaattiY + 1, this.vari);
                break;
            case SUORAPALA:
                for (int i = 0; i < 4; i++) {
                    this.neliot[i] = new Nelio(aloitusKordinaattiX - 2 + i, 0, this.vari);
                }
                break;
            case KOLMIOPALA:
                this.neliot[0] = new Nelio(aloitusKordinaattiX - 1, aloitusKordinaattiY, this.vari);
                this.neliot[1] = new Nelio(aloitusKordinaattiX - 2, aloitusKordinaattiY + 1, vari);
                this.neliot[2] = new Nelio(aloitusKordinaattiX - 1, aloitusKordinaattiY + 1, vari);
                this.neliot[3] = new Nelio(aloitusKordinaattiX, aloitusKordinaattiY + 1, vari);
                break;
            case OIKEAVINO:
                this.neliot[0] = new Nelio(aloitusKordinaattiX - 2, aloitusKordinaattiY + 1, this.vari);
                this.neliot[1] = new Nelio(aloitusKordinaattiX - 1, aloitusKordinaattiY + 1, vari);
                this.neliot[2] = new Nelio(aloitusKordinaattiX - 1, aloitusKordinaattiY, vari);
                this.neliot[3] = new Nelio(aloitusKordinaattiX, aloitusKordinaattiY, vari);
                break;
            case VASENVINO:
                this.neliot[0] = new Nelio(aloitusKordinaattiX - 2, aloitusKordinaattiY, this.vari);
                this.neliot[1] = new Nelio(aloitusKordinaattiX - 1, aloitusKordinaattiY, vari);
                this.neliot[2] = new Nelio(aloitusKordinaattiX - 1, aloitusKordinaattiY + 1, vari);
                this.neliot[3] = new Nelio(aloitusKordinaattiX, aloitusKordinaattiY + 1, vari);
                break;
            case OIKEAL:
                this.neliot[0] = new Nelio(aloitusKordinaattiX - 2, aloitusKordinaattiY, this.vari);
                this.neliot[1] = new Nelio(aloitusKordinaattiX - 2, aloitusKordinaattiY + 1, this.vari);
                this.neliot[2] = new Nelio(aloitusKordinaattiX - 1, aloitusKordinaattiY + 1, vari);
                this.neliot[3] = new Nelio(aloitusKordinaattiX, aloitusKordinaattiY + 1, vari);
                break;
            case VASENL:
                this.neliot[0] = new Nelio(aloitusKordinaattiX, aloitusKordinaattiY, this.vari);
                this.neliot[1] = new Nelio(aloitusKordinaattiX - 2, aloitusKordinaattiY + 1, vari);
                this.neliot[2] = new Nelio(aloitusKordinaattiX - 1, aloitusKordinaattiY + 1, vari);
                this.neliot[3] = new Nelio(aloitusKordinaattiX, aloitusKordinaattiY + 1, vari);
                break;
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
     * Metodi liikuttaa kaikkia palan nelioita alas.
     */
    public void liikuAlas() {
        for (Nelio n : this.neliot) {
            n.alas();
        }
    }

    /**
     * Metodi liikuttaa kaikkia palan nelioita oikealle.
     */
    public void liikuOikealle() {
        for (Nelio n : this.neliot) {
            n.oikealle();
        }
    }

    /**
     * Metodi liikuttaa kaikkia palan nelioita vasemmalle.
     */
    public void liikuVasemmalle() {
        for (Nelio nelio : neliot) {
            nelio.vasemmalle();
        }
    }

    //TODO
    /**
     *
     */
    public void rotaatio() {
    }
}
