
package tetriz.kayttoliittyma;

import tetriz.tyokalut.Kuvanlataaja;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JPanel;
import javax.swing.KeyStroke;

import tetriz.logiikka.Peli;
import tetriz.peliElementit.Nelio;

/**
 * Pelipaneeli pitää sisällään pelin pääsäijeen ja piirtää peliä.
 */
public class Pelipaneeli extends JPanel implements Runnable {

    final BufferedImage tyhjaPala = Kuvanlataaja.palautaKuva("/kuvat/NULL.jpg");
    final BufferedImage varjoPala = Kuvanlataaja.palautaKuva("/kuvat/VARJO.jpg");

    Peli peli;

    Thread pelisaie;

    //Syote
    PelipaneeliSyote syote;
    InputMap syoteKartta;
    ActionMap toimntoKartta;

    Paaikkuna paaikkuna;

    /**
     *
     * @param ikkuna
     */
    public Pelipaneeli(Paaikkuna ikkuna) {
        this.paaikkuna = ikkuna;

        //JPanelin ominaisuudet:
        setSize(500, 630);
        setBackground(Color.black);

        //Syote:
        lisaaSyotteet();

        peli = new Peli(ikkuna.pelinAsetukset.palautaVaikeustaso());

        //Pelinsäie:
        pelisaie = new Thread(this);
        pelisaie.start();
    }

    @Override
    public void run() {
        //Aloittaa uuden pelin pelin asetuksen mukella viiveellä.
        aloitaPeli(paaikkuna.pelinAsetukset.palautaPelinNopeus());
        
        viive(1000);
        
        //Pelin loputtua kutustaan pääikkunan lopetaPeli-metodia.
        paaikkuna.lopetaPeli();
    }

    /**
     * Metodi luo uuden uuden pelin ja aloittaa pelin pääloopin.
     * Peli liikuttaa palaa alas ja kutsuu repaint()-metodia kunnes
     * peliKaynnissa-totuusarvo muuttuu epätodeksi.
     * @param viive viive
     */
    public void aloitaPeli(int viive) {
        peli = new Peli(paaikkuna.pelinAsetukset.palautaVaikeustaso());
        repaint();
        
        //Pelin pääloop:
        while (peli.peliKaynnissa) {           
            viive(viive);

            peli.liikutaPalaaAlas();
            repaint();
        }
    }

    private void viive(long viive) {
        try {
            Thread.sleep(viive);
        } catch (InterruptedException e) {
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        piirraKentta(g);

        //Varjopala piirretään riippuen pelin asetuksista.
        if (paaikkuna.pelinAsetukset.palautaVarjoPalapiirretaan()) {
            piirraVarjopala(g);
        }

        //Seuraava pala piirretään riippuen pelin asetuksista.
        if (paaikkuna.pelinAsetukset.palautaSeuraavapalaPiirretaan()) {
            piirraSeuraavaPala(g);
        }

        
        piirraPisteet(g);
    }

    /**
     * Metodi käy pelitilanne-kordinaatiston läpi ja piirtää kohdan palan,
     * mutta kuvaa ei löydy piirretään tyhjaKohta-kuva.
     */
    private void piirraKentta(Graphics g) {
        BufferedImage[][] pelitilanne = peli.palautaPeliTilanne();
        for (int y = 0; y < 20; y++) {
            for (int x = 0; x < 10; x++) {
                if (pelitilanne[x][y] != null) {
                    g.drawImage(pelitilanne[x][y], x * 30, y * 30, null);
                } else {
                    g.drawImage(tyhjaPala, x * 30, y * 30, null);
                }
            }
        }
    }

    /**
     * Varjopalan piirtaminen. Piirretaan, jos peliTilanteen-kordinaatiston kohta on tyhja. 
     * @param g graffikka johon piirretään
     */
    private void piirraVarjopala(Graphics g) {
        for (Nelio n : peli.palautaVarjopala().palautaPalanNeliot()) {
            if (peli.palautaPeliTilanne()[n.palautaX()][n.palautaY()] == null) {
                g.drawImage(varjoPala, n.palautaX() * 30, n.palautaY() * 30, null);
            }

        }
    }

    /**
     * Piirtää seuraavan palan paneeliin.
     * @param g graffikka johon piirretään
     */
    private void piirraSeuraavaPala(Graphics g) {
        int alkuY = 50;
        int alkuX = 30 * 11;
        Nelio[] seuraavaPala = peli.palautaSeuraavanPalanTetrispalatyypinNeliot();

        for (Nelio nelio : seuraavaPala) {
            g.drawImage(varjoPala, alkuX + (nelio.palautaX() * 30), alkuY + (nelio.palautaY() * 30), null);
        }

    }

    /**
     * Piirtää pisteet paneeliin.
     * @param g graffikka johon piirretään
     */
    private void piirraPisteet(Graphics g) {
        //Pisteet:
        g.setColor(Color.white);
        g.drawString("Pisteet: " + peli.tilasto.palautaPisteet(), 305, 20);

        //Luotujen palojen maara:
        g.setColor(Color.white);
        g.drawString("PalojaLuotu: " + peli.tilasto.palautaPalojaLuotu(), 305, 30);

        //Riveja tuhottu:
        g.setColor(Color.white);
        g.drawString("Riveja tuhottu: " + peli.tilasto.palautaRivejaTuhottu(), 305, 40);
    }

    /**
     * Lisää tarvittavat näppäimistön syötteet peliä varten.
     */
    private void lisaaSyotteet() {
        syoteKartta = getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);
        toimntoKartta = getActionMap();

        lisaaSyote(KeyEvent.VK_UP, "Ylos");
        lisaaSyote(KeyEvent.VK_DOWN, "Alas");
        lisaaSyote(KeyEvent.VK_RIGHT, "Oikealle");
        lisaaSyote(KeyEvent.VK_LEFT, "Vasemmalle");
        lisaaSyote(KeyEvent.VK_SPACE, "Pohjaan");
    }

    /**
     * Lisää yksittäisen syötteen syötekarttaan käyttäen PelipaneeliSyöte-luokkaa.
     * @param key näppäin
     * @param syote syötteen tunnistemerkkijono
     */
    private void lisaaSyote(int key, String syote) {
        syoteKartta.put(KeyStroke.getKeyStroke(key, 0), syote);
        toimntoKartta.put(syote, new PelipaneeliSyote(syote, this));
    }
}
