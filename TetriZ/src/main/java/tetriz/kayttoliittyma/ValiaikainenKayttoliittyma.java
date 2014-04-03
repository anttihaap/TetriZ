
package tetriz.kayttoliittyma;


import java.awt.Color;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JFrame;
import javax.swing.JPanel;
import tetriz.logiikka.Peli;
import tetriz.piirto.KentanPiirto;

/**
 *
 * @author Antti
 */
public class ValiaikainenKayttoliittyma extends JFrame implements KeyListener {

    JPanel kenttaPiirto;
    Peli peli;
    
    /**
     *
     */
    public Color[][] peliTilanneKordinaatiosto;

    /**
     *
     */
    public ValiaikainenKayttoliittyma() {
        setTitle("TetriZ");
        setSize(300, 600);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        addKeyListener(this);
    }

    /**
     *
     */
    public void aloitaPeli() {
        peli = new Peli(10, 20, 200, this);
        peli.aloita();
    }

    /**
     *
     * @param pelitilanne
     */
    public void kaynnistaPiirto(Color[][] pelitilanne) 
    {
        this.peliTilanneKordinaatiosto = pelitilanne;
        kenttaPiirto = new KentanPiirto(this.peliTilanneKordinaatiosto);
        add(kenttaPiirto);
    }

    /**
     *
     * @param peliTilanne
     */
    public void piirraKentta(Color[][] peliTilanne) {
        this.peliTilanneKordinaatiosto = peliTilanne;
        
        kenttaPiirto.repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            peli.liikutaPalaaVasemmalle();
        }

        if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            peli.liikutaPalaaOikealle();
        }
        
        if (e.getKeyCode() == KeyEvent.VK_DOWN) {
            peli.liikutaPalaaAlas();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
