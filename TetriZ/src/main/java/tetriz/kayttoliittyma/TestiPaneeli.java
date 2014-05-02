/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tetriz.kayttoliittyma;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;

/**
 *
 * @author Antti
 */
public class TestiPaneeli extends JPanel implements KeyListener {
    
    public TestiPaneeli() {

        //setSize(200, 100);
        setBounds(500 / 2 - (200 / 2), 630 / 2 - (100 / 2), 200, 100);
        
        setLayout(new GridLayout(3, 1));
        setVisible(true);
        setFocusable(true);        
        setBackground(Color.black);
        
        add(new Label("TESTI"), JPanel.CENTER_ALIGNMENT);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        System.out.println("piirretään");
        super.paintComponent(g);        
        g.setColor(Color.pink);
        g.drawString("LOPPPU", 500 / 2 - (200 / 2), 630 / 2 - (100 / 2));
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
