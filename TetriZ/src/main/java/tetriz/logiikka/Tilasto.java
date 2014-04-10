
package tetriz.logiikka;

public class Tilasto {
    
    private int pisteet;
    
    /**
     * Konstruktori asettaa pisteen arvoksi 0.
     */
    public Tilasto() {
        this.pisteet = 0;
    }
    
    /**
     * Kasvattaa pisteita maaran: verran.
     * @param maara
     */
    public void kasvataPistetta(int maara) {
        this.pisteet += maara;
    }
    
    /**
     * Palauttaa pisteet.
     * @return
     */
    public int palautaPisteet() {
        return this.pisteet;
    }
    
}
