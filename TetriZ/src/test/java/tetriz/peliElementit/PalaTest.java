/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetriz.peliElementit;

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
public class PalaTest {

    Pala pala;


    public PalaTest() {

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
    public void palaLiikkuuAlas() {
        this.pala = new Pala(0, 0, TetrisPalatyypit.NELIOPALA);
        int[] yArvotEnnenLiikutusta = new int[4];

        for (int i = 0; i < 4; i++) {
            yArvotEnnenLiikutusta[i] = this.pala.palautaPalanNeliot()[i].palautaY();
        }

        this.pala.liikuAlas();

        for (int i = 0; i < 4; i++) {
            assertEquals(yArvotEnnenLiikutusta[i] + 1, this.pala.palautaPalanNeliot()[i].palautaY());
        }
    }
    
    @Test
    public void palaLiikkuuOikealle() {
        this.pala = new Pala(0, 0, TetrisPalatyypit.NELIOPALA);
        int[] xArvotEnnenLiikutusta = new int[4];

        for (int i = 0; i < 4; i++) {
            xArvotEnnenLiikutusta[i] = this.pala.palautaPalanNeliot()[i].palautaX();
        }

        this.pala.liikuOikealle();

        for (int i = 0; i < 4; i++) {
            assertEquals(xArvotEnnenLiikutusta[i] + 1, this.pala.palautaPalanNeliot()[i].palautaX());
        }
    }
    
    @Test
    public void palaLiikkuuVasemmalle() {
        this.pala = new Pala(0, 0, TetrisPalatyypit.NELIOPALA);
        int[] xArvotEnnenLiikutusta = new int[4];

        for (int i = 0; i < 4; i++) {
            xArvotEnnenLiikutusta[i] = this.pala.palautaPalanNeliot()[i].palautaX();
        }

        this.pala.liikuVasemmalle();

        for (int i = 0; i < 4; i++) {
            assertEquals(xArvotEnnenLiikutusta[i] - 1, this.pala.palautaPalanNeliot()[i].palautaX());
        }
    }

}
