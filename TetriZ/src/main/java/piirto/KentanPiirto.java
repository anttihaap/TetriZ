/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piirto;

import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import peliElementit.Kentta;
import peliElementit.Pala;


public class KentanPiirto extends JPanel {

    JFrame frame;
    JPanel squares[][];

    public KentanPiirto() {
        squares = new JPanel[20][10];
        frame = new JFrame("Uli");
        frame.setSize(300, 600);
        frame.setLayout(new GridLayout(20, 10));

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

    }

    public void piirra(Kentta kentta, Pala pala) {
        frame.getContentPane().removeAll();

        JPanel testi[][] = new JPanel[20][10];
        for (int y = 0; y < 20; y++) {
            for (int x = 0; x < 10; x++) {
                testi[y][x] = new JPanel();
                if (pala.palautaVariKordinaatista(x, y) != null) {
                    testi[y][x].setBackground(pala.palautaVariKordinaatista(x, y));
                } else {
                    testi[y][x].setBackground(kentta.palautaKentanKordinaatistonVari(x, y));
                }
                frame.add(testi[y][x]);
            }
        }
        
        frame.revalidate();
        frame.repaint();
       

    }


}
