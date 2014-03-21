package tetriz.logiikka;

import tetriz.peliElementit.Kentta;
import tetriz.peliElementit.Pala;
import tetriz.piirto.KentanPiirto;

public class Peli {

    Kentta kentta;
    KentanPiirto kentanPiirto;
    int etenemisViiveMs;

    Pala pala;
    PalaHallinta palaHallinta;

    boolean peliKaynnissa;

    public Peli(int kentanLeveys, int kentanKorkeus, int etenemisViiveMs) {     
        this.kentta = new Kentta(kentanLeveys, kentanKorkeus);
        this.etenemisViiveMs = etenemisViiveMs;
        
        this.kentanPiirto = new KentanPiirto();
        
        this.palaHallinta = new PalaHallinta(kentta);
        this.pala = palaHallinta.palautaSatunnainenPala();
        
        peliKaynnissa = true;
    }

    public void aloita() {
        tulostaKentta();
        while (peliKaynnissa) {
            etene();
        }
        lopetaPeli();
    }

    public void etene() {
        viive(etenemisViiveMs);
        liikutaPalaaAlas();
    }

    public void tulostaKentta() {
        this.kentanPiirto.piirra(kentta, pala);
    }

    public void liikutaPalaaAlas() {
        if (palaHallinta.voikoPalaaLiikuttaaKartassaSuuntaan(pala, 0, 1)) {
            this.pala.liikutaPalaaAlas();
            tulostaKentta();
        } else {
            luoUusiPala();
        }
    }

    public void liikutaPalaaOikealle() {
        if (palaHallinta.voikoPalaaLiikuttaaKartassaSuuntaan(pala, 1, 0)) {
            this.pala.liikuOikealle();
            tulostaKentta();
        }
    }

    public void liikutaPalaaVasemmalle() {
        if (palaHallinta.voikoPalaaLiikuttaaKartassaSuuntaan(pala, -1, 0)) {
            pala.liikuVasemmalle();
            tulostaKentta();
        }
    }

    public void luoUusiPala() {
        kentta.lisaaPalaKenttaan(pala);
        Pala uusiPala = palaHallinta.palautaSatunnainenPala();
        
        //Jos uutta palaa ei voida luoda, peli päättyy
        if (palaHallinta.voikoPalaaLiikuttaaKartassaSuuntaan(uusiPala, 0, 0)) {
            this.pala = uusiPala;
            tulostaKentta();
        } else {
            peliKaynnissa = false;
        }
    }

    public void lopetaPeli() {
        System.out.println("LOPPU");
    }

    public void viive(int ms) {
        try {
            Thread.sleep(ms);
        } catch (InterruptedException e) {

        }
    }
}
