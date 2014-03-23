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
public class PalaHallintaTest {
    
    PalaLogiikka hallinta;
    
    Kentta kentta;
    
    public PalaHallintaTest() {
               
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
        hallinta = new PalaLogiikka(kentta);
    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void luoPalaLuoPalan() {
        Pala pala = hallinta.palautaSatunnainenPala();
        assertNotNull(pala);
    }
    
}
