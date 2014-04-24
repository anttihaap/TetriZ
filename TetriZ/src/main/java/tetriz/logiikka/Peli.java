package tetriz.logiikka;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import tetriz.peliElementit.Kentta;
import tetriz.peliElementit.Nelio;
import tetriz.peliElementit.Pala;

/**
 *
 * @author Antti
 */
public class Peli {

    public Palalogiikka palaLogiikka;
    public Kenttalogiikka kenttalogiikka;

    public PelinTilasto tilasto;

    public Kentta kentta;
    
    Pala liikutettavaPala;
    Pala seuraavaPala;
    
    public boolean peliKaynnissa;


    public Peli() {
        this(10, 20);
    }

    public Peli(int kentanLeveys, int kentanKorkeus) {
        this.kentta = new Kentta(kentanLeveys, kentanKorkeus);

        this.palaLogiikka = new Palalogiikka();
        this.kenttalogiikka = new Kenttalogiikka();

        this.liikutettavaPala = palautaUusiPala();
        this.seuraavaPala = palautaUusiPala();
        this.tilasto = new PelinTilasto();
        peliKaynnissa = false;
    }



    /**
     * Metodi yrittää liikuttaa palaa alas. Jos palaa ei voida liikuttaa,
     * kutsutaan metodia seuraavaPala().
     */
    public void liikutaPalaaAlas() {
        if (palaLogiikka.voikoLiikuttaaAlas(liikutettavaPala, kentta)) {
            this.liikutettavaPala.liikuAlas();
        } else {
            seuraavaPala();
        }
    }

    /**
     * Metodi liikuttaa palaa oikealle.
     */
    public void liikutaPalaaOikealle() {
        if (palaLogiikka.voikoLiikuttaaOikealle(liikutettavaPala, kentta)) {
            this.liikutettavaPala.liikuOikealle();
        }
    }

    /**
     * Metodi liikuttaa palaa vasemmalle.
     */
    public void liikutaPalaaVasemmalle() {
        if (palaLogiikka.voikoLiikuttaaVasemmalle(liikutettavaPala, kentta)) {
            liikutettavaPala.liikuVasemmalle();
        }
    }

    public void kaannaPalaaOikealle() {
        if (palaLogiikka.voikoKaantaa(liikutettavaPala, kentta)) {
            this.liikutettavaPala.kaannaOikealle();
        } 
    }

    public void liikutaPalaKentanAlalaitaan() {
        while(palaLogiikka.voikoLiikuttaaAlas(liikutettavaPala, kentta)) {
            liikutettavaPala.liikuAlas();
        }
        
}
    
    /**
     * Metodi kiinnittää nykyisen palan kenttään ja luo uuden mikäli
     * mahdollista. Jos uutta palaa ei voida luoda, peliKaynnissa-totuusarvo
     * muuttuu epätodeksi.
     */
    private void seuraavaPala() {
        //Kiinnitetään nykyinen pala kentään:
        kentta.lisaaPala(liikutettavaPala);
        havitaRivit();

        this.tilasto.kasvataPistetta(1);

        //Luodaan seuraava pala entisen tilalle:

        //Jos uutta palaa ei voida luoda, peli päättyy
        if (!palaLogiikka.voidaankoLuoda(seuraavaPala, kentta)) {
            peliKaynnissa = false;
        } else {            
            this.liikutettavaPala = seuraavaPala;
            this.seuraavaPala = palautaUusiPala();
            tilasto.palaLuotu();
        }
    }

    private Pala palautaUusiPala() {
        Pala uusiPala = new Pala(this.kentta.palautaKentanLeveys() / 2, 0);
        return uusiPala;
    }
    
    private void havitaRivit() {
        ArrayList<Integer> taydetRivit = kenttalogiikka.palautaTaydetRivit(paivitaPeliTilanne());
        
        //kayttoliittyma.valkytaRiveja(taydetRivit, 5);
        tilasto.kasvataRivejaTuhottu(taydetRivit.size());
        
        kenttalogiikka.poistaRivit(this.kentta.palautaKordinaatisto(), taydetRivit);
    }

    /**
     * Metodi päivittää pelitilannetta.
     */
    public BufferedImage[][] paivitaPeliTilanne() {
        BufferedImage[][] kentanKordinaatiosto = kentta.palautaKordinaatisto().clone();
        BufferedImage[][] peliTilanneNyt = new BufferedImage[this.kentta.palautaKentanLeveys()][this.kentta.palautaKentanKorkeus()];

        for (int i = 0; i < kentanKordinaatiosto.length; i++) {
            System.arraycopy(kentanKordinaatiosto[i], 0, peliTilanneNyt[i], 0, kentanKordinaatiosto[i].length);
        }

        for (Nelio n : this.liikutettavaPala.palautaPalanNeliot()) {
            if(palaLogiikka.kordinaattiOnKentanSisalla(n.palautaX(), n.palautaY(), kentta)) {
                
            
            peliTilanneNyt[n.palautaX()][n.palautaY()] = n.palautaKuva();
            } else {
                return new BufferedImage[kentta.palautaKentanLeveys()][kentta.palautaKentanKorkeus()];
            }
        }

        return peliTilanneNyt;
    }
    
    public Pala palautaVarjoPala() {
        Pala varjoPala = new Pala(this.kentta.palautaKentanLeveys() / 2, 0, liikutettavaPala.palautaTetrispalatyyppi());
        Nelio[] neliot = liikutettavaPala.palautaPalanNeliot();

        int i = 0;
        for (Nelio n: varjoPala.palautaPalanNeliot()) {
            n.asetaX(neliot[i].palautaX());
            n.asetaY(neliot[i].palautaY());        
            i++;
        }

        
        while(palaLogiikka.voikoLiikuttaaAlas(varjoPala, kentta)) {
            varjoPala.liikuAlas();
        }
        
        return varjoPala;
    }
    
}