/*
 * KESKEN!
 */
package tetriz.logiikka;

import java.awt.Color;

/**
 *
 * @author Antti
 */
public class Kenttalogiikka {

    public void poistaTaydetRivit(Color[][] kordinaatisto) {
        int[] taydetRivit = palautaTaydetRivit(kordinaatisto);

        for (int rivi : taydetRivit) {

            //Poistetaan rivi:
            for (int x = 0; x < kordinaatisto.length; x++) {
                kordinaatisto[x][rivi] = null;
            }

            //Siirretaan jokainen yläpuolella oleva rivi 1 alas
            for (int i = rivi; i > 0; i--) {
                for (int x = 0; x < kordinaatisto.length; x++) {
                    kordinaatisto[x][i] = kordinaatisto[x][i - 1];
                }
            }          
        }
    }

    public int[] palautaTaydetRivit(Color[][] kordinaatisto) {
        int[] taydetRivit = new int[0];

        for (int y = 0; y < kordinaatisto[0].length; y++) {
            boolean riviTaysi = true;
            for (int x = 0; x < kordinaatisto.length; x++) {
                if (kordinaatisto[x][y] == null) {
                    riviTaysi = false;
                }
            }
            if (riviTaysi) {
                taydetRivit = new int[taydetRivit.length + 1];
                taydetRivit[taydetRivit.length - 1] = y;
            }
        }

        for (int i : taydetRivit) {
            System.out.println(i);
        }
        return taydetRivit;
    }

}
