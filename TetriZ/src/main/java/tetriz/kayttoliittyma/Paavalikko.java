/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetriz.kayttoliittyma;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Antti
 */
public class Paavalikko extends JPanel {

    Paaikkuna paneeli;

    JLabel[] napit;
    int akviivinenNappi;
    final int nappienMaara = 2;

    public Paavalikko() {
        setLayout(new GridLayout(3, 1));
        setBackground(Color.black);
        luoJaLisaaNapit();
    }

    private void luoJaLisaaNapit() {
        napit = new JLabel[2];
        akviivinenNappi = 0;

        JLabel otsikko = luoPaavalikkoTeksti("TetriZ", JLabel.CENTER, JLabel.TOP, 60, Color.white);
        add(otsikko);
        napit[0] = luoPaavalikkoTeksti("Start Game", JLabel.CENTER, JLabel.CENTER, 30, Color.yellow);
        napit[1] = luoPaavalikkoTeksti("Exit", JLabel.CENTER, JLabel.BOTTOM, 30, Color.white);

        for (JLabel jLabel : napit) {
            add(jLabel);
        }
    }

    public void liikuAlas() {
        if (akviivinenNappi <= nappienMaara - 2) {
            System.out.println("true");
            napit[akviivinenNappi].setForeground(Color.white);
            akviivinenNappi++;
            napit[akviivinenNappi].setForeground(Color.yellow);
        }
    }

    public void liikuYlos() {
        System.out.println(akviivinenNappi);
        if (akviivinenNappi >= 1) {
            System.out.println(akviivinenNappi);
            napit[akviivinenNappi].setForeground(Color.white);
            akviivinenNappi--;
            napit[akviivinenNappi].setForeground(Color.yellow);
        }
    }

    private JLabel luoPaavalikkoTeksti(String teksti, int x, int y, int fontKoko, Color vari) {
        JLabel labelTeksti = new JLabel(teksti);
        labelTeksti.setHorizontalAlignment(x);
        labelTeksti.setVerticalAlignment(y);

        labelTeksti.setFont(new Font(getFont().getName(), Font.PLAIN, fontKoko));
        labelTeksti.setForeground(vari);

        return labelTeksti;
    }
}