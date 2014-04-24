
package tetriz.logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tetriz.peliElementit.Kentta;
import tetriz.peliElementit.Pala;
import tetriz.peliElementit.TetrisPalatyypit;


public class PalaLogiikkaTest {
    
    Palalogiikka palaLogiikka;
    
    Kentta kentta;
    
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
        kentta = new Kentta(10,20);
        palaLogiikka = new Palalogiikka();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test 
    public void voiLuodaJosEiEstetta() {
        //Pala vakioaloituskohtaan
        Pala nelioPala = new Pala(kentta.palautaKentanLeveys() / 2, 0, TetrisPalatyypit.NELIOPALA);      
        assertTrue(palaLogiikka.voidaankoLuoda(nelioPala, kentta));      
    }
    
    @Test
    public void voiLiikuttaaAlasJosEiEstetta() {
        //Pala vakioaloituskohtaan
        Pala nelioPala = new Pala(kentta.palautaKentanLeveys() / 2, 0, TetrisPalatyypit.NELIOPALA); 
        assertTrue(palaLogiikka.voikoLiikuttaaAlas(nelioPala, kentta));    
    }
    
    @Test
    public void voiLiikuttaaOikealleJosEIEstetta() {
        //Pala vakioaloituskohtaanWanhaPalaala3 Pala pPala3= Pala.NELIOPALA;
        Pala nelioPala = new Pala(kentta.palautaKentanLeveys() /2, 0, TetrisPalatyypit.NELIOPALA);       
        assertTrue(palaLogiikka.voikoLiikuttaaOikealle(nelioPala, kentta));
    }
    
    @Test
    public void voiLiikuttaaVasemmalleJosEiEstetta() {
        //Pala vakioaloituskWanhaPalan
        Pala nelioPala = new Pala(kentta.palautaKentanLeveys() / 2, 0, TetrisPalatyypit.NELIOPALA);     
        assertTrue(palaLogiikka.voikoLiikuttaaVasemmalle(nelioPala, kentta));
    }
    
    @Test
    public void eiVoidaLuodaToisenPalanPaalle() {
        Pala nelioPala = new Pala(kentta.palautaKentanLeveys() / 2, 0, TetrisPalatyypit.NELIOPALA);
        
        //Lisätään pala kenttään. Palaa ei voi luoda kentälle uudestaan.
        kentta.lisaaPala(nelioPala);
        assertFalse(palaLogiikka.voidaankoLuoda(nelioPala, kentta));
    }

    
    @Test
    public void eiVoiLiikuttaaAlasYliRajojen() {
        //Luodaan pala aivan kentän alarajalle ja yritetään liikuttaa sitä alas.
        Pala nelioPala = new Pala(kentta.palautaKentanLeveys() / 2, 18, TetrisPalatyypit.NELIOPALA);  
        assertFalse(palaLogiikka.voikoLiikuttaaAlas(nelioPala, kentta));
    }
    
    
    @Test 
    public void eiVoiLiikuttaaAlasJosEste() {
        //Luodaan este ja liitetään kenttaan este:
        Pala nelioPalaEste = new Pala(kentta.palautaKentanLeveys() / 2, 2, TetrisPalatyypit.NELIOPALA);
        kentta.lisaaPala(nelioPalaEste);

        //Luodaan pala esteen päälle ja yritetään liikuttaa alas:
        Pala nelioPala = new Pala(kentta.palautaKentanLeveys() / 2, 0, TetrisPalatyypit.NELIOPALA);
        assertFalse(palaLogiikka.voikoLiikuttaaAlas(nelioPala, kentta));
    }
    
    @Test
    public void eiVoiLiikuttaaOikealleKentanYli() {
        Pala nelioPala = new Pala(kentta.palautaKentanLeveys() / 2 + 4, 0, TetrisPalatyypit.NELIOPALA);      
        assertFalse(palaLogiikka.voikoLiikuttaaOikealle(nelioPala, kentta));
    }
    
    @Test
    public void eiVoiLiikuttaaOikealleJosEste() {
        Pala nelioPalaEste = new Pala(kentta.palautaKentanLeveys() / 2 + 2, 0, TetrisPalatyypit.NELIOPALA);      
        kentta.lisaaPala(nelioPalaEste);
        
        Pala nelioPala = new Pala(kentta.palautaKentanLeveys() / 2, 0, TetrisPalatyypit.NELIOPALA);
        assertFalse(palaLogiikka.voikoLiikuttaaOikealle(nelioPala, kentta));
    }
    
    @Test
    public void eiVoiLiikuttaaVasemmalleKentanYli() {
        Pala nelioPala = new Pala(1, 0, TetrisPalatyypit.NELIOPALA);
        
        assertFalse(palaLogiikka.voikoLiikuttaaVasemmalle(nelioPala, kentta));
    }
    
    @Test
    public void eiVoiLiikuttaaVasemmalleJosEste() {
        Pala nelioPalaEste = new Pala(kentta.palautaKentanLeveys() / 2 - 2, 0, TetrisPalatyypit.NELIOPALA);
        kentta.lisaaPala(nelioPalaEste);
        
        Pala pala = new Pala(kentta.palautaKentanLeveys() / 2 - 2, 0, TetrisPalatyypit.NELIOPALA);
       
        assertFalse(palaLogiikka.voikoLiikuttaaVasemmalle(pala, kentta));
    }
    
    @Test
    public void kentanSisallaToimiiKunArvotOikein() {
        for (int x = 0; x < 10; x++) {
            for (int y = 0; y < 20; y++) {
                assertTrue(palaLogiikka.kordinaattiOnKentanSisalla(x, y, kentta));
            }
        }           
    }
    
    @Test
    public void kentanSisallaToimiiKunArvotVaarat() {
        assertFalse(palaLogiikka.kordinaattiOnKentanSisalla(-1, -1, kentta));
        assertFalse(palaLogiikka.kordinaattiOnKentanSisalla(10, 20, kentta));
    }
}
