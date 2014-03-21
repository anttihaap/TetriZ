/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetriz.logiikka;

import tetriz.peliElementit.Kentta;
import tetriz.peliElementit.Nelio;
import tetriz.peliElementit.Pala;

/**
 *
 * @author Antti
 */
public class PalaHallinta {
    
    Kentta kentta;
    
    public PalaHallinta(Kentta kentta) {
        this.kentta = kentta;
    }

    public boolean voikoPalaaLiikuttaaKartassaSuuntaan(Pala pala, int suuntaX, int suuntaY) {
        for (Nelio n : pala.palautaPalanNeliot()) {
            boolean nelioLeveydenSisalla = n.palautaX() + suuntaX < kentta.palautaKentanLeveys() && n.palautaX() + suuntaX >= 0;
            boolean nelioKorkeudenSisalla = n.palautaY() + suuntaY < kentta.palautaKentanKorkeus() && n.palautaY() + suuntaY >= 0;
            boolean onkoVariaKentanKohdassa = kentta.onkoVariaKartassaKohdassa(n.palautaX() + suuntaX, n.palautaY() + suuntaY);

            if (!nelioLeveydenSisalla || !nelioKorkeudenSisalla || onkoVariaKentanKohdassa) {
                return false;
            }
        }
        return true;
    }
    
    public Pala palautaSatunnainenPala() {
        Pala satunnainenPala = Pala.luoSatunnainenPala();
        satunnainenPala.luoPalaJaAnnaAloitusPiste(kentta.kentanLeveys / 2, 0);
        
        return satunnainenPala;
    }
    


}
