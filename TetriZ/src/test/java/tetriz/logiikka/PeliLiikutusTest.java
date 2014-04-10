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
import tetriz.kayttoliittyma.ValiaikainenKayttoliittyma;
import tetriz.peliElementit.Nelio;
import tetriz.peliElementit.Pala;

/**
 *
 * @author Antti
 */
public class PeliLiikutusTest {
    
    ValiaikainenKayttoliittyma kayttoliittyma;
    Peli peli;
    
    public PeliLiikutusTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        this.kayttoliittyma = new ValiaikainenKayttoliittyma();
        this.kayttoliittyma.aloitaPeli();
        this.peli = new Peli(4, kayttoliittyma);
       

    }
    
    @After
    public void tearDown() {
    }

    @Test
    public void palaLiikkuuAlas() {
        int[] palanYArvotEnnenLiikutusta = new int[4];
        
        for (int i = 0; i < 4; i++) {
            palanYArvotEnnenLiikutusta[i] = this.peli.pala.palautaPalanNeliot()[i].palautaY();
        }
        
        this.peli.liikutaPalaaAlas();
        
        for (int i = 0; i < 4; i++) {
            assertEquals(palanYArvotEnnenLiikutusta[i] + 1, this.peli.pala.palautaPalanNeliot()[i].palautaY());
        }
    }
    
    @Test
    public void palaLiikkuuOikealle() {
        int[] palanXArvotEnnenLiikutusta = new int[4];
        
        for (int i = 0; i < 4; i++) {
            palanXArvotEnnenLiikutusta[i] = this.peli.pala.palautaPalanNeliot()[i].palautaX();
        }
        
        peli.liikutaPalaaOikealle();
        
        for (int i = 0; i < 4; i++) {
            assertEquals(palanXArvotEnnenLiikutusta[i] + 1, this.peli.pala.palautaPalanNeliot()[i].palautaX());
        }
    }
    
        @Test
    public void palaLiikkuuVasemmalle() {
        int[] palanXArvotEnnenLiikutusta = new int[4];
        
        for (int i = 0; i < palanXArvotEnnenLiikutusta.length; i++) {
            palanXArvotEnnenLiikutusta[i] = this.peli.pala.palautaPalanNeliot()[i].palautaX();
        }
        
        peli.liikutaPalaaVasemmalle();
        
        for (int i = 0; i < 4; i++) {
            assertEquals(palanXArvotEnnenLiikutusta[i] - 1, this.peli.pala.palautaPalanNeliot()[i].palautaX());
        }
    }

    
}
