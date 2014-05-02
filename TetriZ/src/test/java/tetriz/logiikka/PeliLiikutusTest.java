package tetriz.logiikka;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import tetriz.peliElementit.Nelio;
import tetriz.peliElementit.Pala;
import tetriz.peliElementit.TetrisPalatyypit;

public class PeliLiikutusTest {

    Peli peli;

    final int kentanLeveys = 10;
    final int kentanKorkeus = 20;

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
        peli = new Peli(1, kentanLeveys, kentanKorkeus);
    }

    @After
    public void tearDown() {
    }

    @Test
    public void palaLiikkuuAlas() {
        int[] palanYArvotEnnenLiikutusta = new int[4];

        for (int i = 0; i < 4; i++) {
            palanYArvotEnnenLiikutusta[i] = this.peli.liikutettavaPala.palautaPalanNeliot()[i].palautaY();
        }

        this.peli.liikutaPalaaAlas();

        for (int i = 0; i < 4; i++) {
            assertEquals(palanYArvotEnnenLiikutusta[i] + 1, this.peli.liikutettavaPala.palautaPalanNeliot()[i].palautaY());
        }
    }

    @Test
    public void palaLiikkuuOikealle() {
        int[] palanXArvotEnnenLiikutusta = new int[4];

        for (int i = 0; i < 4; i++) {
            palanXArvotEnnenLiikutusta[i] = peli.liikutettavaPala.palautaPalanNeliot()[i].palautaX();
        }

        peli.liikutaPalaaOikealle();

        for (int i = 0; i < 4; i++) {
            assertEquals(palanXArvotEnnenLiikutusta[i] + 1, this.peli.liikutettavaPala.palautaPalanNeliot()[i].palautaX());
        }
    }

    @Test
    public void palaLiikkuuVasemmalle() {
        int[] palanXArvotEnnenLiikutusta = new int[4];

        for (int i = 0; i < palanXArvotEnnenLiikutusta.length; i++) {
            palanXArvotEnnenLiikutusta[i] = peli.liikutettavaPala.palautaPalanNeliot()[i].palautaX();
        }

        peli.liikutaPalaaVasemmalle();

        for (int i = 0; i < 4; i++) {
            assertEquals(palanXArvotEnnenLiikutusta[i] - 1, peli.liikutettavaPala.palautaPalanNeliot()[i].palautaX());
        }
    }

    @Test
    public void palaLiikkuuKentanAlalaitaan() {
        peli.liikutettavaPala = new Pala(kentanLeveys / 2, 0, TetrisPalatyypit.KOLMIOPALA);
        int[] palanYArvotEnnenLiikutusta = new int[4];

        for (int i = 0; i < 4; i++) {
            palanYArvotEnnenLiikutusta[i] = this.peli.liikutettavaPala.palautaPalanNeliot()[i].palautaY();
        }

        this.peli.liikutaPalaKentanAlalaitaan();

        for (int i = 0; i < 4; i++) {
            assertEquals(palanYArvotEnnenLiikutusta[i] + 18, this.peli.liikutettavaPala.palautaPalanNeliot()[i].palautaY());
        }
    }

    @Test
    public void palaLiikkuuKaantyy() {
        peli.liikutettavaPala = new Pala(kentanLeveys / 2, 3, TetrisPalatyypit.OIKEAL);
        Pala kaannettavaPala = new Pala(kentanLeveys / 2, 3, TetrisPalatyypit.OIKEAL);

        peli.kaannaPalaaOikealle();
        kaannettavaPala.kaannaOikealle();

        Nelio[] pelipalanNeliot = peli.liikutettavaPala.palautaPalanNeliot();
        Nelio[] kannettavanPalanNeliot = kaannettavaPala.palautaPalanNeliot();

        for (int i = 0; i < 4; i++) {
            assertEquals(pelipalanNeliot[i].palautaX(), kannettavanPalanNeliot[i].palautaX());
            assertEquals(pelipalanNeliot[i].palautaY(), kannettavanPalanNeliot[i].palautaY());
        }
    }
}