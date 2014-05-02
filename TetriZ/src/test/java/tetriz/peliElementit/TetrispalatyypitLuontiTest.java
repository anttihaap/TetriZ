/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tetriz.peliElementit;

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
public class TetrispalatyypitLuontiTest {
    
    Tetrispalatyypit palatyyppi;
    
    public TetrispalatyypitLuontiTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void NeliopalaLuodaanOikein() {
        palatyyppi = Tetrispalatyypit.NELIOPALA;
        
        Nelio[] palatyypinNeliot = palatyyppi.neliot;
        
        assertEquals(palatyypinNeliot[0].palautaX(), 1);
        assertEquals(palatyypinNeliot[0].palautaY(), 0);
        
        assertEquals(palatyypinNeliot[1].palautaX(), 1);
        assertEquals(palatyypinNeliot[1].palautaY(), 1);
        
        assertEquals(palatyypinNeliot[2].palautaX(), 2);
        assertEquals(palatyypinNeliot[2].palautaY(), 0);
        
        assertEquals(palatyypinNeliot[3].palautaX(), 2);
        assertEquals(palatyypinNeliot[3].palautaY(), 1);
    }
    
    @Test
    public void SuorapalaLuodaanOikein() {
        palatyyppi = Tetrispalatyypit.SUORAPALA;
        
        Nelio[] palatyypinNeliot = palatyyppi.neliot;
        
        for (int i = 0; i < 4; i++) {
            assertEquals(palatyypinNeliot[i].palautaX(), i);
            assertEquals(palatyypinNeliot[i].palautaY(), 0);
            
            assertNotNull(palatyypinNeliot[i].palautaKuva());
        }
        
       
    }
}
