/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetriz.kayttoliittyma;

import java.awt.event.ActionEvent;
import javax.swing.AbstractAction;

public class PelipaneeliSyote extends AbstractAction {

    private final String syote;
    public Pelipaneeli paneeli;

    public PelipaneeliSyote(String nappi, Pelipaneeli pelipaneeli) {
        this.syote = nappi;
        this.paneeli = pelipaneeli;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (syote.equals("Ylos")) {
            paneeli.peli.kaannaPalaaOikealle();
            paneeli.repaint();
        }
        if (syote.equals("Alas")) {
            paneeli.peli.liikutaPalaaAlas();
            paneeli.repaint();
        }
        if (syote.equals("Oikealle")) {
            paneeli.peli.liikutaPalaaOikealle();
            paneeli.repaint();
        }
        if (syote.equals("Vasemmalle")) {
            paneeli.peli.liikutaPalaaVasemmalle();
            paneeli.repaint();
        }
    }

}
