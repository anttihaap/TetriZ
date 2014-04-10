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
    
    /**
     *
     */
    public NelioTest() {
    }

    @Before
    public void setUp() {
        nelio = new Nelio(0, 0, Color.white);
    }
    
    @Test
    public void nelioLuodaanOikein() {
        assertEquals(Color.white, nelio.palautaVari());
        assertEquals(0, nelio.palautaX());
        assertEquals(0, nelio.palautaY());
    }
    
    @Test
    public void asetaXToimii() {
        nelio.asetaX(1242);
        assertEquals(1242, nelio.palautaX());
    }
    
    @Test
    public void asetaYToimii() {
        nelio.asetaY(12412);
        assertEquals(12412, nelio.palautaY());
    }
    

    
}
