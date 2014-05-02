
package tetriz.kayttoliittyma;

import tetriz.logiikka.PelinAsetukset;
import javax.swing.JFrame;

/**
 * Käyttöliittymän pääikkuna, joka hallitsee paneeleita.
 */
public class Paaikkuna extends JFrame {

    private final Valikko kirjautumisvalikko;
    private final Valikko paavalikko;
    private final Valikko asetuksetValikko;

    /**
     *
     */
    public PelinAsetukset pelinAsetukset;

    private Pelipaneeli paneeli;

    /**
     *
     */
    public Paaikkuna() {
        //JFramen ominaisuudet:
        setTitle("Tetriz");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 630);
        

        kirjautumisvalikko = new KirjautumisValikko(this);
        asetuksetValikko = new AsetuksetValikko(this);
        paavalikko = new Paavalikko(this);
        pelinAsetukset = new PelinAsetukset();

        /*
        getContentPane().add(kirjautumisvalikko);
        addKeyListener(kirjautumisvalikko);
        */
        kaynnistaPaavalikko();
        setVisible(true);
    }

    /**
     * Käynnistää päävalikkon.
     */
    public void kaynnistaPaavalikko() {
        //Poistetaa asetukset valikon ominaisuudet:
        getContentPane().remove(asetuksetValikko);
        removeKeyListener(asetuksetValikko);

        //Lisätään päävalikon ominaisuudet
        getContentPane().add(paavalikko);
        addKeyListener(paavalikko);
        paavalikko.repaint();
    }

    /**
     * Käynnistää asetukset-valikon.
     */
    public void kaynnistaAsetuksetValikko() {
        //Poistetaan päävalikon ominaisuudet:
        removeKeyListener(paavalikko);
        getContentPane().remove(paavalikko);

        //Lisätään asetuksetValikon ominaisuudet:
        getContentPane().add(asetuksetValikko);
        addKeyListener(asetuksetValikko);
        setVisible(true);
    }

    /**
     * Aloittaa uuden pelin käynnistämällä pelipaneelin.
     */
    public void aloitaPeli() {
        //Paavalikko pois, keylistener pois, uusipaneeli ja sen lisäys.
        getContentPane().removeAll();
        removeKeyListener(paavalikko);
        paneeli = new Pelipaneeli(this);
        getContentPane().add(paneeli);
    }

    /**
     *
     */
    public void lopetaPeli() {
        //Poistetaan pelipaneeli ja käynnistetään päävalikko.
        getContentPane().remove(paneeli);
        kaynnistaPaavalikko();
    }
}
