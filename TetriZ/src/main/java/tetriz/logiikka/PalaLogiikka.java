package tetriz.logiikka;

import tetriz.peliElementit.Kentta;
import tetriz.peliElementit.Nelio;
import tetriz.peliElementit.Pala;

public class PalaLogiikka {

    Kentta kentta;

    public PalaLogiikka(Kentta kentta) {
        this.kentta = kentta;
    }

    public boolean voikoLiikuttaaAlas(Pala pala) {
        for (Nelio n : pala.palautaPalanNeliot()) {
            if (n.palautaY() + 1 >= kentta.palautaKentanKorkeus()) {
                return false;
            }
            if (kentta.onkoVariaKartassaKohdassa(n.palautaX(), n.palautaY() + 1)) {
                return false;
            }
        }
        return true;
    }

    public boolean voikoLiikuttaaOikealle(Pala pala) {
        for (Nelio n : pala.palautaPalanNeliot()) {
            if (n.palautaX() + 1 >= kentta.palautaKentanLeveys()) {
                return false;
            }
            if (kentta.onkoVariaKartassaKohdassa(n.palautaX() + 1, n.palautaY())) {
                return false;
            }
        }
        return true;
    }

    public boolean voikoLiikuttaaVasemmalle(Pala pala) {
        for (Nelio n : pala.palautaPalanNeliot()) {
            if (n.palautaX() - 1 > 0) {
                return false;
            }
            if (kentta.onkoVariaKartassaKohdassa(n.palautaX() - 1, n.palautaY())) {
                return false;
            }
        }
        return true;
    }
    
    public boolean voikoLuoda(Pala pala) {
        for (Nelio n : pala.palautaPalanNeliot()) {
            if (kentta.onkoVariaKartassaKohdassa(n.palautaX(), n.palautaY())) {
                return false;
            }
        }
        return true;
    }
    
    public Pala palautaSatunnainenPala() {
        Pala satunnainenPala = Pala.values()[(int) (Math.random() * Pala.values().length)];
        satunnainenPala.luoAloitusPisteJaNeliot(kentta.kentanLeveys / 2, 0);
        return satunnainenPala;
    }

}
