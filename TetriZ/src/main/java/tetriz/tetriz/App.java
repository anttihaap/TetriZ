package tetriz.tetriz;

import java.awt.BorderLayout;
import javax.swing.JFrame;

import tetriz.kayttoliittyma.Pelipaneeli;

public class App {

    /**
     * @param args the command line arguments
     */
    public static Thread peli;

    public static void main(String[] args) {
        JFrame frame;
        frame = new JFrame("Tetriz");

        //frame.setSize(500, 630);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(3, 1));
        frame.setSize(500, 630);
        Pelipaneeli peliPaneeli = new Pelipaneeli();
        frame.getContentPane().add(peliPaneeli);
        frame.setVisible(true);
        peliPaneeli.setFocusable(true);

        peli = new Thread((Runnable) peliPaneeli);
        peliPaneeli.run();
    }

}
