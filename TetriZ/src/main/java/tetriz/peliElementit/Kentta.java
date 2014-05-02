package tetriz.peliElementit;

import java.awt.image.BufferedImage;

/**
 * Kentta sisältää kordinaatiston, joka pitää sisällään kuvia.
 */
public class Kentta {

    private final BufferedImage[][] kordinaatisto;

    /**
     * Konstuktori luo kordinaatiston käyttäen leveyttä ja korkeutta.
     * @param kentanLeveys leveys
     * @param kentanKorkeus korkeus
     */
    public Kentta(int kentanLeveys, int kentanKorkeus) {
        this.kordinaatisto = new BufferedImage[kentanLeveys][kentanKorkeus];
    }

    /**
     * Metodi lisää värin kordinaatistoon käyttäen x ja y parametreja, 
     * jotka vastaavat paikkaa kordinaatistossa.
     * @param kuva lisattava kuva
     * @param x x-kordinaatti
     * @param y y-kordinaatti
     */
    public void lisaaKuva(BufferedImage kuva, int x, int y) {
        this.kordinaatisto[x][y] = kuva;
    }

    /**
     * Metodi lisää palan kuvat kenttään käymällä palan neliot läpi. 
     * @param pala lisattava pala
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
     * Palauttaa kentän leveyden.
     * @return kentän leveys
     */
    public int palautaKentanLeveys() {
        return kordinaatisto.length;
    }

    /**
     * Palauttaa kentän korkeuden.
     * @return kentän korkeus
     */
    public int palautaKentanKorkeus() {
        return kordinaatisto[0].length;
    }

    /**
     * Palauttaa kuvan kordinaatiston pisteestä. Mikäli sitä ei ole metodi palauttaa valkoista.
     * @param x
     * @param y
     * @return kordinaatiston kuva
     */
    public BufferedImage palautaKuva(int x, int y) {
        return this.kordinaatisto[x][y];
    }
    
    /**
     * Metodi keätän palauttaa kordinaatiston.
     * @return kordinaatisto
     */
    public BufferedImage[][] palautaKordinaatisto() {
        return kordinaatisto;
    }
}