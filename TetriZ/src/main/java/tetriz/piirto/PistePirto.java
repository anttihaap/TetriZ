/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tetriz.piirto;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Label;
import javax.swing.JPanel;

/**
 *
 * @author Antti
 */
public class PistePirto extends JPanel {
    
    int pisteet;
    
    public PistePirto(int pisteet) {
        this.pisteet = pisteet;
        setBackground(Color.GRAY);
        setBounds(300,0,200,630);       
        String s = "TetriZ";
        Label sl = new Label(s);
        sl.setBounds(5,5, 300, 10);
        add(sl);

    }
    
    @Override
    public void paint(Graphics g) {
        super.paintComponent(g);
        
    }
}
