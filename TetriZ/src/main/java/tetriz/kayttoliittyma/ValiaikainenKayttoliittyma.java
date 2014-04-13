
package tetriz.kayttoliittyma;


import java.awt.Color;
import java.awt.Label;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;
import tetriz.logiikka.Peli;
import tetriz.piirto.KentanPiirto;
import tetriz.piirto.PistePirto;

/**
 *
 * @author Antti
 */
public class ValiaikainenKayttoliittyma extends JFrame {

    JComponent kenttaPiirto;  
    JPanel pisteidenPiirto;
    
    KeyListener nappaimistonKuuntelija;
    

    
    public Peli peli;
    
    /**
     *
     */
    public Color[][] peliTilanneKordinaatiosto;

    /**
     *
     */
    public ValiaikainenKayttoliittyma() {
        setTitle("TetriZ");
        setSize(500, 630);
        setLayout(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        
        this.nappaimistonKuuntelija = new PelinNappaimistonKuuntelija(this);
    }
    
    /**
     *
     */
    public void aloitaPeli() {      
        peli = new Peli(10, 20, 500, this);  
        addKeyListener(this.nappaimistonKuuntelija); 
               
        peli.aloita();
    }
    
    public void kaynnistaPiirto() {
        kenttaPiirto = new KentanPiirto(this.peli.peliTilanne);
        add(kenttaPiirto);
        
        pisteidenPiirto = new PistePirto(this.peli.palautaPisteet());
        add(pisteidenPiirto);
    }

    /**
     *
     * @param peliTilanne
     */
    public void piirraKentta() {
        remove(kenttaPiirto);
        kenttaPiirto = new KentanPiirto(this.peli.peliTilanne);
        add(kenttaPiirto);
        kenttaPiirto.repaint();

        pisteidenPiirto.repaint();

    }
    
    public void lopetaPeli() {
        remove(kenttaPiirto);
        remove(pisteidenPiirto);
        removeKeyListener(this.nappaimistonKuuntelija);
        aloitaPeli();
    }

}
