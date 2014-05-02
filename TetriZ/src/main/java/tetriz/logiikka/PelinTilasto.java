
package tetriz.logiikka;

/**
 * Luokka tilastoi peliä.
 * @author Antti
 */
public class PelinTilasto {
    
    private int vaikeustaso;
    
    private int pisteet;
    private int palojaLuotu;
    private int rivejaTuhottu;
    
    private final int[] rivinTuhoamisKerroin;
    
    /**
     * Konstruktori asettaa vaikeustason parametsin mukaan ja oletusarvot.
     * Pelin alussa pisteet ja rivejaTuhottu ovat 0, paloja on luotu 1.
     * @param vaikeustaso
     */
    public PelinTilasto(int vaikeustaso) {
        this.vaikeustaso = vaikeustaso;
        pisteet = 0;
        palojaLuotu = 1;
        rivejaTuhottu = 0;      
        
        rivinTuhoamisKerroin = new int[4];
        rivinTuhoamisKerroin[0] = 40;
        rivinTuhoamisKerroin[1] = 100;
        rivinTuhoamisKerroin[2] = 300;
        rivinTuhoamisKerroin[3] = 1200;
    }
    
    /**
     * Kasvattaa pisteita maaran: verran.
     * @param rivit
     */
    public void kasvataPistetta(int rivit) {
        int taydetRivit;
        
        //Rivikerroin toimii vain välillä rivien määrällä 1-5.
        // >5 suuremmat rivin määrät eivät nostata kerrointa.
        if (rivit == 0) {
            pisteet += 3;
            return;
        }
        else if (rivit >= 5) {
            taydetRivit = 5;
        } else {
            taydetRivit = rivit;
        }
        int riviKerroin = rivinTuhoamisKerroin[taydetRivit - 1];
        
        //Pisteitä lisää kaavan mukaan: rivikerroin * (vaikeustaso + 1)
        this.pisteet += riviKerroin * (vaikeustaso + 1);
    }
    
    /**
     *
     */
    public void palaLuotu() {
        palojaLuotu++;
    }
    
    /**
     * Kasvattaa rivejaTuhottu maaran verran.
     * @param maara
     */
    public void kasvataRivejaTuhottu(int maara) {
        rivejaTuhottu += maara;
    }
    
    /**
     * Palauttaa pisteet.
     * @return pisteet
     */
    public int palautaPisteet() {
        return pisteet;
    }
    
    /**
     * Palauttaa 
     * @return
     */
    public int palautaPalojaLuotu() {
        return palojaLuotu;
    }
    
    /**
     *
     * @return
     */
    public int palautaRivejaTuhottu() {
        return rivejaTuhottu;
    }
    
    /**
     *
     * @return
     */
    public int palautaVaikeustaso() {
        return vaikeustaso;
    }
}