
package tetriz.logiikka;

public class PelinTilasto {
    
    private int pisteet;
    private int palojaLuotu;
    private int rivejaTuhottu;
    
    /**
     * Konstruktori asettaa pisteen arvoksi 0.
     * Pelin alussa pisteet ja rivejaTuhottu ovat 0, paloja on luotu 1.
     */
    public PelinTilasto() {       
        pisteet = 0;
        palojaLuotu = 1;
        rivejaTuhottu = 0;      
    }
    
    /**
     * Kasvattaa pisteita maaran: verran.
     * @param maara
     */
    public void kasvataPistetta(int maara) {
        pisteet += maara;
    }
    
    public void palaLuotu() {
        palojaLuotu++;
    }
    
    public void kasvataRivejaTuhottu(int maara) {
        rivejaTuhottu += maara;
    }
    
    /**
     * Palauttaa pisteet.
     * @return
     */
    public int palautaPisteet() {
        return pisteet;
    }
    
    public int palautaPalojaLuotu() {
        return palojaLuotu;
    }
    
    public int palautaRivejaTuhottu() {
        return rivejaTuhottu;
    }
       
    
}
