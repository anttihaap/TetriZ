package tetriz.logiikka;

import java.awt.Color;
import java.util.Arrays;
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
    PalaLogiikka palaLogiikka;

    Kentta kentta;

    int etenemisViiveMs;

    Pala pala;

    boolean peliKaynnissa;
    Color[][] peliTilanne;

    /**
     *
     * @param etenemisViiveMs
     * @param kayttoliittyma
     */
    public Peli(int etenemisViiveMs, ValiaikainenKayttoliittyma kayttoliittyma) {
        this(10, 20, etenemisViiveMs, kayttoliittyma);
    }

    /**
     *
     * @param kentanLeveys
     * @param kentanKorkeus
     * @param etenemisViiveMs
     * @param kayttoliittyma
     */
    public Peli(int kentanLeveys, int kentanKorkeus, int etenemisViiveMs, ValiaikainenKayttoliittyma kayttoliittyma) {
        this.kentta = new Kentta(kentanLeveys, kentanKorkeus);
        this.etenemisViiveMs = etenemisViiveMs;

        this.palaLogiikka = new PalaLogiikka();
        this.kayttoliittyma = kayttoliittyma;

        this.pala = palautaUusiPala();
        this.peliTilanne = this.kentta.palautaKordinaatisto().clone();
        kayttoliittyma.kaynnistaPiirto(peliTilanne);
    }

    /**
     * Metodi aloittaa pelin, jolloin peliKaynnissa totuusarvoksi asetetaan tosi.
     * Peli etenee niin kauan kunnes peliKaynnissa on tosi. Muulloin se kutsuu metodia lopeta().
     */
    public void aloita() {
        peliKaynnissa = true;
        
        
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
        paivitaPeliTilanne();
        this.kayttoliittyma.piirraKentta(peliTilanne);
    }

    /**
     *
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
     *
     */
    public void liikutaPalaaOikealle() {
        if (palaLogiikka.voikoLiikuttaaOikealle(pala, kentta)) {
            this.pala.liikuOikealle();
            tulostaKentta();
        }
    }

    /**
     *
     */
    public void liikutaPalaaVasemmalle() {
        if (palaLogiikka.voikoLiikuttaaVasemmalle(pala, kentta)) {
            pala.liikuVasemmalle();
            tulostaKentta();
        }
    }

    /**
     * Metodi kiinnittää nykyisen palan ja luo uuden mikäli mahdollista.
     * Jos uutta palaa ei voida luoda, peliKaynnissa-totuusarvo muuttuu vääräksi.
     */
    public void seuraavaPala() {
        //Kiinnitetään nykyinen pala kentään:
        kentta.lisaaPala(pala);

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
     *
     */
    public void lopeta() {
        System.out.println("LOPPU");
    }

    /**
     * Metodi pysäyttää pelin ms muuttjan verran millisekuntteina.
     * @param ms
     */
    public void viive(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {

        }
    }

    private Pala palautaUusiPala() {
        Pala uusiPala = new Pala(this.kentta.palautaKentanLeveys() / 2,0);
        return uusiPala;
    }
    
    /**
     *
     */
    public void paivitaPeliTilanne() {
        Color[][] tilanne = this.kentta.palautaKordinaatisto().clone();
        
        //Ei toimi:
        /*
        for(Nelio n: pala.palautaPalanNeliot()) {
            tilanne[n.palautaX()][n.palautaY()] = n.palautaVari();
        }
        */
                
        peliTilanne = tilanne;
    }
}
