/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tetriz.peliElementit;

import tetriz.peliElementit.Kentta;
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
public class KenttaTest {
    private Kentta kentta;
    private int korkeus = 20;
    private int leveys = 10;
    
    public KenttaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        kentta = new Kentta(10,20);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void kenttaLuoOikeanlaisenKentan() {
        assertEquals(kentta.kentanKorkeus, this.korkeus);
        assertEquals(kentta.kentanLeveys, this.leveys);
    }
}
