package tetriz.peliElementit;

import java.awt.Color;

public class Kentta {

    public int kentanKorkeus;
    public int kentanLeveys;
    public Color[][] kentta;

    public Kentta(int kentanLeveys, int kentanKorkeus) {
        this.kentanLeveys = kentanLeveys;
        this.kentanKorkeus = kentanKorkeus;
        this.kentta = new Color[kentanLeveys][kentanKorkeus];
    }

    public void lisaaVariKenttaan(Color vari, int x, int y) {
        this.kentta[x][y] = vari;
    }

    public void lisaaPalaKenttaan(Pala pala) {
        for (Nelio n : pala.palautaPalanNeliot()) {
            lisaaVariKenttaan(n.palautaVari(), n.palautaX(), n.palautaY());
        }
    }

    public boolean onkoVariaKartassaKohdassa(int x, int y) {
        return this.kentta[x][y] != null;
    }

    public Color palautaKentanKordinaatistonVari(int x, int y) {
        if (this.kentta[x][y] != null) {
            return this.kentta[x][y];
        } else {
            return Color.white;
        }
    }

    public int palautaKentanLeveys() {
        return kentanLeveys;
    }

    public int palautaKentanKorkeus() {
        return kentanKorkeus;
    }
}
