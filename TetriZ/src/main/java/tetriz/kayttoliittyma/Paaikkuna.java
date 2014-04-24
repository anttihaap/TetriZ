/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetriz.kayttoliittyma;

import java.awt.BorderLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import sun.awt.windows.ThemeReader;

/**
 *
 * @author Antti
 */
public class Paaikkuna extends JFrame implements KeyListener {
    private Paavalikko valikko;
    
    private Pelipaneeli paneeli;

    public Paaikkuna() {       
        setTitle("Tetriz");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(3, 1));
        setSize(500, 630);
        setVisible(true);
        
        kaynnistaValikko();
    }
        
    private void kaynnistaValikko() {
        valikko = new Paavalikko();
        getContentPane().add(valikko);
        addKeyListener(this);
    }

    private void aloitaPeli(int viive) {
            System.out.println("täällä");
            getContentPane().remove(valikko);
            removeKeyListener(this);
            invalidate(); validate();
            getContentPane().removeAll();
            repaint();            
            paneeli = new Pelipaneeli();
            getContentPane().add(paneeli);
            setVisible(true);
    }
    
    public void teeKomento(int komento) {
        if (komento == 0) {
            aloitaPeli(100);            
        }
        if (komento == 1) {
            System.exit(0);
        }
    }
    
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            teeKomento(valikko.akviivinenNappi);
        }

        if (e.getKeyCode() == KeyEvent.VK_UP) {
            valikko.liikuYlos();
        }

        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            valikko.liikuAlas();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }


}
