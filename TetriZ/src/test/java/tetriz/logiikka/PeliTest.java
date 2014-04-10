
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

    }
    
    /**
     *
     */
    @After
    public void tearDown() {
    }
    
    
    @Test
    public void lyhyempiKonstruktoriAsettaaArvotOikein() {
        this.peli = new Peli(2, kayttoliittyma);
                             
        assertEquals(this.peli.kentta.palautaKentanLeveys(), 10);
        assertEquals(this.peli.kentta.palautaKentanKorkeus(), 20);
        
        assertEquals(this.peli.etenemisViiveMs, 2);   
        assertEquals(this.peli.kayttoliittyma, kayttoliittyma);
    } 
   
    @Test
    public void pidempiKonstruktoriAsettaaArvotOikein() {
        this.peli = new Peli(30, 20, 4, kayttoliittyma);
        assertEquals(this.peli.kentta.palautaKentanLeveys(), 30);
        assertEquals(this.peli.kentta.palautaKentanKorkeus(), 20);
        
        assertEquals(this.peli.etenemisViiveMs, 4);   
        assertEquals(this.peli.kayttoliittyma, kayttoliittyma);
    }
    
    @Test
    public void luoSatunnaisenPalan() {

    }
}