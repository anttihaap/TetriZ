
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
     * @param vaikeustaso vaikeustaso
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
     * Kasvattaa pistettä riipuen tuhottujen rivien määrästä.
     * @param tuhotutRivit tuhotut rivit
     */
    public void kasvataPistetta(int tuhotutRivit) {
        int taydetRivit;
        
        //Rivikerroin toimii vain välillä rivien määrällä 1-5.
        // >5 suuremmat rivin määrät eivät nostata kerrointa.
        if (tuhotutRivit == 0) {
            pisteet += 3;
            return;
        }
        else if (tuhotutRivit >= 5) {
            taydetRivit = 5;
        } else {
            taydetRivit = tuhotutRivit;
        }
        int riviKerroin = rivinTuhoamisKerroin[taydetRivit - 1];
        
        //Pisteitä lisää kaavan mukaan: rivikerroin * (vaikeustaso + 1)
        this.pisteet += riviKerroin * (vaikeustaso + 1);
    }
    
    /**
     * Lisaa luotujen palojen maaraa yhdellä.
     */
    public void lisaaPalojaLuotuYhdella() {
        palojaLuotu++;
    }
    
    /**
     * Kasvattaa rivejaTuhottu maaran verran.
     * @param maara ruhottujen rivien maara
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
     * Palauttaa luotujen palojen maaran. 
     * @return luodut palat
     */
    public int palautaPalojaLuotu() {
        return palojaLuotu;
    }
    
    /**
     * Palauttaa tuhottujen rivien maaran.
     * @return tuhotut rivit
     */
    public int palautaRivejaTuhottu() {
        return rivejaTuhottu;
    }
    
    /**
     * Palauttaa vaikeustason.
     * @return vaikeustaso
     */
    public int palautaVaikeustaso() {
        return vaikeustaso;
    }
}