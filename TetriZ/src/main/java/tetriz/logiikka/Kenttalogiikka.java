
package tetriz.logiikka;

import java.awt.Color;
import java.util.ArrayList;

/**
 *
 * @author Antti
 */
public class Kenttalogiikka {

    /**
     * Metodi poistaa annetut rivit listan poistetavarRivit mukaan kordinaatistosta. 
     * @param kordinaatisto
     * @param poisetttavatRivit
     */
    public void poistaRivit(Color[][] kordinaatisto, ArrayList<Integer> poisetttavatRivit) {
        ArrayList<Integer> taydetRivit = poisetttavatRivit;

        for (int rivi : taydetRivit) {
            //Siirretaan jokainen yläpuolella oleva rivi 1 alas poistettavan päälle
            for (int y = rivi; y > 0; y--) {
                for (int x = 0; x < kordinaatisto.length; x++) {
                    kordinaatisto[x][y] = kordinaatisto[x][y - 1];
                }
            }          
        }
    }

    /**
     * Palauttaa listan kordinaatiston riveistä, jotka ovat täynnä.
     * @param kordinaatisto
     * @return
     */
    public ArrayList<Integer> palautaTaydetRivit(Color[][] kordinaatisto) {
        ArrayList<Integer> taydetrivit = new ArrayList<>();

        for (int y = 0; y < kordinaatisto[0].length; y++) {
            boolean riviTaysi = true;
            for (int x = 0; x < kordinaatisto.length; x++) {
                if (kordinaatisto[x][y] == null) {
                    riviTaysi = false;
                }
            }
            if (riviTaysi) {
                taydetrivit.add(y);
            }
        }

        return taydetrivit;
    }
}