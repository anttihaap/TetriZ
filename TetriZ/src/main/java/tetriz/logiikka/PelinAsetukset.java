package tetriz.logiikka;

/**
 * Luokka sisältää tiedon kaikista käyttäjän asettamista peliasetuksista.
 */


public class PelinAsetukset {
    
    private int vaikeustaso;
    private boolean varjopalaPiirretaan;
    private boolean seuraavaPalaPiirretaan;
    
    /**
     * Konstruktori asettaa oletusasetukset:
     */
    public PelinAsetukset() {
        varjopalaPiirretaan = true;
        seuraavaPalaPiirretaan = true;
        vaikeustaso = 1;
    }
    
    /**
     * Vaihtaa vaikeustasoa yhden lisää. Palautuu 1, kun vaikeustaso on 5. 
     */
    public void vaihdaVaikeustaso() {
        if (vaikeustaso == 5) {
            vaikeustaso = 1;
        } else {
            vaikeustaso++;
        }
    }
    
    /**
     * Palauttaa totuusarvon varjopalan piirtämisestä.
     * @return
     */
    public boolean palautaVarjoPalapiirretaan() {
        return varjopalaPiirretaan;
    }
    
    /**
     * Palauttaa totuusarvon seuraavan palan piirtämisestä.
     * @return piirretäänkö seuraava pala
     */
    public boolean palautaSeuraavapalaPiirretaan() {
        return seuraavaPalaPiirretaan;
    }
    
    /**
     * Palauttaa vaikeustason.
     * @return vaikeustaso
     */
    public int palautaVaikeustaso() {
        return vaikeustaso;
    }
    
    /**
     * Palauttaa pelin nopeuden (millisekuntteina) vaikeustasosta riippuen seuraavasti:
     * 1 - 500
     * 2 - 400
     * 3 - 300
     * 4 - 200
     * 5 - 100
     * @return pelin nopeus millisekuntteina
     */
    public int palautaPelinNopeus() {
        return 500 - (vaikeustaso - 1) * 100; 
    }

    /**
     * Muuttaa varjoPalaPiirretaan-totuusarvo käänteiseksi.
     */
    public void kaannaVarjopalaPiirretaan() {
        varjopalaPiirretaan = !varjopalaPiirretaan;
    }
    
    /**
     * Muuttaa kaannaSeuraavaPala-totuusarvo käänteiseksi.
     */
    public void kaannaSeuraavaPalapiirretaan() {
        seuraavaPalaPiirretaan = !seuraavaPalaPiirretaan;
    }
}
