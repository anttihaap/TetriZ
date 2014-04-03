
package tetriz.peliElementit;

import java.awt.Color;

public enum TetrisPalatyypit {

    NELIOPALA(Color.pink),
    SUORAPALA(Color.red),
    KOLMIOPALA(Color.blue),
    OIKEAVINO(Color.green),
    VASENVINO(Color.black),
    OIKEAL(Color.orange),
    VASENL(Color.yellow);

    Color vari;

    TetrisPalatyypit(Color vari) {
        this.vari = vari;
    }
}
