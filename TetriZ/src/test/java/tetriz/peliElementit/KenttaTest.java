/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tetriz.peliElementit;

import java.awt.Color;
import tetriz.peliElementit.Kentta;
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
    
    public KenttaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        kentta = new Kentta(leveys,korkeus);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void kenttaLuoOikeanlaisenKentan() {
        assertEquals(kentta.kentanKorkeus, this.korkeus);
        assertEquals(kentta.kentanLeveys, this.leveys);
    }
    
    @Test
    public void onkoVariaKartassaKohdassaPalauttaaOikeanTotuusarvon() {
        Color musta = Color.black;
        kentta.lisaaVariKenttaan(musta, 0, 0);
        assertEquals(true, kentta.onkoVariaKartassaKohdassa(0, 0));
        assertEquals(false, kentta.onkoVariaKartassaKohdassa(0, 1));
    }
    
    @Test 
    public void variLisataanKenttaan() {
        Color musta = Color.black;
        
        kentta.lisaaVariKenttaan(musta, 0, 0);
        assertEquals(musta, kentta.palautaKentanKordinaatistonVari(0, 0));
    }
    
    @Test
    public void palauttaaValkosenVarinJosTyhja() {
        assertEquals(Color.white, kentta.palautaKentanKordinaatistonVari(0, 0));
    }
    
    @Test
    public void paluattaaEpatosiJosEtsiiVariaYliRajojen() {
        assertEquals(false, kentta.onkoVariaKartassaKohdassa(100, 100));
    }
}
