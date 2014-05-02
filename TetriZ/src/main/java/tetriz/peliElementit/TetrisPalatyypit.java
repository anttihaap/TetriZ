
package tetriz.peliElementit;

import java.awt.image.BufferedImage;
import tetriz.tyokalut.Kuvanlataaja;

/**
 * Luokka määrittää palan ominaisuudet: kuvan ja nelioasetelman.
 */
public enum Tetrispalatyypit {

    /**
     *
     */
    NELIOPALA("NELIOPALA"),

    /**
     *
     */
    SUORAPALA("SUORAPALA"),

    /**
     *
     */
    KOLMIOPALA("KOLMIOPALA"),

    /**
     *
     */
    OIKEAVINO("OIKEAVINO"),

    /**
     *
     */
    VASENVINO("VASENVINO"),

    /**
     *
     */
    OIKEAL("OIKEAL"),

    /**
     *
     */
    VASENL("VASENL");

    String palatyyppi;

    /**
     *
     */
    public BufferedImage kuva;
    
    public Nelio[] neliot;
    
    
    Tetrispalatyypit(String palatyyppi) {
        this.palatyyppi = palatyyppi;
        neliot = new Nelio[4];
        kuva = Kuvanlataaja.palautaKuva("/kuvat/" + this.toString() + ".jpg");
        luoNeliot();
    }
    
     private void luoNeliot() {
        switch (palatyyppi.toString()) {
            case "NELIOPALA":
                this.neliot[0] = new Nelio(1, 0, kuva);
                this.neliot[1] = new Nelio(1, 1, kuva);
                this.neliot[2] = new Nelio(2, 0, kuva);
                this.neliot[3] = new Nelio(2, 1, kuva);
                break;
            case "SUORAPALA":
                for (int i = 0; i < 4; i++) {
                    this.neliot[i] = new Nelio(i, 0, kuva);
                }
                break;
            case "KOLMIOPALA":
                this.neliot[0] = new Nelio(1, 0,kuva);
                this.neliot[1] = new Nelio(0, 1, kuva);
                this.neliot[2] = new Nelio(1, 1, kuva);
                this.neliot[3] = new Nelio(2, 1, kuva);
                break;
            case "OIKEAVINO":
                this.neliot[0] = new Nelio(0, 1, kuva);
                this.neliot[1] = new Nelio(1, 0, kuva);
                this.neliot[2] = new Nelio(1, 1, kuva);
                this.neliot[3] = new Nelio(2, 0, kuva);
                break;
            case "VASENVINO":
                this.neliot[0] = new Nelio(0, 0, kuva);
                this.neliot[1] = new Nelio(1, 0, kuva);
                this.neliot[2] = new Nelio(1, 1, kuva);
                this.neliot[3] = new Nelio(2, 1, kuva);
                break;
            case "OIKEAL":
                this.neliot[0] = new Nelio(0, 0, kuva);
                this.neliot[1] = new Nelio(0, 1, kuva);
                this.neliot[2] = new Nelio(1, 1, kuva);
                this.neliot[3] = new Nelio(2, 1, kuva);
                break;
            case "VASENL":
                this.neliot[0] = new Nelio(2, 0, kuva);
                this.neliot[1] = new Nelio(0, 1, kuva);
                this.neliot[2] = new Nelio(1, 1, kuva);
                this.neliot[3] = new Nelio(2, 1, kuva);
                break;
        }
    }
}