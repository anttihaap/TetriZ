/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetriz.logiikka;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tetriz.peliElementit.Kentta;
import tetriz.tyokalut.Kuvanlataaja;

/**
 *
 * @author Antti
 */
public class KenttalotiikkaTaydetRivitTest {

    Kenttalogiikka kenttalogiikka;
    Kentta kentta;
    
    int kentanLeveys = 10;
    int kentanKorkeus = 20;
    
    final BufferedImage testiKuva = Kuvanlataaja.palautaKuva("/kuvat/NULL.jpg");

    public KenttalotiikkaTaydetRivitTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        kenttalogiikka = new Kenttalogiikka();
        kentta = new Kentta(kentanLeveys, kentanKorkeus);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void eiTaysiaRiviaKunKenttaTyhja() {
        ArrayList<Integer> lista = new ArrayList<>();
        assertEquals(kenttalogiikka.palautaTaydetRivit(kentta.palautaKordinaatisto()), lista);
    }
    
    
    @Test
    public void palauttaaTaydenRivinKunYksiTaysiRivi() {
        for (int y = kentanKorkeus; y < kentanKorkeus; y++) {
            kentta = new Kentta(kentanLeveys, kentanKorkeus);
            for (int x = 0; x < kentanLeveys; x++) {
                kentta.lisaaKuva(testiKuva, x, y);
                
            }
            
            ArrayList<Integer> taydetRivit = kenttalogiikka.palautaTaydetRivit(kentta.palautaKordinaatisto());
            
            for (Integer i : taydetRivit) {
                int taysiRivi = i;
                assertEquals(taysiRivi, y);
            }
            
        }
    }
}
