package tetriz.logiikka;

import java.awt.Color;
import tetriz.kayttoliittyma.ValiaikainenKayttoliittyma;
import tetriz.peliElementit.Kentta;
import tetriz.peliElementit.Nelio;
import tetriz.peliElementit.Pala;

public class Peli {

    ValiaikainenKayttoliittyma kayttoliittyma;
    PalaLogiikka palaLogiikka;

    Kentta kentta;

    int etenemisViiveMs;

    Pala pala;

    boolean peliKaynnissa;

    public Peli(int etenemisViiveMs, ValiaikainenKayttoliittyma kayttoliittyma) {
        this(10, 20, etenemisViiveMs, kayttoliittyma);
    }

    public Peli(int kentanLeveys, int kentanKorkeus, int etenemisViiveMs, ValiaikainenKayttoliittyma kayttoliittyma) {
        this.kentta = new Kentta(kentanLeveys, kentanKorkeus);
        this.etenemisViiveMs = etenemisViiveMs;

        this.palaLogiikka = new PalaLogiikka(kentta);
        this.kayttoliittyma = kayttoliittyma;

        this.pala = palautaUusiPala();
    }

    public void aloita() {
        peliKaynnissa = true;
        
        kayttoliittyma.kaynnistaPiirto(palautaPeliTilanne());
        tulostaKentta();

        while (peliKaynnissa) {
            etene();
        }
        lopeta();
    }

    public void etene() {
        viive(etenemisViiveMs);
        liikutaPalaaAlas();
    }

    public void tulostaKentta() {
        this.kayttoliittyma.piirraKentta(palautaPeliTilanne());
    }

    public void liikutaPalaaAlas() {
        if (palaLogiikka.voikoLiikuttaaAlas(pala)) {
            this.pala.liikuAlas();
            tulostaKentta();
        } else {
            seuraavaPala();
        }
    }

    public void liikutaPalaaOikealle() {
        if (palaLogiikka.voikoLiikuttaaOikealle(pala)) {
            this.pala.liikuOikealle();
            tulostaKentta();
        }
    }

    public void liikutaPalaaVasemmalle() {
        if (palaLogiikka.voikoLiikuttaaVasemmalle(pala)) {
            pala.liikuVasemmalle();
            tulostaKentta();
        }
    }

    public void seuraavaPala() {
        //Kiinnitetään nykyinen pala kentään:
        kentta.lisaaPala(pala);

        //Luodaan seuraava pala entisen tilalle:
        Pala seuraavaPala = palautaUusiPala();

        //Jos uutta palaa ei voida luoda, peli päättyy
        if (!palaLogiikka.voidaankoLuoda(seuraavaPala)) {
            peliKaynnissa = false;
        } else {
            this.pala = seuraavaPala;
            tulostaKentta();
        }
    }

    public void lopeta() {
        System.out.println("LOPPU");
    }

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

    public Color[][] palautaPeliTilanne() {
        Color[][] kentanTilanneJaPala = new Color[this.kentta.palautaKentanLeveys()][this.kentta.palautaKentanKorkeus()];
              
                
        for (Nelio n : pala.palautaPalanNeliot()) {
            kentanTilanneJaPala[n.palautaX()][n.palautaY()] = n.palautaVari();
        }
                
                                
        return kentanTilanneJaPala;
    }
}
