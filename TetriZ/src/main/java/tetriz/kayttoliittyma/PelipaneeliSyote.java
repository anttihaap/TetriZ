/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetriz.kayttoliittyma;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

/**
 *
 * @author Antti
 */
public class PelipaneeliSyote extends AbstractAction {

    private final String syote;
    private final Pelipaneeli paneeli;

    /**
     * Luo kuuntelijan tietylle syötteelle.
     * @param syote
     * @param pelipaneeli
     */
    public PelipaneeliSyote(String syote, Pelipaneeli pelipaneeli) {
        this.syote = syote;
        this.paneeli = pelipaneeli;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (paneeli.peli.peliKaynnissa) {
            if (syote.equals("Ylos")) {
                paneeli.peli.kaannaPalaaOikealle();
            }
            if (syote.equals("Alas")) {
                paneeli.peli.liikutaPalaaAlas();
            }
            if (syote.equals("Oikealle")) {
                paneeli.peli.liikutaPalaaOikealle();
            }
            if (syote.equals("Vasemmalle")) {
                paneeli.peli.liikutaPalaaVasemmalle();
            }
            if (syote.equals("Pohjaan")) {
                paneeli.peli.liikutaPalaKentanAlalaitaan();
            }
        }
        paneeli.repaint();
    }

}
