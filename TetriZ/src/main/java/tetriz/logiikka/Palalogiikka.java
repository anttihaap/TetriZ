package tetriz.logiikka;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import tetriz.peliElementit.Kentta;
import tetriz.peliElementit.Nelio;
import tetriz.peliElementit.Pala;

/**
 *
 * @author Antti
 */
public class Palalogiikka {

    /**
     * Metodi palauttaa totuusarvon siitä, että voiko kyseisen palan luoda
     * kenttään.
     *
     * @param pala
     * @param kentta
     * @return totuusarvo luonnista
     */
    public boolean voidaankoLuoda(Pala pala, Kentta kentta) {

        for (Nelio n : pala.palautaPalanNeliot()) {
            if (!kordinaattiOnKentanSisalla(n.palautaX(), n.palautaY(), kentta)) {
                return false;
            }
            if (kentta.onkoVaria(n.palautaX(), n.palautaY())) {
                return false;
            }
        }
        return true;
    }

    /**
     * Metodi palauttaa totuusarvon siitä, että voiko kyseistä palaa liikuttaa
     * kentässä alaspäin.
     *
     * @param pala
     * @param kentta
     * @return totuusarvo palan liikuttamisesta alas
     */
    public boolean voikoLiikuttaaAlas(Pala pala, Kentta kentta) {
        for (Nelio n : pala.palautaPalanNeliot()) {
            if (n.palautaY() + 1 >= kentta.palautaKentanKorkeus()) {
                return false;
            }
            if (kentta.onkoVaria(n.palautaX(), n.palautaY() + 1)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Metodi palauttaa totuusarvon siitä, että voiko kyseistä palaa liikuttaa
     * kentässä oikealle.
     *
     * @param pala
     * @param kentta
     * @return tootusarvo palan liikuttamisesta oikealle
     */
    public boolean voikoLiikuttaaOikealle(Pala pala, Kentta kentta) {
        for (Nelio n : pala.palautaPalanNeliot()) {
            if (n.palautaX() + 1 >= kentta.palautaKentanLeveys()) {
                return false;
            }
            if (kentta.onkoVaria(n.palautaX() + 1, n.palautaY())) {
                return false;
            }
        }
        return true;
    }

    /**
     * Metodi palauttaa totuusarvon siitä, että voiko kyseistä palaa liikuttaa
     * kentässä vasemmalle.
     *
     * @param pala
     * @param kentta
     * @return totuusarvo palan liikuttamisesta vasemmalle
     */
    public boolean voikoLiikuttaaVasemmalle(Pala pala, Kentta kentta) {
        for (Nelio n : pala.palautaPalanNeliot()) {
            if (n.palautaX() - 1 < 0) {
                return false;
            }
            if (kentta.onkoVaria(n.palautaX() - 1, n.palautaY())) {
                return false;
            }
        }
        return true;
    }

    /**
     *
     * @param x
     * @param y
     * @param kentta
     * @return
     */
    public boolean kordinaattiOnKentanSisalla(int x, int y, Kentta kentta) {
        return x >= 0 && y >= 0 && x < kentta.palautaKentanLeveys() && y < kentta.palautaKentanKorkeus();
    }

    /**
     *
     * @param pala
     * @param kentta
     * @return
     */
    public boolean voikoKaantaa(Pala pala, Kentta kentta) {
        // Pala pala = (Pala) pala.clone() 
        // 
        // ei toimi? käsin kopioitu:
        Pala kaannettyPala = new Pala(0, 0);
        
        for (int i = 0; i < 4; i++) {
            kaannettyPala.palautaPalanNeliot()[i] = new Nelio(pala.palautaPalanNeliot()[i].palautaX(), pala.palautaPalanNeliot()[i].palautaY(), pala.palautaVari());
        }
        
        kaannettyPala.kaannaOikealle();
        
        return voidaankoLuoda(kaannettyPala, kentta);
    }
}
