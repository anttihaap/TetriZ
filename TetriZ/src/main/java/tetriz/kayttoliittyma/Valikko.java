/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetriz.kayttoliittyma;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * Valikko-luokka on runko nuolinäppäimillä selattaviin valikkoihin.
 */
public class Valikko extends JPanel implements KeyListener {

    JLabel[] napit;
    int akviivinenNappi;
    int nappienMaara;
    
    Paaikkuna valikko;

    //Nappien ominaisuudet:
    final private Color valitunNapinVari = Color.yellow;;
    final private Color napinVari = Color.white;;

    /**
     *
     * @param paavalikko
     */
    public Valikko(Paaikkuna ikkuna) {

        akviivinenNappi = 0;
        
        setBackground(Color.black);
    }

    public JLabel luoValikkoTeksti(String teksti) {
        return luoValikkoteksti(teksti, WIDTH, WIDTH, WIDTH, napinVari);
    }

    public JLabel luoValikkoteksti(String teksti, int x, int y, int fontKoko, Color vari) {
        JLabel labelTeksti = new JLabel(teksti);
        labelTeksti.setHorizontalAlignment(x);
        labelTeksti.setVerticalAlignment(y);

        labelTeksti.setFont(new Font(Font.SERIF, Font.PLAIN, fontKoko));
        labelTeksti.setForeground(vari);

        return labelTeksti;
    }

    public void lisaaNapit(JLabel[] napit) {
        for (JLabel jLabel : napit) {
            add(jLabel);
        }
    }

    public void liikuAlasValikossa() {
        if (akviivinenNappi <= nappienMaara - 2) {
            napit[akviivinenNappi].setForeground(napinVari);
            akviivinenNappi++;
            napit[akviivinenNappi].setForeground(valitunNapinVari);
        }
    }

    public void liikuYlosValikossa() {
        if (akviivinenNappi >= 1) {
            napit[akviivinenNappi].setForeground(napinVari);
            akviivinenNappi--;
            napit[akviivinenNappi].setForeground(valitunNapinVari);
        }
    }

    public void teeKomento(int komento) {
        
    }

    
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            teeKomento(akviivinenNappi);
        }

        if (e.getKeyCode() == KeyEvent.VK_UP) {
            liikuYlosValikossa();
        }

        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            liikuAlasValikossa();
        }
    }

    @Override public void keyTyped(KeyEvent e) { }

    @Override public void keyReleased(KeyEvent e) { }

}
