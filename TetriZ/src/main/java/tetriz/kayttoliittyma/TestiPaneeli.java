/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tetriz.kayttoliittyma;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import javax.swing.JPanel;

/**
 *
 * @author Antti
 */
public class TestiPaneeli extends JPanel {
    
    public TestiPaneeli() {

        //setSize(200, 100);
        setBounds(500 / 2 - (200 / 2), 630 / 2 - (100 / 2), 200, 100);
        
        setLayout(new GridLayout(3, 1));
        setVisible(true);
        setFocusable(true);
        setOpaque(true);
        
        setBackground(Color.black);
    }
    
    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);        
        g.setColor(Color.pink);
        g.drawString("LOPPPU", 500 / 2 - (200 / 2), 630 / 2 - (100 / 2));
    }
}
