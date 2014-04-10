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

/**
 *
 * @author Antti
 */
public class TilastoTest {
    
    Tilasto tilasto;
    
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
        tilasto = new Tilasto();
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void tilastoLuodaanPisteetNolla() {
        assertEquals(tilasto.palautaPisteet(), 0);
    }
    
    @Test
    public void pisteenKasvatusToimii() {
        tilasto.kasvataPistetta(10);
        assertEquals(tilasto.palautaPisteet(), 10);
        tilasto.kasvataPistetta(124151);
        assertEquals(tilasto.palautaPisteet(), 10 + 124151);
    }
}
