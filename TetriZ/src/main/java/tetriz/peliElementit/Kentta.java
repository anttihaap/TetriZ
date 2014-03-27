package tetriz.peliElementit;

import java.awt.Color;

public class Kentta {

    private final int kentanKorkeus;
    private final int kentanLeveys;
    private Color[][] kordinaatisto;

    public Kentta(int kentanLeveys, int kentanKorkeus) {
        this.kentanLeveys = kentanLeveys;
        this.kentanKorkeus = kentanKorkeus;
        this.kordinaatisto = new Color[kentanLeveys][kentanKorkeus];
    }

    public void lisaaVari(Color vari, int x, int y) {
        this.kordinaatisto[x][y] = vari;
    }

    public void lisaaPala(Pala pala) {
        for (Nelio n : pala.palautaPalanNeliot()) {
            lisaaVari(n.palautaVari(), n.palautaX(), n.palautaY());
        }
    }

    public boolean onkoVaria(int x, int y) {
        return this.kordinaatisto[x][y] != null;
    }

    public int palautaKentanLeveys() {
        return kentanLeveys;
    }

    public int palautaKentanKorkeus() {
        return kentanKorkeus;
    }

    public Color palautaVari(int x, int y) {
        if (this.kordinaatisto[x][y] != null) {
            return this.kordinaatisto[x][y];
        } else {
            return Color.white;
        }
    }

}
