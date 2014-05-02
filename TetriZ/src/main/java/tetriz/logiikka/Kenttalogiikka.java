package tetriz.logiikka;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 * Kenttalogiikka-luokka käsittelee kenttää: poistaa rivejä ja palauttaa rivejä, jotka ovat täynnä.
 */
public class Kenttalogiikka {

    /**
     * Metodi poistaa annetut rivit kordinaatistosta listan poistetavarRivit
     * mukaan.
     *
     * @param kordinaatisto
     * @param poisetttavatRivit
     */
    public void poistaRivit(BufferedImage[][] kordinaatisto, ArrayList<Integer> poisetttavatRivit) {
        ArrayList<Integer> taydetRivit = poisetttavatRivit;

        for (int rivi : taydetRivit) {
            //Siirretaan jokainen yläpuolella oleva rivi 1 alas poistettavan päälle.
            //Paitsi ylinrivi tyhjennetään.
            for (int y = rivi; y >= 0; y--) {
                for (int x = 0; x < kordinaatisto.length; x++) {
                    
                    //Jos ylin rivi on täynnä, muutetaan kaikki rivin kohdat tyhjiksi.
                    //Muulloin siirretään ylin rivi alas.
                    if (y == 0) {
                        kordinaatisto[x][y] = null;
                    } else {
                        kordinaatisto[x][y] = kordinaatisto[x][y - 1];
                    }
                }
            }
        }
    }

    /**
     * Palauttaa listan kordinaatiston riveistä, jotka ovat täynnä.
     *
     * @param kordinaatisto
     * @return taydetRivit taydet rivit
     */
    public ArrayList<Integer> palautaTaydetRivit(BufferedImage[][] kordinaatisto) {
        ArrayList<Integer> taydetRivit = new ArrayList<>();

        for (int y = 0; y < kordinaatisto[0].length; y++) {
            boolean riviTaysi = true;
            for (int x = 0; x < kordinaatisto.length; x++) {
                if (kordinaatisto[x][y] == null) {
                    riviTaysi = false;
                    break;
                }
            }
            if (riviTaysi) {
                taydetRivit.add(y);
            }
        }

        return taydetRivit;
    }
}
