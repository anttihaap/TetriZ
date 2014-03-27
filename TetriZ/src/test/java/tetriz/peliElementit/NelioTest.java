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
public class NelioTest {
    
    Nelio nelio;
    
    public NelioTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        nelio = new Nelio(0, 0, Color.white);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void nelioLuodaanOikein() {
        assertEquals(Color.white, nelio.palautaVari());
        assertEquals(0, nelio.palautaX());
        assertEquals(0, nelio.palautaY());
    }
    
    @Test 
    public void nelioPalauttaaOikeatArvot() {
        assertEquals(Color.white, nelio.palautaVari());
        assertEquals(0, nelio.palautaX());
        assertEquals(0, nelio.palautaY());
    }
    
    @Test
    public void nelioLiikkuuOikeinJokaiseenSuuntaan() {
        for (int i = 0; i < 10; i++) {
            nelio.oikealle();
            nelio.alas();
        }
        assertEquals(nelio.palautaX(), 10);
        assertEquals(nelio.palautaY(), 10);
        for (int i = 0; i < 10; i++) {
            nelio.vasemmalle();
        }
        assertEquals(nelio.palautaX(), 0);
    }
    
}
