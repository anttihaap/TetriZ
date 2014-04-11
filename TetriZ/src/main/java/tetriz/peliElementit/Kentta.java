package tetriz.peliElementit;

import java.awt.Color;

/**
 * Kentta sisältää kordinaatiston, joka pitää sisällään eri värejä.
 * @author Antti
 */
public class Kentta {

    private final int kentanKorkeus;
    private final int kentanLeveys;
    private Color[][] kordinaatisto;

    public Kentta(int kentanLeveys, int kentanKorkeus) {
        this.kentanLeveys = kentanLeveys;
        this.kentanKorkeus = kentanKorkeus;
        this.kordinaatisto = new Color[kentanLeveys][kentanKorkeus];
    }

    /**
     * Metodi lisää värin kordinaatistoon käyttäen x ja y parametreja, jotka vastaa paikkaa kordinaatistossa.
     * @param vari
     * @param x
     * @param y
     */
    public void lisaaVari(Color vari, int x, int y) {
        this.kordinaatisto[x][y] = vari;
    }

    /**
     * Metodi lisää palan värit kentään käymällä palan neliot läpi ja lisäämällä ne lisaaVari() -metodia käyttäen.
     * @param pala
     */
    public void lisaaPala(Pala pala) {
        for (Nelio n : pala.palautaPalanNeliot()) {
            lisaaVari(n.palautaVari(), n.palautaX(), n.palautaY());
        }
    }

    /**
     * Metodi palauttaa totuusarvon siitä, että onko kordinaatistossa väriä kohdassa (x,y).
     * @param x
     * @param y
     * @return totuuarvo: onko väriä kordinaatiston kohdassa
     */
    public boolean onkoVaria(int x, int y) {
        return this.kordinaatisto[x][y] != null;
    }

    /**
     * Metodi palauttaa kentän leveyden.
     * @return kentän leveys
     */
    public int palautaKentanLeveys() {
        return kentanLeveys;
    }

    /**
     * Metodi palauttaa kentän korkeuden.
     * @return kentän korkeus
     */
    public int palautaKentanKorkeus() {
        return kentanKorkeus;
    }

    /**
     * Metodi palauttaa värin kordinaatiston pisteestä. Mikäli sitä ei ole metodi palauttaa valkoista.
     * @param x
     * @param y
     * @return kordinaatiston väri
     */
    public Color palautaVari(int x, int y) {
        if (this.kordinaatisto[x][y] != null) {
            return this.kordinaatisto[x][y];
        } else {
            return Color.white;
        }
    }
    
    /**
     * Metodi palauttaa kordinaatiston.
     * @return kordinaatisto
     */
    public Color[][] palautaKordinaatisto() {
        return kordinaatisto;
    }
}
