/*
 * KESKEN!
 */
package tetriz.logiikka;

import java.awt.Color;
import java.awt.List;
import java.util.ArrayList;

/**
 *
 * @author Antti
 */
public class Kenttalogiikka {

    public void poistaTaydetRivit(Color[][] kordinaatisto) {
        ArrayList<Integer> taydetRivit = palautaTaydetRivit(kordinaatisto);

        for (int rivi : taydetRivit) {

            //Poistetaan rivi:
            for (int x = 0; x < kordinaatisto.length; x++) {
                kordinaatisto[x][rivi] = null;
            }

            //Siirretaan jokainen yläpuolella oleva rivi 1 alas
            for (int y = rivi; y > 0; y--) {
                for (int x = 0; x < kordinaatisto.length; x++) {
                    kordinaatisto[x][y] = kordinaatisto[x][y - 1];
                }
            }          
        }
    }

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