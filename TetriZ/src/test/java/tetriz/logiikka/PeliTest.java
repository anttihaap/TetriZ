
package tetriz.logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tetriz.kayttoliittyma.ValiaikainenKayttoliittyma;
import tetriz.peliElementit.Kentta;

/**
 *
 * @author Antti
 */
public class PeliTest {
    
    ValiaikainenKayttoliittyma kayttoliittyma;
    
    Peli peli;
    int kentanLeveys = 10;
    int kentanKorkeus = 20;
    int etenemisViiveMs = 250;
    
    /**
     *
     */
    public PeliTest() {
    }
    
    /**
     *
     */
    @BeforeClass
    public static void setUpClass() {
    }
    
    /**
     *
     */
    @AfterClass
    public static void tearDownClass() {
    }
    
    /**
     *
     */
    @Before
    public void setUp() {
        kayttoliittyma = new ValiaikainenKayttoliittyma();
        kayttoliittyma.aloitaPeli();
        //peli = new Peli(kentanLeveys, kentanKorkeus, etenemisViiveMs);
    }
    
    /**
     *
     */
    @After
    public void tearDown() {
    }
    
    /*
    @Test
    public void konstruktoriAsettaaArvotOikein() {
        this.peli = new Peli(100, null);
                             
        assertEquals(this.peli.kentta.palautaKentanLeveys(), 10);
        assertEquals(this.peli.kentta.palautaKentanKorkeus(), 20);
        
        assertEquals(this.peli.etenemisViiveMs, 100);   
        assertEquals(this.peli.kayttoliittyma, null);
    } 
    */

    /**
     *
     */
    
    
    @Test
    public void luoSatunnaisenPalan() {

    }
}