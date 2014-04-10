/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tetriz.peliElementit;

import java.awt.Color;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Antti
 */
public class KenttaTest {
    private Kentta kentta;
    private final int korkeus = 20;
    private final int leveys = 10;
    
    /**
     *
     */
    public KenttaTest() {
    }
    
    /**
     *
     */
    @BeforeClass
    public static void setUpClass() {
    }
    
    /**
     *
     */
    @AfterClass
    public static void tearDownClass() {
    }
    
    /**
     *
     */
    @Before
    public void setUp() {
        kentta = new Kentta(leveys,korkeus);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void kenttaLuoOikeanlaisenKentan() {
        assertEquals(kentta.palautaKentanKorkeus(), this.korkeus);
        assertEquals(kentta.palautaKentanLeveys(), this.leveys);
    }
    
    @Test
    public void onkoVariaKartassaKohdassaPalauttaaTosiJosVari() {
        kentta.lisaaVari(Color.black, 0, 0);
        assertTrue(kentta.onkoVaria(0, 0));
    }
    
    @Test
    public void onkoVariaKartassaKohdassaPalauttaaEpatosiJosEiVaria() {
        assertFalse(kentta.onkoVaria(0,0));
    }
    
    @Test 
    public void variLisataanKenttaan() {
        Color musta = Color.black;       
        kentta.lisaaVari(musta, 0, 0);
        assertEquals(musta, kentta.palautaVari(0, 0));
    }

    @Test
    public void palauttaaValkosenVarinJosEiVaria() {
        assertEquals(Color.white, kentta.palautaVari(0, 0));
    }
    
    @Test
    public void palaLisataanKenttaan() {
        Pala nelioPala = new Pala(kentta.palautaKentanLeveys() / 2, 0);
        
        kentta.lisaaPala(nelioPala);
        
        //Palan nelion vari tulisi löytyä lisäkysen jälkeen kentästä
        for (Nelio nelio : nelioPala.palautaPalanNeliot()) {
            assertEquals(kentta.palautaVari(nelio.palautaX(), nelio.palautaY()), nelioPala.palautaVari());
        }       
    }
    
}
