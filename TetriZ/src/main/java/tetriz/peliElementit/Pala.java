package tetriz.peliElementit;

import java.awt.image.BufferedImage;

/**
 * Pala (eli tetrispala), joka koostuu neljästä neliöstä. Tetrispalatyyppi
 * määrittelee palan ominaisuudet.
 *
 * @author Antti
 */
public class Pala implements Cloneable {

    private final TetrisPalatyypit palatyyppi;

    private Nelio[] neliot;

    /**
     *
     * @param aloitusKordinaattiX
     * @param aloitusKordinaattiY
     * @param tyyppi
     */
    public Pala(int aloitusKordinaattiX, int aloitusKordinaattiY, TetrisPalatyypit tyyppi) {
        this.palatyyppi = tyyppi;
        luoNeliot(aloitusKordinaattiX, aloitusKordinaattiY);
    }

    /**
     * Luo palan aloitusKordinaatteja käyttäen ja tetrispala-tyypin
     * ominaisuuksien mukaan. TetrisPalaTyyppi luodaan satunnaisesti.
     *
     * @param aloitusKordinaattiX
     * @param aloitusKordinaattiY
     */
    public Pala(int aloitusKordinaattiX, int aloitusKordinaattiY) {
        this(aloitusKordinaattiX, aloitusKordinaattiY, TetrisPalatyypit.values()[(int) (Math.random() * TetrisPalatyypit.values().length)]);
    }

    private void luoNeliot(int aloitusKordinaattiX, int aloitusKordinaattiY) {
        this.neliot = new Nelio[4];

        int i = 0;
        for (Nelio n : this.palatyyppi.neliot) {
            this.neliot[i] = new Nelio(n.palautaX() + (aloitusKordinaattiX - 2), n.palautaY() + aloitusKordinaattiY, n.palautaKuva());
            i++;
        }
    }

    /**
     * Metodi liikuttaa kaikkia palan nelioita alas kasvattamalla kaikkien
     * neliöiden Y-arvoa yhdellä.
     */
    public void liikuAlas() {
        for (Nelio n : this.neliot) {
            n.asetaY(n.palautaY() + 1);
        }
    }

    /**
     * Metodi liikuttaa kaikkia palan nelioita oikealle kasvattamalla kaikkien
     * nelioiden X-arvoa yhdellä.
     */
    public void liikuOikealle() {
        for (Nelio n : this.neliot) {
            n.asetaX(n.palautaX() + 1);
        }
    }

    /**
     * Metodi liikuttaa kaikkia palan nelioita vasemmalle vähentämällä kaikkien
     * nelioiden X-arvoa yhdellä.
     */
    public void liikuVasemmalle() {
        for (Nelio n : neliot) {
            n.asetaX(n.palautaX() - 1);
        }
    }

    /**
     * Kääntää palan 90-astetta oikealle.
     */
    public void kaannaOikealle() {
        /*
         90-asteen käännös kääntömatriisilla:
         [0 -1]
         [1  0]
         */

        //Neliopalaa ei käännetä.
        if (palatyyppi != TetrisPalatyypit.NELIOPALA) {
            //Piste jonka ympärilta kaannetaan.
            int kaantokohtaX = neliot[2].palautaX();
            int kaantokohtaY = neliot[2].palautaY();

            //Vähenentään kääntökohtien arvot X- ja Y-arvoista:
            for (Nelio n : neliot) {
                n.asetaX(n.palautaX() - kaantokohtaX);
                n.asetaY(n.palautaY() - kaantokohtaY);
            }

            //90-asteen käännös kääntökohdan ympärillä:
            for (Nelio n : neliot) {
                int x = n.palautaX();
                int y = n.palautaY();
                n.asetaX(x * 0 + -1 * y + kaantokohtaX);
                n.asetaY(1 * x + 0 * y + kaantokohtaY);
            }
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
     * Palauttaa palan värin.
     *
     * @return
     */
    public BufferedImage palautaKuva() {
        return palatyyppi.kuva;
    }
    
    public TetrisPalatyypit palautaTetrispalatyyppi() {
        return palatyyppi;
    }    
    
    @Override
    public Pala clone() throws CloneNotSupportedException {
        Pala klooni = null;
        try {
            klooni = (Pala) super.clone();
            
        } catch (CloneNotSupportedException e) {
            
        }
        return klooni;
    }
}
