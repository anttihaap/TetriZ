/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetriz.kayttoliittyma;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;

/**
 * Päävalikko, josta voi aloittaa pelin, siirtyä 
 * asetusket-valikkoon ja poistua ohjelmasta.
 */
public class Paavalikko extends Valikko {

    Paaikkuna valikko;

    /**
     *
     * @param ikkuna
     */
    public Paavalikko(Paaikkuna ikkuna) {
        super(ikkuna);
        this.valikko = ikkuna;

        setLayout(new GridLayout(4, 1));
        luoNapit();
    }

    
    private void luoNapit() {
        napit = new JLabel[3];
        //akviivinenNappi = 0;
        nappienMaara = 3;

        int ylaraja = 30;
        int alaraja = 30;

        JLabel otsikko = luoValikkoteksti("TetriZ", JLabel.CENTER, JLabel.CENTER, 60, Color.white);
        add(otsikko);
        napit[0] = luoValikkoteksti("Aloita peli", JLabel.CENTER, JLabel.CENTER, 30, Color.yellow);
        napit[1] = luoValikkoteksti("Asetukset", JLabel.CENTER, JLabel.CENTER, 30, Color.white);
        napit[2] = luoValikkoteksti("Poistu", JLabel.CENTER, JLabel.CENTER, 30, Color.white);

        lisaaNapit(napit);
    }

    @Override
    public void teeKomento(int aktiivinenNappi) {
        if (aktiivinenNappi == 0) {
            valikko.aloitaPeli();
        }
        if (aktiivinenNappi == 1) {
            valikko.kaynnistaAsetuksetValikko();
        }
        if (aktiivinenNappi == 2) {
            System.exit(0);
        }
    }
}
