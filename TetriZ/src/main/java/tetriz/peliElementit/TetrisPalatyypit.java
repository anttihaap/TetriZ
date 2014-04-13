
package tetriz.peliElementit;

import java.awt.Color;

/**
 * Määrittää palan ominaisuudet: väri ja nelioiden asetelma.
 * @author Antti
 */
public enum TetrisPalatyypit {

    NELIOPALA(Color.pink),
    SUORAPALA(Color.red),
    KOLMIOPALA(Color.blue),
    OIKEAVINO(Color.green),
    VASENVINO(Color.black),
    OIKEAL(Color.orange),
    VASENL(Color.yellow);

    Color vari;
    Nelio[] neliot;
    
    TetrisPalatyypit(Color vari) {
        this.vari = vari;
        this.neliot = new Nelio[4];
        
        luoNeliot();
    }
    
     private void luoNeliot() {
        switch (this.toString()) {
            case "NELIOPALA":
                this.neliot[0] = new Nelio(1, 0, vari);
                this.neliot[1] = new Nelio(1, 1, vari);
                this.neliot[2] = new Nelio(2, 0, vari);
                this.neliot[3] = new Nelio(2, 1, vari);
                break;
            case "SUORAPALA":
                for (int i = 0; i < 4; i++) {
                    this.neliot[i] = new Nelio(i, 0, vari);
                }
                break;
            case "KOLMIOPALA":
                this.neliot[0] = new Nelio(1, 0, vari);
                this.neliot[1] = new Nelio(0, 1, vari);
                this.neliot[2] = new Nelio(1, 1, vari);
                this.neliot[3] = new Nelio(2, 1, vari);
                break;
            case "OIKEAVINO":
                this.neliot[0] = new Nelio(0, 1, vari);
                this.neliot[1] = new Nelio(1, 0, vari);
                this.neliot[2] = new Nelio(1, 1, vari);
                this.neliot[3] = new Nelio(2, 0, vari);
                break;
            case "VASENVINO":
                this.neliot[0] = new Nelio(0, 0, vari);
                this.neliot[1] = new Nelio(1, 0, vari);
                this.neliot[2] = new Nelio(1, 1, vari);
                this.neliot[3] = new Nelio(2, 1, vari);
                break;
            case "OIKEAL":
                this.neliot[0] = new Nelio(0, 0, vari);
                this.neliot[1] = new Nelio(0, 1, vari);
                this.neliot[2] = new Nelio(1, 1, vari);
                this.neliot[3] = new Nelio(2, 1, vari);
                break;
            case "VASENL":
                this.neliot[0] = new Nelio(2, 0, vari);
                this.neliot[1] = new Nelio(0, 1, vari);
                this.neliot[2] = new Nelio(1, 1, vari);
                this.neliot[3] = new Nelio(2, 1, vari);
                break;
        }
    }

}