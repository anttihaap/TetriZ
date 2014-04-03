/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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

/**
 *
 * @author Antti
 */
public class PalaLogiikkaTest {
    
    PalaLogiikka palaLogiikka;
    
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
        palaLogiikka = new PalaLogiikka(kentta);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test 
    public void voiLuodaJosEiEstetta() {
        //Pala vakioaloituskohtaan
        Pala nelioPala = new Pala(kentta.palautaKentanLeveys() / 2, 0, TetrisPalatyypit.NELIOPALA);      
        assertTrue(palaLogiikka.voidaankoLuoda(nelioPala));      
    }
    
    @Test
    public void voiLiikuttaaAlasJosEiEstetta() {
        //Pala vakioaloituskohtaan
        Pala nelioPala = new Pala(kentta.palautaKentanLeveys() / 2, 0, TetrisPalatyypit.NELIOPALA); 
        assertTrue(palaLogiikka.voikoLiikuttaaAlas(nelioPala));    
    }
    
    @Test
    public void voiLiikuttaaOikealleJosEIEstetta() {
        //Pala vakioaloituskohtaanWanhaPalaala3 Pala pPala3= Pala.NELIOPALA;
        Pala nelioPala = new Pala(kentta.palautaKentanLeveys() /2, 0, TetrisPalatyypit.NELIOPALA);       
        assertTrue(palaLogiikka.voikoLiikuttaaOikealle(nelioPala));
    }
    
    @Test
    public void voiLiikuttaaVasemmalleJosEiEstetta() {
        //Pala vakioaloituskWanhaPalan
        Pala nelioPala = new Pala(kentta.palautaKentanLeveys() / 2, 0, TetrisPalatyypit.NELIOPALA);     
        assertTrue(palaLogiikka.voikoLiikuttaaVasemmalle(nelioPala));
    }
    
    @Test
    public void palaaEiVoidaLuodaToisWanhaPalalle() {
        Pala nelioPala = new Pala(kentta.palautaKentanLeveys() / 2, 0, TetrisPalatyypit.NELIOPALA);
        
        //Lisätään pala kenttään. Palaa ei voi luoda kentälle uudestaan.
        kentta.lisaaPala(nelioPala);
        assertFalse(palaLogiikka.voidaankoLuoda(nelioPala));
    }
    
    @Test
    public void eiVoiLiikuttaaAlasYliRajojen() {
        //Luodaan pala oikeaan reunaPala3       Pala3 pala = Pala.NELIOPALA;
        Pala nelioPala = new Pala(kentta.palautaKentanLeveys() / 2, 18, TetrisPalatyypit.NELIOPALA);        
        assertFalse(palaLogiikka.voikoLiikuttaaAlas(nelioPala));
    }
    
    @Test 
    public void eiVoiLiikuttaaAlasJosEste() {
        //Luodaan este ja liitetään kenttaan este:
        Pala nelioPalaEste = new Pala(kentta.palautaKentanLeveys() / 2, 2, TetrisPalatyypit.NELIOPALA);
        kentta.lisaaPala(nelioPalaEste);

        //Luodaan pala esteen päälle ja yritetään liikuttaa alas:
        Pala nelioPala = new Pala(kentta.palautaKentanLeveys() / 2, 0, TetrisPalatyypit.NELIOPALA);
        assertFalse(palaLogiikka.voikoLiikuttaaAlas(nelioPala));
    }
    
    @Test
    public void eiVoiLiikuttaaOikealleKentanYli() {
        Pala nelioPala = new Pala(kentta.palautaKentanLeveys() / 2 + 4, 0, TetrisPalatyypit.NELIOPALA);      
        assertFalse(palaLogiikka.voikoLiikuttaaOikealle(nelioPala));
    }
    
    @Test
    public void eiVoiLiikuttaaOikealleJosEste() {
        Pala nelioPalaEste = new Pala(kentta.palautaKentanLeveys() / 2 + 2, 0, TetrisPalatyypit.NELIOPALA);      
        kentta.lisaaPala(nelioPalaEste);
        
        Pala nelioPala = new Pala(kentta.palautaKentanLeveys() / 2, 0, TetrisPalatyypit.NELIOPALA);
        assertFalse(palaLogiikka.voikoLiikuttaaOikealle(nelioPala));
    }
    
    @Test
    public void eiVoiLiikuttaaVasemmalleKentanYli() {
        Pala nelioPala = new Pala(1, 0, TetrisPalatyypit.NELIOPALA);
        
        assertFalse(palaLogiikka.voikoLiikuttaaVasemmalle(nelioPala));
    }
    
    @Test
    public void eiVoiLiikuttaaVasemmalleJosEste() {
        Pala nelioPalaEste = new Pala(kentta.palautaKentanLeveys() / 2 - 2, 0, TetrisPalatyypit.NELIOPALA);
        kentta.lisaaPala(nelioPalaEste);
        
        Pala pala = new Pala(kentta.palautaKentanLeveys() / 2 - 2, 0, TetrisPalatyypit.NELIOPALA);
       
        assertFalse(palaLogiikka.voikoLiikuttaaVasemmalle(pala));
    }
    
    
}
