
package tetriz.kayttoliittyma;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JLabel;

/**
 * Asetukset-valikko, jossa käyttäjä voi vaihtaa pelin asetuksia.
 */
public class AsetuksetValikko extends Valikko {

    Paaikkuna valikko;

    /**
     *
     * @param ikkuna
     */
    public AsetuksetValikko(Paaikkuna ikkuna) {
        super(ikkuna);
        this.valikko = ikkuna;
        setLayout(new GridLayout(4, 1));
        setVisible(true);
        luoNapit();
    }

    private void luoNapit() {       
        napit = new JLabel[4];
        akviivinenNappi = 0;
        nappienMaara = napit.length;

        napit[0] = luoValikkoteksti("Vaikeustaso: 1", JLabel.CENTER, JLabel.CENTER, 30, Color.yellow);
        napit[1] = luoValikkoteksti("Varjopala piirretään: KYLLÄ", JLabel.CENTER, JLabel.CENTER, 30, Color.white);
        napit[2] = luoValikkoteksti("Seuraava pala piirretään: KYLLÄ", JLabel.CENTER, JLabel.CENTER, 30, Color.white);
        napit[3] = luoValikkoteksti("Takaisin päävalikkkoon", JLabel.CENTER, JLabel.CENTER, 30, Color.white);

        lisaaNapit(napit);
    }

    /**
     *
     * @param aktiivinenNappi
     */
    @Override
    public void teeKomento(int aktiivinenNappi) {
        if (aktiivinenNappi == 0) {
            valikko.pelinAsetukset.vaihdaVaikeustaso();
            napit[0].setText("Vaikeustaso: " + valikko.pelinAsetukset.palautaVaikeustaso());
        }

        if (aktiivinenNappi == 1) {
            if (valikko.pelinAsetukset.palautaVarjoPalapiirretaan()) {
                napit[1].setText("Varjopala piirretään: EI");
            } else {
                napit[1].setText("Varjopala piirretään: KYLLÄ");
            }
            valikko.pelinAsetukset.kaannaVarjopalaPiirretaan();
        }

        if (aktiivinenNappi == 2) {
            if (valikko.pelinAsetukset.palautaSeuraavapalaPiirretaan()) {
                napit[2].setText("Seuraava pala piiretään: EI");
            } else {
                napit[2].setText("Seuraava pala piirretään: KYLLÄ");
            }
            valikko.pelinAsetukset.kaannaSeuraavaPalapiirretaan();
        }

        if (aktiivinenNappi == 3) {
            valikko.kaynnistaPaavalikko();
        }
    }
}
