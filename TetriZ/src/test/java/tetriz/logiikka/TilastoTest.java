/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tetriz.logiikka;

import java.util.Random;
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
public class TilastoTest {
    
    PelinTilasto tilasto;
    
    public TilastoTest() {
        
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        tilasto = new PelinTilasto(1);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void konstruktoriToimii() {
        for (int i = 1; i < 5; i++) {
           tilasto = new PelinTilasto(i);
           assertEquals(tilasto.palautaVaikeustaso(), i);
        }
    }
    
    @Test
    public void tilastoLuodaanPisteetNolla() {
        assertEquals(tilasto.palautaPisteet(), 0);
    }
    
    @Test
    public void palojaLuotuKasvaa() {
        tilasto = new PelinTilasto(1);
        
        int palojaLuotu = 1;
        for (int i = 0; i < 10; i++) {
            palojaLuotu++;
            tilasto.palaLuotu();
            assertEquals(tilasto.palautaPalojaLuotu(), palojaLuotu);
        }
    }
    
    @Test
    public void rievjaTuhottuToimii() {
        Random r = new Random();
        
        tilasto = new PelinTilasto(1);
        int rivejaTuhottu = 0;
        for (int i = 0; i < 10; i++) {
            int rivejaTaynna = r.nextInt(19);
            rivejaTuhottu += rivejaTaynna;
            
            tilasto.kasvataRivejaTuhottu(rivejaTaynna);
            assertEquals(tilasto.palautaRivejaTuhottu(), rivejaTuhottu);
        }
    }
    
    @Test
    public void eiTaysiaRivejaPisteetKasvaaKolmella() {
        tilasto = new PelinTilasto(1);
        
        tilasto.kasvataPistetta(0);
        
        assertEquals(tilasto.palautaPisteet(), 3);
    }
}
