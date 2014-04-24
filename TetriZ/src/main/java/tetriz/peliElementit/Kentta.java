package tetriz.peliElementit;

import java.awt.image.BufferedImage;

/**
 * Kentta sisältää kordinaatiston, joka pitää sisällään kuvia.
 * @author Antti
 */
public class Kentta {

    private BufferedImage[][] kordinaatisto;

    public Kentta(int kentanLeveys, int kentanKorkeus) {
        this.kordinaatisto = new BufferedImage[kentanLeveys][kentanKorkeus];
    }

    /**
     * Metodi lisää värin kordinaatistoon käyttäen x ja y parametreja, jotka vastaa paikkaa kordinaatistossa.
     * @param kvua
     * @param x
     * @param y
     */
    public void lisaaKuva(BufferedImage kvua, int x, int y) {
        this.kordinaatisto[x][y] = kvua;
    }

    /**
     * Metodi lisää palan värit kentään käymällä palan neliot läpi ja lisäämällä ne lisaaVari() -metodia käyttäen.
     * @param pala
     */
    public void lisaaPala(Pala pala) {
        for (Nelio n : pala.palautaPalanNeliot()) {
            lisaaKuva(n.palautaKuva(), n.palautaX(), n.palautaY());
        }
    }

    /**
     * Metodi palauttaa totuusarvon siitä, että onko kordinaatistossa kuvaa kohdassa (x,y).
     * @param x
     * @param y
     * @return totuuarvo: onko väriä kordinaatiston kohdassa
     */
    public boolean onkoKuvaa(int x, int y) {
        return this.kordinaatisto[x][y] != null;
    }

    /**
     * Metodi palauttaa kentän leveyden.
     * @return kentän leveys
     */
    public int palautaKentanLeveys() {
        return kordinaatisto.length;
    }

    /**
     * Metodi palauttaa kentän korkeuden.
     * @return kentän korkeus
     */
    public int palautaKentanKorkeus() {
        return kordinaatisto[0].length;
    }

    /** TARKISTA!!!
     * Metodi palauttaa värin kordinaatiston pisteestä. Mikäli sitä ei ole metodi palauttaa valkoista.
     * @param x
     * @param y
     * @return kordinaatiston väri
     */
    public BufferedImage palautaVari(int x, int y) {
        if (this.kordinaatisto[x][y] != null) {
            return this.kordinaatisto[x][y];
        } else {
            return null;
        }
    }
    
    /**
     * Metodi palauttaa kordinaatiston.
     * @return kordinaatisto
     */
    public BufferedImage[][] palautaKordinaatisto() {
        return kordinaatisto;
    }
}
