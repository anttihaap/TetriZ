
package tetriz.logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tetriz.peliElementit.Kentta;
import tetriz.peliElementit.Pala;
import tetriz.peliElementit.Tetrispalatyypit;

public class PalaLogiikkaTest {
    
    Palalogiikka palaLogiikka;
    
    Kentta kentta;
    final int kentanLeveys = 10;
    final int kentanKorkeus = 20;
    
    public PalaLogiikkaTest() {
        
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        kentta = new Kentta(kentanLeveys, kentanKorkeus);
        palaLogiikka = new Palalogiikka();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test    
    public void voiLuodaJosEiEstetta() {
        //Pala vakioaloituskohtaan
        Pala nelioPala = new Pala(kentanLeveys / 2, 0, Tetrispalatyypit.NELIOPALA);        
        assertTrue(palaLogiikka.voidaankoLuoda(nelioPala, kentta));        
    }
    
    @Test
    public void voiLiikuttaaAlasJosEiEstetta() {
        //Pala vakioaloituskohtaan
        Pala nelioPala = new Pala(kentta.palautaKentanLeveys() / 2, 0, Tetrispalatyypit.NELIOPALA);        
        assertTrue(palaLogiikka.voikoLiikuttaaAlas(nelioPala, kentta));        
    }
    
    @Test
    public void voiLiikuttaaOikealleJosEIEstetta() {
        //Pala vakioaloituskohtaanWanhaPalaala3 Pala pPala3= Pala.NELIOPALA;
        Pala nelioPala = new Pala(kentta.palautaKentanLeveys() / 2, 0, Tetrispalatyypit.NELIOPALA);        
        assertTrue(palaLogiikka.voikoLiikuttaaOikealle(nelioPala, kentta));
    }
    
    @Test
    public void voiLiikuttaaVasemmalleJosEiEstetta() {
        //Pala vakioaloituskWanhaPalan
        Pala nelioPala = new Pala(kentta.palautaKentanLeveys() / 2, 0, Tetrispalatyypit.NELIOPALA);        
        assertTrue(palaLogiikka.voikoLiikuttaaVasemmalle(nelioPala, kentta));
    }
    
    @Test
    public void eiVoidaLuodaToisenPalanPaalle() {
        Pala nelioPala = new Pala(kentta.palautaKentanLeveys() / 2, 0, Tetrispalatyypit.NELIOPALA);

        //Lisätään pala kenttään. Palaa ei voi luoda kentälle uudestaan.
        kentta.lisaaPala(nelioPala);
        assertFalse(palaLogiikka.voidaankoLuoda(nelioPala, kentta));
    }

    /*
     @Test
     public void eiVoidaLuodaJosRajojenUlkopuolella() {
     Pala nelioPala = new Pala(-10, -123);
        
     }
     */
    @Test
    public void eiVoiLiikuttaaAlasYliRajojen() {
        //Luodaan pala aivan kentän alarajalle ja yritetään liikuttaa sitä alas.
        Pala nelioPala = new Pala(kentta.palautaKentanLeveys() / 2, 18, Tetrispalatyypit.NELIOPALA);        
        assertFalse(palaLogiikka.voikoLiikuttaaAlas(nelioPala, kentta));
    }
    
    @Test    
    public void eiVoiLiikuttaaAlasJosEste() {
        //Luodaan este ja liitetään kenttaan este:
        Pala nelioPalaEste = new Pala(kentta.palautaKentanLeveys() / 2, 2, Tetrispalatyypit.NELIOPALA);
        kentta.lisaaPala(nelioPalaEste);

        //Luodaan pala esteen päälle ja yritetään liikuttaa alas:
        Pala nelioPala = new Pala(kentta.palautaKentanLeveys() / 2, 0, Tetrispalatyypit.NELIOPALA);
        assertFalse(palaLogiikka.voikoLiikuttaaAlas(nelioPala, kentta));
    }
    
    @Test
    public void eiVoiLiikuttaaOikealleKentanYli() {
        Pala nelioPala = new Pala(kentta.palautaKentanLeveys() / 2 + 4, 0, Tetrispalatyypit.NELIOPALA);        
        assertFalse(palaLogiikka.voikoLiikuttaaOikealle(nelioPala, kentta));
    }
    
    @Test
    public void eiVoiLiikuttaaOikealleJosEste() {
        Pala nelioPalaEste = new Pala(kentta.palautaKentanLeveys() / 2 + 2, 0, Tetrispalatyypit.NELIOPALA);        
        kentta.lisaaPala(nelioPalaEste);
        
        Pala nelioPala = new Pala(kentta.palautaKentanLeveys() / 2, 0, Tetrispalatyypit.NELIOPALA);
        assertFalse(palaLogiikka.voikoLiikuttaaOikealle(nelioPala, kentta));
    }
    
    @Test
    public void eiVoiLiikuttaaVasemmalleKentanYli() {
        Pala nelioPala = new Pala(kentta.palautaKentanLeveys() / 2 - 4, 0, Tetrispalatyypit.NELIOPALA);
        
        assertFalse(palaLogiikka.voikoLiikuttaaVasemmalle(nelioPala, kentta));
    }
    
    @Test
    public void eiVoiLiikuttaaVasemmalleJosEste() {
        Pala nelioPalaEste = new Pala(kentta.palautaKentanLeveys() / 2, 0, Tetrispalatyypit.NELIOPALA);
        kentta.lisaaPala(nelioPalaEste);
        
        Pala pala = new Pala((kentta.palautaKentanLeveys() / 2) + 2, 0, Tetrispalatyypit.NELIOPALA);
        
        assertFalse(palaLogiikka.voikoLiikuttaaVasemmalle(pala, kentta));
    }
    
    @Test
    public void kentanSisallaTosiKunPalaKentanSisalla() {
        Pala pala = new Pala(kentta.palautaKentanLeveys() / 2, 0, Tetrispalatyypit.NELIOPALA);

        assertTrue(palaLogiikka.palaOnKordinaattisenSisalla(pala, kentta));
    
               
    }
    
    @Test
    public void kentanSisallaEpatosiKunPalaKentanUlkopuolella() {
        Pala pala = new Pala(-10,-10);
        assertFalse(palaLogiikka.palaOnKordinaattisenSisalla(pala, kentta));       
    }
    
    @Test
    public void nelioPalaaEiVoiKaantaa() {
        Pala nelioPala = new Pala(kentanLeveys / 2, 0, Tetrispalatyypit.NELIOPALA);
        assertFalse(palaLogiikka.voikoKaantaa(nelioPala, kentta));
    }
    
    @Test
    public void palaaVoiKaantaaKunEiEsteita() {
        Pala oikealPala = new Pala(kentanLeveys / 2, 1, Tetrispalatyypit.KOLMIOPALA);
        assertTrue(palaLogiikka.voikoKaantaa(oikealPala, kentta));
    }
    
}

