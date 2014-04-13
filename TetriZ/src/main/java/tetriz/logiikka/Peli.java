package tetriz.logiikka;

import java.awt.Color;
import tetriz.kayttoliittyma.ValiaikainenKayttoliittyma;
import tetriz.peliElementit.Kentta;
import tetriz.peliElementit.Nelio;
import tetriz.peliElementit.Pala;

/**
 *
 * @author Antti
 */
public class Peli {

    ValiaikainenKayttoliittyma kayttoliittyma;

    Palalogiikka palaLogiikka;
    Kenttalogiikka kenttalogiikka;

    Tilasto tilasto;

    Kentta kentta;
    int etenemisViiveMs;
    
    private final int kiinteaetenemisviive;
    
    Pala pala;
    boolean peliKaynnissa;

    /**
     * Kuvantaa pelin tilannetta.
     */
    public Color[][] peliTilanne;

    public Peli(int etenemisViiveMs, ValiaikainenKayttoliittyma kayttoliittyma) {
        this(10, 20, etenemisViiveMs, kayttoliittyma);
    }

    public Peli(int kentanLeveys, int kentanKorkeus, int etenemisViiveMs, ValiaikainenKayttoliittyma kayttoliittyma) {
        this.kentta = new Kentta(kentanLeveys, kentanKorkeus);
        this.etenemisViiveMs = etenemisViiveMs;
        this.kiinteaetenemisviive = etenemisViiveMs;

        this.palaLogiikka = new Palalogiikka();
        this.kenttalogiikka = new Kenttalogiikka();
        this.kayttoliittyma = kayttoliittyma;
        

        this.pala = palautaUusiPala();
        this.peliTilanne = paivitaPeliTilanne();
        this.tilasto = new Tilasto();
    }

    /**
     * Metodi aloittaa pelin, jolloin peliKaynnissa totuusarvoksi asetetaan
     * tosi. Peli etenee kunnes peliKaynnissa on tosi. Muulloin se kutsuu
     * metodia lopeta().
     */
    public void aloita() {
        peliKaynnissa = true;

        this.kayttoliittyma.kaynnistaPiirto();

        tulostaKentta();

        while (peliKaynnissa) {
            etene();
        }
        lopeta();
    }

    private void etene() {
        viive(etenemisViiveMs);
        liikutaPalaaAlas();
    }

    private void tulostaKentta() {
        this.peliTilanne = paivitaPeliTilanne();
        this.kayttoliittyma.piirraKentta();
    }

    /**
     * Metodi yrittää liikuttaa palaa alas. Jos palaa ei voida liikuttaa,
     * kutsutaan metodia seuraavaPala().
     */
    public void liikutaPalaaAlas() {
        if (palaLogiikka.voikoLiikuttaaAlas(pala, kentta)) {
            this.pala.liikuAlas();
            tulostaKentta();
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
            tulostaKentta();
        }
    }

    /**
     * Metodi liikuttaa palaa vasemmalle.
     */
    public void liikutaPalaaVasemmalle() {
        if (palaLogiikka.voikoLiikuttaaVasemmalle(pala, kentta)) {
            pala.liikuVasemmalle();
            tulostaKentta();
        }
    }

    public void kaannaPalaaOikealle() {
        if (!this.pala.palautaTetrispalatyypinNimi().equals("NELIOPALA") && palaLogiikka.voikoKaantaa(pala, kentta)) {
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
            tulostaKentta();
        }
    }

    /**
     * Pelin lopetus.
     */
    public void lopeta() {
        this.kayttoliittyma.lopetaPeli();
    }

    /**
     * Metodi pysäyttää pelin ms-muuttjan verran millisekuntteina.
     *
     * @param ms
     */
    private void viive(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {

        }
    }

    private Pala palautaUusiPala() {
        Pala uusiPala = new Pala(this.kentta.palautaKentanLeveys() / 2, 0);
        return uusiPala;
    }
    
    private void havitaRivit() {
        kenttalogiikka.poistaTaydetRivit(this.kentta.palautaKordinaatisto());
    }

    /**
     * Metodi päivittää pelitilannetta.
     */
    private Color[][] paivitaPeliTilanne() {
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
