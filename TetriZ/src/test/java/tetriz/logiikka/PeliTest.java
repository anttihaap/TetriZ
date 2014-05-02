
package tetriz.logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tetriz.peliElementit.Nelio;
import tetriz.peliElementit.Pala;
import tetriz.peliElementit.Tetrispalatyypit;

public class PeliTest {
    
    Peli peli;
    int kentanLeveys = 10;
    int kentanKorkeus = 20;

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

    }
    

    @After
    public void tearDown() {
    }
    
    @Test
    public void lyhyempiKonstruktoriAsettaaArvotOikein() {
        peli = new Peli(1);
        assertEquals(peli.kentta.palautaKentanLeveys(), 10);
        assertEquals(peli.kentta.palautaKentanKorkeus(), 20);        
    }
       
    @Test
    public void pidempiKonstruktoriAsettaaArvotOikein() {
        this.peli = new Peli(1, 41, 23);
        assertEquals(this.peli.kentta.palautaKentanLeveys(), 41);
        assertEquals(this.peli.kentta.palautaKentanKorkeus(), 23);
    }
    
    @Test
    public void palautaPelitilannePalauttaaKentanJossaPala() {
        peli = new Peli(1,kentanLeveys, kentanKorkeus);       
    }
    
    @Test
    public void varjoPalaOnKentanAlalaidalla() {
        peli = new Peli(1,10,20);
        peli.liikutettavaPala = new Pala(kentanLeveys/2, 0,Tetrispalatyypit.NELIOPALA);
        Nelio[] palanNeliot = peli.liikutettavaPala.palautaPalanNeliot();
        Nelio[] varjopalanNeliot = peli.palautaVarjopala().palautaPalanNeliot();
        
        for (int i = 0; i < 4; i++) {
            assertEquals(palanNeliot[i].palautaY() + 18, varjopalanNeliot[i].palautaY());
            assertEquals(palanNeliot[i].palautaX(), varjopalanNeliot[i].palautaX());
        } 
    }
    
    /*
    @Test 
    public void seuraavanPalanLuonti() {
        peli = new Peli(1,10,20);
        Pala entinenSeuraavaPala = peli.seuraavaPala;
        Pala entinenLiikutettavaPala = peli.liikutettavaPala;
        
        peli.liikutaPalaKentanAlalaitaan();
        assertEquals(peli.liikutettavaPala, entinenLiikutettavaPala);
    }
    */
    
    @Test
    public void tarkistaRivitTuhoaaRivitJaTilastoi() {
        peli = new Peli(1,10,20);
        for (int i = 1; i <= 7; i += 2) {
            Pala pala = new Pala(i, 18,Tetrispalatyypit.NELIOPALA);
            peli.kentta.lisaaPala(pala);
        }
        peli.liikutettavaPala = new Pala(9,18,Tetrispalatyypit.NELIOPALA);
        peli.liikutaPalaaAlas();
        assertEquals(peli.tilasto.palautaRivejaTuhottu(), 2);
    }
    
    @Test
    public void palauttaaSeuraavanPalanTetrispalatyypinNeliot() {
        peli = new Peli(1,10,20);
        Pala seuraavaPala = new Pala(0, 0, Tetrispalatyypit.NELIOPALA);
        peli.seuraavaPala = seuraavaPala;
        
        assertArrayEquals(peli.palautaSeuraavanPalanTetrispalatyypinNeliot(), Tetrispalatyypit.NELIOPALA.neliot);
    }
    
}