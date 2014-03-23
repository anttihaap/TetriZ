
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
        peli = new Peli(kentanLeveys, kentanKorkeus, etenemisViiveMs);
    }
    
    @After
    public void tearDown() {
    }
    
    @Test
    public void konstruktoriAsettaaArvotJaLuokkaPalauttaaOikeatArvot() {
        Kentta kentta = peli.kentta;
        assertEquals(kentta.palautaKentanKorkeus(), this.kentanKorkeus);
        assertEquals(kentta.palautaKentanLeveys(), this.kentanLeveys);
        
        assertEquals(peli.etenemisViiveMs,this.etenemisViiveMs);       
    }  
    
    

    

}
