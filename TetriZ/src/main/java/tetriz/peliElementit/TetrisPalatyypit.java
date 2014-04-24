
package tetriz.peliElementit;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Määrittää palan ominaisuudet: väri ja nelioiden asetelma.
 * @author Antti
 */
public enum TetrisPalatyypit {

    NELIOPALA("NELIOPALA"),
    SUORAPALA("SUORAPALA"),
    KOLMIOPALA("KOLMIOPALA"),
    OIKEAVINO("OIKEAVINO"),
    VASENVINO("VASENVINO"),
    OIKEAL("OIKEAL"),
    VASENL("VASENL");

    String palatyyppi;
    public BufferedImage kuva;
    
    Nelio[] neliot;
    
    
    TetrisPalatyypit(String palatyyppi) {
        this.palatyyppi = palatyyppi;
        this.neliot = new Nelio[4];
        
        this.kuva = null;
        try {
            this.kuva = ImageIO.read(getClass().getResource("/kuvat/" + this.toString() + ".jpg"));
        } catch (IOException e ) {
            
        }
        
        luoNeliot();
    }
    
     private void luoNeliot() {
        switch (palatyyppi) {
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