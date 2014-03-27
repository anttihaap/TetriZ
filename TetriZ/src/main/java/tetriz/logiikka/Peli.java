package tetriz.logiikka;

import tetriz.peliElementit.Kentta;
import tetriz.peliElementit.Pala;
import tetriz.piirto.KentanPiirto;

public class Peli {

    Kentta kentta;
    KentanPiirto kentanPiirto;
    int etenemisViiveMs;

    Pala pala;
    PalaLogiikka palaHallinta;

    boolean peliKaynnissa;

    public Peli(int kentanLeveys, int kentanKorkeus, int etenemisViiveMs) {
        this.kentta = new Kentta(kentanLeveys, kentanKorkeus);
        this.etenemisViiveMs = etenemisViiveMs;

        this.kentanPiirto = new KentanPiirto();

        this.palaHallinta = new PalaLogiikka(kentta);

        peliKaynnissa = true;
    }

    public void aloita() {
        this.pala = palautaSatunnainenPala();
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
        this.kentanPiirto.piirra(kentta, pala);
    }

    public void liikutaPalaaAlas() {
        if (palaHallinta.voikoLiikuttaaAlas(pala)) {
            this.pala.liikuAlas();
            tulostaKentta();
        } else {
            seuraavaPala();
        }
    }

    public void liikutaPalaaOikealle() {
        if (palaHallinta.voikoLiikuttaaOikealle(pala)) {
            this.pala.liikuOikealle();
            tulostaKentta();
        }
    }

    public void liikutaPalaaVasemmalle() {
        if (palaHallinta.voikoLiikuttaaVasemmalle(pala)) {
            pala.liikuVasemmalle();
            tulostaKentta();
        }
    }

    public void seuraavaPala() {
        //Kiinnitetään nykyinen pala kentään:
        kentta.lisaaPala(pala);
        
        //Luodaan seuraava  pala:
        Pala seuraavaPala = palautaSatunnainenPala();

        //Jos uutta palaa ei voida luoda, peli päättyy
        if (!palaHallinta.voidaankoLuoda(seuraavaPala)) {
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
    
    public Pala palautaSatunnainenPala() {
        Pala satunnainenPala = Pala.values()[(int) (Math.random() * Pala.values().length)];
        satunnainenPala.luoAloitusPisteJaNeliot(kentta.palautaKentanLeveys() / 2, 0);
        return satunnainenPala;
    }
}
