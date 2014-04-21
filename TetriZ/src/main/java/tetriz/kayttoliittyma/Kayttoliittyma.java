/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package tetriz.kayttoliittyma;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author Antti
 */
public class Kayttoliittyma {
    
    JFrame frame;

    JPanel peliPaneeli;
    
    public Kayttoliittyma() {       
        frame = new JFrame("Tetriz");
        
        frame.setSize(500, 630);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(3,1));
        //peliPaneeli = new PeliPaneeli();
        frame.getContentPane().add(new Pelipaneeli());
        frame.pack();
        frame.setVisible(true);
        //peliPaneeli.run();
    }

    
    
}
