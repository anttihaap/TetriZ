package tetriz.logiikka;

import java.awt.Color;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;
import javax.swing.JFrame;
import javax.swing.JPanel;
import tetriz.peliElementit.Kentta;
import tetriz.peliElementit.Nelio;
import tetriz.peliElementit.Pala;

/**
 *
 * @author Antti
 */
public class Peli {

    Palalogiikka palaLogiikka;
    Kenttalogiikka kenttalogiikka;

    Tilasto tilasto;

    Kentta kentta;
    int etenemisViiveMs;
    
    private final int kiinteaetenemisviive;
    
    Pala pala;
    public boolean peliKaynnissa;


    public Peli(int etenemisViiveMs) {
        this(10, 20, etenemisViiveMs);
    }

    public Peli(int kentanLeveys, int kentanKorkeus, int etenemisViiveMs) {
        this.kentta = new Kentta(kentanLeveys, kentanKorkeus);
        this.etenemisViiveMs = etenemisViiveMs;
        this.kiinteaetenemisviive = etenemisViiveMs;

        this.palaLogiikka = new Palalogiikka();
        this.kenttalogiikka = new Kenttalogiikka();

        this.pala = palautaUusiPala();
        this.tilasto = new Tilasto();
        peliKaynnissa = false;
    }

    /**
     * Metodi aloittaa pelin, jolloin peliKaynnissa totuusarvoksi asetetaan
     * tosi. Peli etenee kunnes peliKaynnissa on tosi. Muulloin se kutsuu
     * metodia lopeta().
     */
    public void aloita() {
        peliKaynnissa = true;
    }



    /**
     * Metodi yrittää liikuttaa palaa alas. Jos palaa ei voida liikuttaa,
     * kutsutaan metodia seuraavaPala().
     */
    public void liikutaPalaaAlas() {
        if (palaLogiikka.voikoLiikuttaaAlas(pala, kentta)) {
            this.pala.liikuAlas();
        } else {
            seuraavaPala();
        }
    }

    /**
     * Metodi liikuttaa palaa oikealle.
     */
    public void liikutaPalaaOikealle() {
        if (palaLogiikka.voikoLiikuttaaOikealle(pala, kentta)) {
            this.pala.liikuOikealle();
        }
    }

    /**
     * Metodi liikuttaa palaa vasemmalle.
     */
    public void liikutaPalaaVasemmalle() {
        if (palaLogiikka.voikoLiikuttaaVasemmalle(pala, kentta)) {
            pala.liikuVasemmalle();
        }
    }

    public void kaannaPalaaOikealle() {
        if (palaLogiikka.voikoKaantaa(pala, kentta)) {
            this.pala.kaannaOikealle();
        } 
    }

    /**
     * Metodi kiinnittää nykyisen palan kenttään ja luo uuden mikäli
     * mahdollista. Jos uutta palaa ei voida luoda, peliKaynnissa-totuusarvo
     * muuttuu epätodeksi.
     */
    private void seuraavaPala() {
        //Kiinnitetään nykyinen pala kentään:
        kentta.lisaaPala(pala);
        havitaRivit();

        this.tilasto.kasvataPistetta(1);

        //Luodaan seuraava pala entisen tilalle:
        Pala seuraavaPala = palautaUusiPala();

        //Jos uutta palaa ei voida luoda, peli päättyy
        if (!palaLogiikka.voidaankoLuoda(seuraavaPala, kentta)) {
            peliKaynnissa = false;
        } else {
            this.pala = seuraavaPala;
        }
    }

    private Pala palautaUusiPala() {
        Pala uusiPala = new Pala(this.kentta.palautaKentanLeveys() / 2, 0);
        return uusiPala;
    }
    
    private void havitaRivit() {
        ArrayList<Integer> taydetRivit = kenttalogiikka.palautaTaydetRivit(paivitaPeliTilanne());
        
        //kayttoliittyma.valkytaRiveja(taydetRivit, 5);
        
        kenttalogiikka.poistaRivit(this.kentta.palautaKordinaatisto(), taydetRivit);
    }

    /**
     * Metodi päivittää pelitilannetta.
     */
    public Color[][] paivitaPeliTilanne() {
        Color[][] kentanKordinaatiosto = this.kentta.palautaKordinaatisto().clone();
        Color[][] peliTilanneNyt = new Color[this.kentta.palautaKentanLeveys()][this.kentta.palautaKentanKorkeus()];

        for (int i = 0; i < kentanKordinaatiosto.length; i++) {
            System.arraycopy(kentanKordinaatiosto[i], 0, peliTilanneNyt[i], 0, kentanKordinaatiosto[i].length);
        }

        for (Nelio n : this.pala.palautaPalanNeliot()) {
            peliTilanneNyt[n.palautaX()][n.palautaY()] = n.palautaVari();
        }

        return peliTilanneNyt;
    }

    public int palautaPisteet() {
        return this.tilasto.palautaPisteet();
    }
    
    public void nopeutaPelia() {
        this.etenemisViiveMs = 70;
    }
    
    public void nopeusNormaaliksi() {
        this.etenemisViiveMs = kiinteaetenemisviive;
    }
}