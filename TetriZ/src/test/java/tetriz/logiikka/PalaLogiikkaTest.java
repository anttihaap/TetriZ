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
        Pala pala = Pala.NELIOPALA;
        pala.luoAloitusPisteJaNeliot(kentta.palautaKentanLeveys() / 2, 0);
        assertTrue(palaLogiikka.voidaankoLuoda(pala));      
    }
    
    @Test
    public void voiLiikuttaaAlasJosEiEstetta() {
        //Pala vakioaloituskohtaan
        Pala pala = Pala.NELIOPALA;
        pala.luoAloitusPisteJaNeliot(kentta.palautaKentanLeveys() / 2, 0);
        
        assertTrue(palaLogiikka.voikoLiikuttaaOikealle(pala));
    
    }
    
    @Test
    public void voiLiikuttaaOikealleJosEIEstetta() {
        //Pala vakioaloituskohtaan
        Pala pala = Pala.NELIOPALA;
        pala.luoAloitusPisteJaNeliot(kentta.palautaKentanLeveys() / 2, 0);
        
        assertTrue(palaLogiikka.voikoLiikuttaaOikealle(pala));
    }
    
    @Test
    public void voiLiikuttaaVasemmalleJosEiEstetta() {
        //Pala vakioaloituskohtaan
        Pala pala = Pala.NELIOPALA;
        pala.luoAloitusPisteJaNeliot(kentta.palautaKentanLeveys() / 2, 0);
        
        assertTrue(palaLogiikka.voikoLiikuttaaVasemmalle(pala));
    }
    
    @Test
    public void palaaEiVoidaLuodaToisenPaalle() {
        Pala pala = Pala.NELIOPALA;
        pala.luoAloitusPisteJaNeliot(kentta.palautaKentanLeveys() / 2, 0);
        
        //Lisätään pala kenttään. Palaa ei voi luoda kentälle uudestaan.
        kentta.lisaaPala(pala);
        assertFalse(palaLogiikka.voidaankoLuoda(pala));
    }
    
    @Test
    public void eiVoiLiikuttaaAlasYliRajojen() {
        //Luodaan pala oikeaan reunaan
        Pala pala = Pala.NELIOPALA;
        pala.luoAloitusPisteJaNeliot(kentta.palautaKentanLeveys() / 2, 18);
        
        assertFalse(palaLogiikka.voikoLiikuttaaAlas(pala));
    }
    
    @Test 
    public void eiVoiLiikuttaaAlasJosEste() {
        //Luodaan este ja liitetään kenttään:
        Pala este = Pala.NELIOPALA;
        este.luoAloitusPisteJaNeliot(kentta.palautaKentanLeveys() / 2, 2);
        kentta.lisaaPala(este);
        
        Pala pala = Pala.NELIOPALA;
        pala.luoAloitusPisteJaNeliot(kentta.palautaKentanLeveys() / 2, 0);

        assertFalse(palaLogiikka.voikoLiikuttaaAlas(pala));
    }
    
    @Test
    public void eiVoiLiikuttaaOikealleYliRajojen() {
        Pala pala = Pala.NELIOPALA;
        pala.luoAloitusPisteJaNeliot(kentta.palautaKentanLeveys() / 2 + 4, 0);
        
        assertFalse(palaLogiikka.voikoLiikuttaaOikealle(pala));
    }
    
    @Test
    public void eiVoiLiikuttaaLiikaaVasemmalle() {
        Pala pala = Pala.NELIOPALA;
        pala.luoAloitusPisteJaNeliot(1, 0);
        
        assertFalse(palaLogiikka.voikoLiikuttaaVasemmalle(pala));
    }
    
    
}
