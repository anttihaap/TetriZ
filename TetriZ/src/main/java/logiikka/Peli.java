/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logiikka;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import peliElementit.Kentta;
import peliElementit.Nelio;
import peliElementit.Pala;
import piirto.KentanPiirto;


/**
 *
 * @author Antti
 */
public class Peli extends Thread implements KeyListener {

    Kentta kentta;
    int kentanLeveys;
    int kentanKorkeus;

    KentanPiirto kentanPiirto;

    Pala pala;
    
    boolean peliKaynnissa;
    

    public Peli(int kentanLeveys, int kentanKorkeus) {
        peliKaynnissa = true;
        
        this.kentanLeveys = kentanLeveys;
        this.kentanKorkeus = kentanKorkeus;
        this.kentta = new Kentta(this.kentanLeveys, this.kentanKorkeus);

        this.kentanPiirto = new KentanPiirto();

        this.pala = Pala.luoSatunnainenPala();
        this.pala.luoPalanAloitusPiste(0, 0);
    }
    
    public void aloitaPeli() throws InterruptedException  {
        while(peliKaynnissa) {
            peliEtene();           
        }
        lopetaPeli();
    }

    public void peliEtene() throws InterruptedException  {
        System.out.println("peliEtene()");
        tulostaPeli();
       
        Thread.currentThread().sleep(500);
        liikutaPalaaAlas();
    }

    public void tulostaPeli() {
        this.kentanPiirto.piirra(kentta, pala);
    }

    public void liikutaPalaaAlas() {
        if (voikoPalaaLiikuttaaKartassaSuuntaan(this.pala, 0, 1)) {
            this.pala.liikutaPalaaAlas();
        } else {
            luoUusiPala();
        }
    }

    public void liikutaPalaaOikealle() {
        if (voikoPalaaLiikuttaaKartassaSuuntaan(this.pala, 0, 1)) {
            this.pala.liikuOikealle();
            tulostaPeli();
        }        
    }
    
    public void liikutaPalaaVasemmalle() {
        if (voikoPalaaLiikuttaaKartassaSuuntaan(pala, 0, -1)) {
            pala.liikuVasemmalle();
            tulostaPeli();
        }
    }
    
    public boolean voikoPalaaLiikuttaaKartassaSuuntaan(Pala pala, int suuntaX, int suuntaY) {
        
        for (Nelio n : pala.palautaPalanNeliot()) {
            boolean nelioEiMeneVaakatasossaYliKentan = n.X + suuntaX < this.kentanLeveys && n.X + suuntaX >= 0;
            boolean yEiMeneYliRajojen = n.Y + suuntaY < this.kentanKorkeus && n.Y + suuntaY >= 0;
            boolean onkoVariaKentanKohdassa = kentta.onkoVariaKartassaKohdassa(n.X + suuntaX, n.Y + suuntaY);
            
            if (!nelioEiMeneVaakatasossaYliKentan || !yEiMeneYliRajojen || onkoVariaKentanKohdassa) {
                return false;
            }
        }
        return true;
    } 
    

    public void luoUusiPala() {
        this.kentta.lisaaPalaKenttaan(this.pala);
        Pala uusiPala = Pala.luoSatunnainenPala();
        uusiPala.luoPalanAloitusPiste(0, 0);
        if (voikoPalaaLiikuttaaKartassaSuuntaan(uusiPala, 0, 0)) {
            this.pala = uusiPala;
        } else {
            peliKaynnissa = false;
        }       
    }

    public void rotaatio() {
        this.pala.rotaatio();
    }
    
    public void lopetaPeli() {
        System.out.println("LOPPU");
    }

    @Override
    public void keyTyped(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
public void keyPressed(KeyEvent e) {
    int keyCode = e.getKeyCode();
    switch( keyCode ) { 
        case KeyEvent.VK_UP:
            // handle up 
            break;
        case KeyEvent.VK_DOWN:
            // handle down 
            break;
        case KeyEvent.VK_LEFT:
            liikutaPalaaVasemmalle();
            // handle left
            break;
        case KeyEvent.VK_RIGHT :
            liikutaPalaaOikealle();
            // handle right
            break;
     }
} 

    @Override
    public void keyReleased(KeyEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
