
package tetriz.logiikka;

import tetriz.peliElementit.Kentta;
import tetriz.peliElementit.Nelio;
import tetriz.peliElementit.Pala;
import tetriz.piirto.KentanPiirto;

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
        this.pala.luoPalaJaAnnaAloitusPiste(this.kentanLeveys / 2, 0);
    }

    public void aloitaPeli() {
        tulostaPeli();
        while (peliKaynnissa) {
            peliEtene();
        }
        lopetaPeli();
    }

    public void peliEtene() {
        System.out.println("peliEtene()");
        odota(500);
        liikutaPalaaAlas();
        tulostaPeli();
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
        if (voikoPalaaLiikuttaaKartassaSuuntaan(this.pala, 1, 0)) {
            this.pala.liikuOikealle();
            tulostaPeli();
        }
    }

    public void liikutaPalaaVasemmalle() {
        if (voikoPalaaLiikuttaaKartassaSuuntaan(pala, -1, 0)) {
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
        uusiPala.luoPalaJaAnnaAloitusPiste(this.kentanLeveys / 2, 0);
        System.out.println(uusiPala.toString());
        if (voikoPalaaLiikuttaaKartassaSuuntaan(uusiPala, 0, 0)) {
            this.pala = uusiPala;
        } else {
            peliKaynnissa = false;
        }
    }

    //Luokka ei toimi
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
    
    public void asetaPelinPala(Pala pala) {
        this.pala = pala;
    }

}
