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
import tetriz.peliElementit.Kentta;
import tetriz.peliElementit.Pala;

/**
 *
 * @author Antti
 */
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
    
    @Test
    public void palaLiikkuuAlas() {
     
    }
    
    @Test
    public void palaEiLiikuRajanYliOikealle() {
        Pala lolPala = Pala.NELIOPALA;
        lolPala.luoPalaJaAnnaAloitusPiste(0, 18);
        this.peli.asetaPelinPala(lolPala);
        
        assertEquals(peli.voikoPalaaLiikuttaaKartassaSuuntaan(lolPala, 0, 1), false);
    
    }
}
