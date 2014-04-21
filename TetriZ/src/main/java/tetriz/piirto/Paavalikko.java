/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetriz.piirto;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Antti
 */
public class Paavalikko  {
    
    /*
    JLabel[] napit;
    int akviivinenNappi;
    final int nappienMaara = 2;
    
    Kayttoliittyma2 k;

    public Paavalikko(Kayttoliittyma2 k) {
        this.k = k;
        //Framen asetukset:
        setSize(500, 630);
        setLayout(new GridLayout(3,1));
        setVisible(true); 

       
        
        setBackground(Color.black);
        
        luoJaLisaaNapit();
        //add(paavaliko);
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
    
    private void liikuAlas() {
        if (akviivinenNappi <= nappienMaara - 2) {
            System.out.println("true");
            napit[akviivinenNappi].setForeground(Color.white);
            akviivinenNappi++;
            napit[akviivinenNappi].setForeground(Color.yellow);
        } 
    }
    
    private void liikuYlos() {
        System.out.println(akviivinenNappi);
        if(akviivinenNappi >= 1) {
            System.out.println(akviivinenNappi);
            napit[akviivinenNappi].setForeground(Color.white);
            akviivinenNappi--;
            napit[akviivinenNappi].setForeground(Color.yellow);
        }
    }
    
    public void teeKomento(int komento) {
        
    }
       
    private JLabel luoPaavalikkoTeksti(String teksti,int x, int y, int fontKoko, Color vari) {        
        JLabel labelTeksti = new JLabel(teksti);
        labelTeksti.setHorizontalAlignment(x);
        labelTeksti.setVerticalAlignment(y);
        
        labelTeksti.setFont(new Font(getFont().getName(), Font.PLAIN, fontKoko));
        labelTeksti.setForeground(vari);
        
        return labelTeksti;
    }  
    
    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            if (akviivinenNappi == 0) {
                k.aloitaPeli();
            }

        }
        
        if (e.getKeyCode() == KeyEvent.VK_UP) {
            System.out.println("UP");
            liikuYlos();
        }
        
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            System.out.println("DOWN");
            liikuAlas();
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


   */

  

}
