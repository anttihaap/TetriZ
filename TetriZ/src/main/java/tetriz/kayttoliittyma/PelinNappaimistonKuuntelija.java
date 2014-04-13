/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetriz.kayttoliittyma;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 *
 * @author Antti
 */
public class PelinNappaimistonKuuntelija implements KeyListener {

    ValiaikainenKayttoliittyma kayttoliittyma;
    boolean voikoNappiaPainaa;

    public PelinNappaimistonKuuntelija(ValiaikainenKayttoliittyma kayttoliittyma) {
        this.kayttoliittyma = kayttoliittyma;
        this.voikoNappiaPainaa = true;
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (voikoNappiaPainaa) {
            if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                kayttoliittyma.peli.liikutaPalaaVasemmalle();
                voikoNappiaPainaa = false;
            }

            if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                kayttoliittyma.peli.liikutaPalaaOikealle();
                voikoNappiaPainaa = false;
            }

            if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                kayttoliittyma.peli.nopeutaPelia();
            }

            if (e.getKeyCode() == KeyEvent.VK_UP) {
                kayttoliittyma.peli.kaannaPalaaOikealle();
                voikoNappiaPainaa = false;
            }
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            kayttoliittyma.peli.nopeusNormaaliksi();
        }

        if (e.getKeyCode() == KeyEvent.VK_LEFT || e.getKeyCode() == KeyEvent.VK_RIGHT || e.getKeyCode() == KeyEvent.VK_UP) {
            voikoNappiaPainaa = true;
        }
    }

}
