package tetriz.logiikka;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import tetriz.peliElementit.Kentta;
import tetriz.peliElementit.Nelio;
import tetriz.peliElementit.Pala;

/**
 * Sialtaa pelin toiminnallisuuden.
 * 
 */
public class Peli {


    private Palalogiikka palaLogiikka;


    private Kenttalogiikka kenttalogiikka;

    /**
     * Tilastoi peliä.
     */
    public PelinTilasto tilasto;

    /**
     * Pelin kenttä.
     */
    public Kentta kentta;
    
    /**
     * Pala jota pelaaja liikuttaa.
     */
    public Pala liikutettavaPala;

    /**
     * Pala, joka ludaan seuraavaksi.
     */
    public Pala seuraavaPala;
    
    /**
     * Totuusarvo siitä onko peli käynnissä.
     */
    public boolean peliKaynnissa;

    /**
     * Luo uuden pelin käyttäen parametrin vaikeustasoa.
     * @param vaikeustaso pelin vaikeustaso
     */
    public Peli(int vaikeustaso) {
        this(vaikeustaso, 10, 20);
    }

    /**
     * Luo uuden pelin käyttäen asetettua vaikeusastetta, kentän leveyttä ja kentän korkeutta.
     * @param vaikeustaso vaikeustaso
     * @param kentanLeveys kentän leveys
     * @param kentanKorkeus kentän korkeus
     */
    public Peli(int vaikeustaso, int kentanLeveys, int kentanKorkeus) {
        this.kentta = new Kentta(kentanLeveys, kentanKorkeus);

        this.palaLogiikka = new Palalogiikka();
        this.kenttalogiikka = new Kenttalogiikka();

        this.liikutettavaPala = palautaUusiPala();
        this.seuraavaPala = palautaUusiPala();
        this.tilasto = new PelinTilasto(vaikeustaso);
        peliKaynnissa = true;
    }



    /**
     * Metodi yrittää liikuttaa palaa alas. Jos palaa ei voida liikuttaa,
     * kutsutaan metodia seuraavaPala().
     */
    public void liikutaPalaaAlas() {
        if (palaLogiikka.voikoLiikuttaaAlas(liikutettavaPala, kentta)) {
            liikutettavaPala.liikuAlas();
        } else {
            seuraavaPala();
        }
    }

    /**
     * Metodi liikuttaa palaa yhden oikealle, jos palaLogiikka antaa luvan.
     */
    public void liikutaPalaaOikealle() {
        if (palaLogiikka.voikoLiikuttaaOikealle(liikutettavaPala, kentta)) {
            liikutettavaPala.liikuOikealle();
        }
    }

    /**
     * Metodi liikuttaa palaa yhden vasemmalle, jos palaLogiikka antaa luvan.
     */
    public void liikutaPalaaVasemmalle() {
        if (palaLogiikka.voikoLiikuttaaVasemmalle(liikutettavaPala, kentta)) {
            liikutettavaPala.liikuVasemmalle();
        }
    }

    /**
     * Metodi kääntää palaa oikealle, jos palaLogiikka antaa luvan.
     */
    public void kaannaPalaaOikealle() {
        if (palaLogiikka.voikoKaantaa(liikutettavaPala, kentta)) {
            liikutettavaPala.kaannaOikealle();
        } 
    }

    /**
     * Metodi liikuttaa palan niin alas kuin mahdollista.
     */
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
        
        //Tarkistetaan rivien tilanne:
        tarkistaRivit();

        //Jos uutta palaa ei voida luoda, peli päättyy
        if (!palaLogiikka.voidaankoLuoda(seuraavaPala, kentta)) {
            peliKaynnissa = false;
        } else {            
            this.liikutettavaPala = seuraavaPala;
            this.seuraavaPala = palautaUusiPala();
            tilasto.lisaaPalojaLuotuYhdella();
        }
    }

    /**
     * Luo uuden palan käyttäen 
     * @return pala
     */
    private Pala palautaUusiPala() {
        Pala uusiPala = new Pala(this.kentta.palautaKentanLeveys() / 2, 0);
        return uusiPala;
    }
    
    /**
     * Tarkistaa täydet rivit, lisää pisteytystä tilasto-luokan mukaisesti ja poistaa täydet rivit kentästä.
     */
    private void tarkistaRivit() {
        ArrayList<Integer> taydetRivit = kenttalogiikka.palautaTaydetRivit(palautaPeliTilanne());
        
        //Tuhottujen rivien määrä on listan koko.
        int rivejaTuhottu = taydetRivit.size();
        
        //Pisteytys:
        tilasto.kasvataRivejaTuhottu(rivejaTuhottu);
        tilasto.kasvataPistetta(rivejaTuhottu);
        
        //Poistetaan täydet rivit:
        kenttalogiikka.poistaRivit(this.kentta.palautaKordinaatisto(), taydetRivit);
    }

    /**
     * Metodi palauttaa kordinaatiston, joka kuvaa nykyistä pelitilannetta.
     * Kordinaatisto sisältää kentan kordinaatiston ja siihen lisätyn liikutettavan palan.
     * @return pelitilanne
     */
    public BufferedImage[][] palautaPeliTilanne() {
        BufferedImage[][] kentanKordinaatiosto = kentta.palautaKordinaatisto().clone();
        BufferedImage[][] peliTilanneNyt = new BufferedImage[this.kentta.palautaKentanLeveys()][this.kentta.palautaKentanKorkeus()];
              
        //Kentankordinaatiston kopiointi System.arraycopya käyttäen:
        for (int i = 0; i < kentanKordinaatiosto.length; i++) {
            System.arraycopy(kentanKordinaatiosto[i], 0, peliTilanneNyt[i], 0, kentanKordinaatiosto[i].length);
        }
        
        //Liikutettavan palan neliöiden lisäys kordinaatistoon:
        for (Nelio n : liikutettavaPala.palautaPalanNeliot()) {
            peliTilanneNyt[n.palautaX()][n.palautaY()] = n.palautaKuva();
 
        }

        return peliTilanneNyt;
    }
    
    /**
     * Metodi palauttaa sen luoman liikutettavanPalan varjopalan.
     * @return varjopala
     */
    public Pala palautaVarjopala() {
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
    
    /**
     * Palauttaa seuraavan palan tetrispalatyypin neliot.
     * @return seuraavan palan tetrispalatyypin neliot
     */
    public Nelio[] palautaSeuraavanPalanTetrispalatyypinNeliot() {
        return seuraavaPala.palautaTetrisPalatyypinNeliot();
    }    
}