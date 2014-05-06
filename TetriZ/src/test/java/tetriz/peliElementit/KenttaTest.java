/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetriz.peliElementit;

import java.awt.image.BufferedImage;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tetriz.tyokalut.Kuvanlataaja;

public class KenttaTest {

    private Kentta kentta;
    private final int kentanKorkeus = 20;
    private final int kentanLeveys = 10;

    private BufferedImage testiKuva;

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
        kentta = new Kentta(kentanLeveys, kentanKorkeus);

        testiKuva = Kuvanlataaja.palautaKuva("/kuvat/NELIOPALA.jpg");
    }

    @After
    public void tearDown() {
    }

    @Test
    public void kenttaLuoOikeanlaisenKentan() {
        assertEquals(kentta.palautaKentanKorkeus(), this.kentanKorkeus);
        assertEquals(kentta.palautaKentanLeveys(), this.kentanLeveys);
    }

    @Test
    public void onkoVariaKartassaKohdassaPalauttaaTosiJosVari() {
        kentta.lisaaKuva(testiKuva, 0, 0);
        assertTrue(kentta.onkoKuvaa(0, 0));
    }

    @Test
    public void onkoVariaKartassaKohdassaPalauttaaEpatosiJosEiVaria() {
        assertFalse(kentta.onkoKuvaa(0, 0));
    }

    @Test
    public void palauttaaNulJosEiKuvaa() {
        assertNull(kentta.palautaKuva(0, 0));
    }
    
    @Test 
    public void palauttaaKordinaatioston() {  
        assertEquals(kentta.palautaKordinaatisto().length, 10);
        assertEquals(kentta.palautaKordinaatisto()[0].length, 20);
    }

    @Test
    public void palaLisataanKenttaan() {
        Pala nelioPala = new Pala(kentta.palautaKentanLeveys() / 2, 0);

        kentta.lisaaPala(nelioPala);

        //Palan nelion vari tulisi löytyä lisäkysen jälkeen kentästä
        for (Nelio n : nelioPala.palautaPalanNeliot()) {
            int x = n.palautaX();
            int y = n.palautaY();
            assertTrue(kentta.onkoKuvaa(x, y));
            assertNotNull(kentta.palautaKuva(x, y));
        }
    }
}
