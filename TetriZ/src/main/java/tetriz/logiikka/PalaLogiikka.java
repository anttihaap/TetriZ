package tetriz.logiikka;

import tetriz.peliElementit.Kentta;
import tetriz.peliElementit.Nelio;
import tetriz.peliElementit.Pala;

public class PalaLogiikka {


    /**
     * Metodi palauttaa totuusarvon siitä, että voiko kyseisen palan luoda kenttään.  
     * @param pala
     * @return totuusarvo luonnista
     */
    public boolean voidaankoLuoda(Pala pala, Kentta k) {
        for (Nelio n : pala.palautaPalanNeliot()) {
            if (k.onkoVaria(n.palautaX(), n.palautaY())) {
                return false;
            }
        }
        return true;
    }

    /**
     * Metodi palauttaa totuusarvon siitä, että voiko kyseistä palaa liikuttaa kentässä alaspäin. 
     * @param pala
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
     * Metodi palauttaa totuusarvon siitä, että voiko kyseistä palaa liikuttaa kentässä oikealle. 
     * @param pala
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
     * Metodi palauttaa totuusarvon siitä, että voiko kyseistä palaa liikuttaa kentässä vasemmalle. 
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

}
