/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetriz.kayttoliittyma;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Antti
 */
public class KirjautumisValikko extends Valikko {

    JTextField tekstikentta;

    public KirjautumisValikko(Paaikkuna ikkuna) {
        super(ikkuna);
        setLayout(new GridLayout(5, 1));

        tekstikentta = new JTextField("Testi", 15);
        tekstikentta.setCaretColor(Color.red);
        //Tekstinväri:
        tekstikentta.setForeground(Color.yellow);
        //Läpinäkyvä:
        tekstikentta.setOpaque(false);
        tekstikentta.setSize(new Dimension(100,1000));
        
        tekstikentta.setSize(100, 50);

        tekstikentta.setFocusable(false);
        JLabel otsikko = luoValikkoteksti("TetriZ", JLabel.CENTER, JLabel.TOP, 60, Color.white);
        otsikko.setAlignmentX(0);
        add(otsikko);

        add(tekstikentta);
        luoNapit();
        

        setVisible(true);
    }

    private void luoNapit() {
        napit = new JLabel[3];
        akviivinenNappi = 0;
        nappienMaara = napit.length;
        
        napit[0] = luoValikkoteksti("", JLabel.CENTER, JLabel.CENTER, 30, Color.yellow);

        napit[1] = luoValikkoteksti("Kohta1", JLabel.CENTER, JLabel.CENTER, 30, Color.white);
        napit[2] = luoValikkoteksti("Kohta2", JLabel.CENTER, JLabel.CENTER, 30, Color.white);

        lisaaNapit(napit);
    }

}
