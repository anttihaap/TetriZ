
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
public class PeliTest {
    
    Peli peli;
    int kentanLeveys = 10;
    int kentanKorkeus = 20;
    int etenemisViiveMs = 250;

    public PeliTest() {
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
    public void lyhyempiKonstruktoriAsettaaArvotOikein() {
        peli = new Peli();
        assertEquals(peli.kentta.palautaKentanLeveys(), 10);
        assertEquals(peli.kentta.palautaKentanKorkeus(), 20);        
    }
       
    @Test
    public void pidempiKonstruktoriAsettaaArvotOikein() {
        this.peli = new Peli(41, 23);
        assertEquals(this.peli.kentta.palautaKentanLeveys(), 41);
        assertEquals(this.peli.kentta.palautaKentanKorkeus(), 23);
    }
}