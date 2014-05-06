
package tetriz.kayttoliittyma;

import tetriz.logiikka.PelinAsetukset;
import javax.swing.JFrame;

/**
 * Käyttöliittymän pääikkuna, joka hallitsee paneeleita.
 */
public final class Paaikkuna extends JFrame {

    private Valikko paavalikko;
    private Valikko asetuksetValikko;

    /**
     * Pitää sisällään pelin asetukset.
     */
    public PelinAsetukset pelinAsetukset;

    private Pelipaneeli paneeli;

    /**
     * Pääikkuna toimii ikkunana, eli runkona kaikille käyttöliittymän JPaneeleille, ja hallitsee valikkoja ja pelipaneeleja.
     */
    public Paaikkuna() {
        //JFramen ominaisuudet:
        setTitle("Tetriz");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 630);
        
        asetuksetValikko = new AsetuksetValikko(this);
        paavalikko = new Paavalikko(this);
        pelinAsetukset = new PelinAsetukset();

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
        repaint();
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
     * Lopettaa pelin tuhoamalla pelipaneelin ja käynnistämällä päävalikon.
     */
    public void lopetaPeli() {
        //Poistetaan pelipaneeli ja käynnistetään päävalikko.
        getContentPane().remove(paneeli);
        kaynnistaPaavalikko();
    }
}