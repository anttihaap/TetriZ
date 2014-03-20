/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logiikka;

import peliElementit.Kentta;
import peliElementit.Nelio;
import peliElementit.Pala;
import piirto.KentanPiirto;

/**
 *
 * @author Antti
 */
public class Peli extends Thread {

    Kentta kentta;
    int kentanLeveys;
    int kentanKorkeus;

    KentanPiirto kentanPiirto;

    Pala pala;

    boolean peliKaynnissa;

    public Peli(int kentanLeveys, int kentanKorkeus) {
        peliKaynnissa = true;

        this.kentanLeveys = kentanLeveys;
        this.kentanKorkeus = kentanKorkeus;
        this.kentta = new Kentta(this.kentanLeveys, this.kentanKorkeus);

        this.kentanPiirto = new KentanPiirto();

        this.pala = Pala.luoSatunnainenPala();
        this.pala.luoPalanAloitusPiste(0, 0);
    }

    public void aloitaPeli() {
        while (peliKaynnissa) {
            peliEtene();
        }
        lopetaPeli();
    }

    public void peliEtene() {
        System.out.println("peliEtene()");
        tulostaPeli();

        odota(500);

        liikutaPalaaAlas();
    }

    public void tulostaPeli() {
        this.kentanPiirto.piirra(kentta, pala);
    }

    public void liikutaPalaaAlas() {
        if (voikoPalaaLiikuttaaKartassaSuuntaan(this.pala, 0, 1)) {
            this.pala.liikutaPalaaAlas();
        } else {
            luoUusiPala();
        }
    }

    public void liikutaPalaaOikealle() {
        if (voikoPalaaLiikuttaaKartassaSuuntaan(this.pala, 0, 1)) {
            this.pala.liikuOikealle();
            tulostaPeli();
        }
    }

    public void liikutaPalaaVasemmalle() {
        if (voikoPalaaLiikuttaaKartassaSuuntaan(pala, 0, -1)) {
            pala.liikuVasemmalle();
            tulostaPeli();
        }
    }

    public boolean voikoPalaaLiikuttaaKartassaSuuntaan(Pala pala, int suuntaX, int suuntaY) {

        for (Nelio n : pala.palautaPalanNeliot()) {
            boolean nelioEiMeneVaakatasossaYliKentan = n.X + suuntaX < this.kentanLeveys && n.X + suuntaX >= 0;
            boolean yEiMeneYliRajojen = n.Y + suuntaY < this.kentanKorkeus && n.Y + suuntaY >= 0;
            boolean onkoVariaKentanKohdassa = kentta.onkoVariaKartassaKohdassa(n.X + suuntaX, n.Y + suuntaY);

            if (!nelioEiMeneVaakatasossaYliKentan || !yEiMeneYliRajojen || onkoVariaKentanKohdassa) {
                return false;
            }
        }
        return true;
    }

    public void luoUusiPala() {
        this.kentta.lisaaPalaKenttaan(this.pala);
        Pala uusiPala = Pala.luoSatunnainenPala();
        uusiPala.luoPalanAloitusPiste(0, 0);
        if (voikoPalaaLiikuttaaKartassaSuuntaan(uusiPala, 0, 0)) {
            this.pala = uusiPala;
        } else {
            peliKaynnissa = false;
        }
    }

    public void rotaatio() {
        this.pala.rotaatio();
    }

    public void lopetaPeli() {
        System.out.println("LOPPU");
    }

    public void odota(int ms) {
        try {
            Thread.currentThread().sleep(500);
        } catch (InterruptedException e) {

        }
    }

}
