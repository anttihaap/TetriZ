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
    
    public PelinNappaimistonKuuntelija(ValiaikainenKayttoliittyma kayttoliittyma) {
        this.kayttoliittyma = kayttoliittyma;
    }
    
    
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            kayttoliittyma.peli.liikutaPalaaVasemmalle();
        }

        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            kayttoliittyma.peli.liikutaPalaaOikealle();
        }
        
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            kayttoliittyma.peli.liikutaPalaaAlas();
        }
        
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            kayttoliittyma.peli.kaannaPalaaOikealle();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    @Override
    public void keyReleased(KeyEvent e) {
        
    }
    
}
