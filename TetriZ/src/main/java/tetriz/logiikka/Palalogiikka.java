package tetriz.logiikka;

import tetriz.peliElementit.Kentta;
import tetriz.peliElementit.Nelio;
import tetriz.peliElementit.Pala;
import tetriz.peliElementit.Tetrispalatyypit;

/**
 * Luokka päättää voiko paloja liikuttaa tai kääntää kentän sisällä. 
 */
public class Palalogiikka {

    /**
     * Metodi palauttaa totuusarvon siitä, että voiko kyseisen palan luoda
     * kenttään. Palaa voidaan luoda jos ja vain jos, kentän kohdat ovat tyhjiä.
     *
     * @param pala
     * @param kentta
     * @return totuusarvo luonnista
     */
    public boolean voidaankoLuoda(Pala pala, Kentta kentta) {
        for (Nelio n : pala.palautaPalanNeliot()) {
            if (kentta.onkoKuvaa(n.palautaX(), n.palautaY())) {
                return false;
            }
        }
        return true;
    }

    /**
     * Metodi palauttaa totuusarvon siitä, että voiko kyseistä palaa liikuttaa
     * kentässä alaspäin. Palaa ei voida luoda, jos pala on kentän alalaidassa 
     * tai palan alapuoli ei ole thjä.
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
            
            if (kentta.onkoKuvaa(n.palautaX(), n.palautaY() + 1)) {
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
            if (kentta.onkoKuvaa(n.palautaX() + 1, n.palautaY())) {
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
            //Tilanteessa, jossa x = 0 pala on reunalla.
            if (n.palautaX() == 0) {
                return false;
            }
            if (kentta.onkoKuvaa(n.palautaX() - 1, n.palautaY())) {
                return false;
            }
        }
        return true;
    }

    /**
     * Metodi tarkistaa, että pala on kentän kordinaattien sisällä.
     * 
     * @param pala 
     * @param kentta
     * @return Onko pala kentän kordinaattien sisällä.
     */
    public boolean palaOnKordinaattisenSisalla(Pala pala, Kentta kentta) {
        for (Nelio n : pala.palautaPalanNeliot()) {
            if (!(n.palautaX() >= 0 && n.palautaY() >= 0 && n.palautaX() < kentta.palautaKentanLeveys() && n.palautaY() < kentta.palautaKentanKorkeus())) {
                return false;
            }
        }
        return true;
    }

    /**
     * Tarkistaa, että palaa voi kääntää kentän sisällä.
     * @param pala Pala jota käännetään.
     * @param kentta Kenttä, jossa pala käännetään.
     * @return Voiko palaa kääntää kentässä.
     */
    public boolean voikoKaantaa(Pala pala, Kentta kentta) {
        
        //Neliopalaa ei käännetä.
        if (pala.palautaTetrispalatyyppi() == Tetrispalatyypit.NELIOPALA) {
            return false;
        }
        // Pala pala = (Pala) pala.clone() 
        // 
        // ei toimi? käsin kopioitu:
        Pala kaannettyPala = new Pala(0, 0);
        Nelio[] palanNeliot = pala.palautaPalanNeliot();
        
        for (int i = 0; i < 4; i++) {
            kaannettyPala.palautaPalanNeliot()[i] = new Nelio(palanNeliot[i].palautaX(), palanNeliot[i].palautaY(), palanNeliot[i].palautaKuva());
        }
        
        kaannettyPala.kaannaOikealle();
        
        return palaOnKordinaattisenSisalla(kaannettyPala, kentta) && voidaankoLuoda(kaannettyPala, kentta);
    }
}
