package tetriz.peliElementit;

import java.awt.Color;

/**
 * Pala (eli tetrispala), joka koostuu neljästä neliöstä. Tetrispalatyyppi määrittelee palan ominaisuudet.
 * @author Antti
 */
public class Pala implements Cloneable {

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
     * Luo palan aloitusKordinaatteja käyttäen ja tetrispala-tyypin ominaisuuksien 
     * mukaan. TetrisPalaTyyppi luodaan satunnaisesti.
     *
     * @param aloitusKordinaattiX
     * @param aloitusKordinaattiY
     */
    public Pala(int aloitusKordinaattiX, int aloitusKordinaattiY) {
        this(aloitusKordinaattiX, aloitusKordinaattiY, TetrisPalatyypit.values()[(int) (Math.random() * TetrisPalatyypit.values().length)]);
    }


    private void luoNeliot() {
        this.neliot = new Nelio[4];
        
        int i = 0;
        for (Nelio n : this.palaTyyppi.neliot) {
            this.neliot[i] = new Nelio(n.palautaX() + (this.aloitusKordinaattiX - 2), n.palautaY() + this.aloitusKordinaattiY, n.palautaVari());
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
            //n.alas();
        }
    }

    /**
     * Metodi liikuttaa kaikkia palan nelioita oikealle kasvattamalla
     * kaikkien nelioiden X-arvoa yhdellä.
     */
    public void liikuOikealle() {
        for (Nelio n : this.neliot) {
            n.asetaX(n.palautaX() + 1);
        }
    }

    /**
     * Metodi liikuttaa kaikkia palan nelioita vasemmalle vähentämällä
     * kaikkien nelioiden X-arvoa yhdellä.
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
        90-asteen käännös:
        [0 -1]
        [1  0]
        */
        int kaantokohtaX = neliot[2].palautaX();
        int kaantokohtaY = neliot[2].palautaY();
        
        //Vähenentään kääntökohtien arvot X- ja Y-arvoista:
        for (Nelio nelio : neliot) {
            nelio.asetaX(nelio.palautaX() - kaantokohtaX);           
            nelio.asetaY(nelio.palautaY() - kaantokohtaY);          
        }

        //90-asteen käännös kääntökohdan ympärillä:
        for (Nelio n : neliot) {
            int x = n.palautaX();
            int y = n.palautaY();
            n.asetaX(x * 0 + -1 * y + kaantokohtaX);
            n.asetaY(1 * x + 0 * y  + kaantokohtaY);
        }
        
    }
    
    @Override
    public Object clone() throws CloneNotSupportedException {
        Pala clooni = (Pala)super.clone();
        return clooni;
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
     * @return
     */
    public Color palautaVari() {
        return this.vari;
    }
    
    public String palautaTetrispalatyypinNimi() {
        return this.palaTyyppi.toString();
    }
}
