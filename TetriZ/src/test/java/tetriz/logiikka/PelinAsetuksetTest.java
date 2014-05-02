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

/**
 *
 * @author Antti
 */
public class PelinAsetuksetTest {
    
    PelinAsetukset asetukset;
    
    public PelinAsetuksetTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        asetukset = new PelinAsetukset();
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void konstrukotriAsettaaOletukset() {
        assertTrue(asetukset.palautaSeuraavapalaPiirretaan());
        assertTrue(asetukset.palautaVarjoPalapiirretaan());
        assertEquals(asetukset.palautaVaikeustaso(), 1);
    }
    
    @Test
    public void vaikeustasonVaihtoToimii() {
        for (int i = 1; i <= 5; i++) {
            assertEquals(asetukset.palautaVaikeustaso(), i);
            asetukset.vaihdaVaikeustaso();
        }
        //Kun vaikeustaso on 5 ja vaihdaVaikeustaso()-medoia kutsutaan palautuu 1.
        assertEquals(asetukset.palautaVaikeustaso(), 1);
    }
    
    @Test
    public void kaannaVarjopalaPiiretaanToimii() {
        //Vaikioasetus:
        assertTrue(asetukset.palautaVarjoPalapiirretaan());
        
        asetukset.kaannaVarjopalaPiirretaan();
        assertFalse(asetukset.palautaVarjoPalapiirretaan());
        asetukset.kaannaVarjopalaPiirretaan();
        assertTrue(asetukset.palautaVarjoPalapiirretaan());
    }
    
    @Test
    public void kaannaSeuraavapalaToimii() {
        //Vakioasetus:
        assertTrue(asetukset.palautaSeuraavapalaPiirretaan());
        
        asetukset.kaannaSeuraavaPalapiirretaan();
        assertFalse(asetukset.palautaSeuraavapalaPiirretaan());
        asetukset.kaannaSeuraavaPalapiirretaan();
        assertTrue(asetukset.palautaSeuraavapalaPiirretaan());
    }
    
    @Test
    public void palautaPelinnopeusPalauttaaOikeatArvot() {
        assertEquals(500 - (1 - 1) * 100, asetukset.palautaPelinNopeus());
        
        for (int i = 2; i < 4; i++) {
            asetukset.vaihdaVaikeustaso();
            assertEquals(asetukset.palautaPelinNopeus(), 500 - (i- 1) * 100);
        }               
    }    
}
