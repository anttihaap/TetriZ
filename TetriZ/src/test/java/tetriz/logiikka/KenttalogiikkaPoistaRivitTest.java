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
public class KenttalogiikkaPoistaRivitTest {
    
    Kenttalogiikka kenttalogiikka;
    Kentta kentta;
    
    final BufferedImage testiKuva = Kuvanlataaja.palautaKuva("/kuvat/NULL.jpg");

    public KenttalogiikkaPoistaRivitTest() {
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
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void poistaaRivitJotkaTaynna() {
        int kentanLeveys = 10;
        int kentanKorkeus = 20;
        
        kentta = new Kentta(kentanLeveys, kentanKorkeus);
        
        for (int y = kentanKorkeus - 1; y >= 0; y--) {
            for (int x = 0; x < kentanLeveys; x++) {
                //Täytetään jokainen rivi:
                kentta.lisaaKuva(testiKuva, x, y);
            }
            ArrayList<Integer> taydetRivit = kenttalogiikka.palautaTaydetRivit(kentta.palautaKordinaatisto());
            

            kenttalogiikka.poistaRivit(kentta.palautaKordinaatisto(), taydetRivit);
            
            //Tarkistetaan, että kyseinen rivi on poistettu:
            for (int x = 0; x < kentanLeveys; x++) {
                assertFalse(kentta.onkoKuvaa(x, y));
            }
                    //assertFalse(kentta.onkoKuvaa(x2, y2));
        
        }
        
        
    }

}
