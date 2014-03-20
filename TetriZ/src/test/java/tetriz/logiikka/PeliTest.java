
package tetriz.logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tetriz.peliElementit.Kentta;
import tetriz.peliElementit.Pala;

public class PeliTest {
    
    Peli peli;
    int pelinLeveys = 10;
    int pelinKorkeus = 20;
    
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
        peli = new Peli(10, 20);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void peliLuoOikeanKokoisenKentan() {
        Kentta kentta = peli.kentta;
        assertEquals(kentta.kentanKorkeus, this.pelinKorkeus);
        assertEquals(kentta.kentanLeveys, this.pelinLeveys);
    }
    
    @Test
    public void peliLuoPalan() {
        Pala pala = peli.pala;
        assertNotNull(pala);
    }
    

}
