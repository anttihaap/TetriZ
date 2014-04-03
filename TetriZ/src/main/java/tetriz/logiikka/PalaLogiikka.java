package tetriz.logiikka;

import tetriz.peliElementit.Kentta;
import tetriz.peliElementit.Nelio;
import tetriz.peliElementit.Pala;

public class PalaLogiikka {

    Kentta kentta;

    public PalaLogiikka(Kentta kentta) {
        this.kentta = kentta;
    }

    /**
     * Metodi palauttaa totuusarvon siitä, että voiko kyseisen palan luoda kenttään.
     * 
     * @param pala
     * @return 
     */
    public boolean voidaankoLuoda(Pala pala) {
        for (Nelio n : pala.palautaPalanNeliot()) {
            if (kentta.onkoVaria(n.palautaX(), n.palautaY())) {
                return false;
            }
        }
        return true;
    }

    public boolean voikoLiikuttaaAlas(Pala pala) {
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

    public boolean voikoLiikuttaaOikealle(Pala pala) {
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

    public boolean voikoLiikuttaaVasemmalle(Pala pala) {
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
