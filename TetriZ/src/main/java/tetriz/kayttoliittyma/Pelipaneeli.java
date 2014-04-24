/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetriz.kayttoliittyma;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.SwingUtilities;

import tetriz.logiikka.Peli;
import tetriz.peliElementit.Nelio;

/**
 *
 * @author Antti
 */
public class Pelipaneeli extends JPanel implements Runnable {

    final BufferedImage tyhjaKohta;
    final BufferedImage varjoPala;

    Peli peli;

    Thread pelisaie;

    //Syote
    PelipaneeliSyote syote;
    InputMap syoteKartta;
    ActionMap toimntoKartta;

    public Pelipaneeli() {
        setSize(500, 630);
        setVisible(true);
        setBackground(Color.black);

        //Syote:
        syoteKartta = getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);
        toimntoKartta = getActionMap();
        lisaaSyotteet();

        //Ladataan tyhja- ja varjokuvat olioimuuttujiin:
        tyhjaKohta = palautaKuva("/kuvat/NULL.jpg");
        varjoPala = palautaKuva("/kuvat/VARJO.jpg");

        peli = new Peli();

        pelisaie = new Thread(this);
        pelisaie.start();
    }

    @Override
    public void run() {
        while (true) {
            aloitaPeli(500);
        }
    }

    public void aloitaPeli(int viive) {
        peli = new Peli();
        peli.peliKaynnissa = true;
        repaint();

        while (peli.peliKaynnissa) {
            System.out.println("loop");
            viive(viive);
            peli.liikutaPalaaAlas();
            repaint();
        }
    }

    private void viive(int viive) {
        try {
            Thread.sleep(viive);
        } catch (InterruptedException e) {
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        piirraKentta(g);
        piirraVarjopala(g);
    }

    private void piirraKentta(Graphics g) {
        /*
         * Kordinaatiston piirto:
         * (Jos kuvaa ei löydy, piirretään tyhjaKohta-kuva.)
         */
        BufferedImage[][] pelitilanne = peli.paivitaPeliTilanne();
        for (int y = 0; y < 20; y++) {
            for (int x = 0; x < 10; x++) {
                if (pelitilanne[x][y] != null) {
                    g.drawImage(pelitilanne[x][y], x * 30, y * 30, null);
                } else {
                    g.drawImage(tyhjaKohta, x * 30, y * 30, null);
                }
            }
        }
    }
    
    private void piirraVarjopala(Graphics g) {
        /*
         * Varjopalan piirtaminen. Piirretaan, jos peliTilanteen-kordinaatiston kohta on tyhja. 
         */
        for (Nelio n : peli.palautaVarjoPala().palautaPalanNeliot()) {
            if (peli.palaLogiikka.kordinaattiOnKentanSisalla(n.palautaX(), n.palautaY(), peli.kentta)) {
                if (peli.paivitaPeliTilanne()[n.palautaX()][n.palautaY()] == null) {
                    g.drawImage(varjoPala, n.palautaX() * 30, n.palautaY() * 30, null);
                }
            }
        }

        //Pisteet:
        g.setColor(Color.white);
        g.drawString("Pisteet: " + peli.tilasto.palautaPisteet(), 300, 10);

        //Luotujen palojen maara:
        g.setColor(Color.white);
        g.drawString("PalojaLuotu: " + peli.tilasto.palautaPalojaLuotu(), 300, 20);

        //Riveja tuhottu:
        g.setColor(Color.white);
        g.drawString("Riveja tuhottu: " + peli.tilasto.palautaRivejaTuhottu(), 300, 30);

    }

    private void lisaaSyotteet() {
        lisaaSyote(KeyEvent.VK_UP, "Ylos");
        lisaaSyote(KeyEvent.VK_DOWN, "Alas");
        lisaaSyote(KeyEvent.VK_RIGHT, "Oikealle");
        lisaaSyote(KeyEvent.VK_LEFT, "Vasemmalle");
        lisaaSyote(KeyEvent.VK_SPACE, "Pohjaan");
    }

    private void lisaaSyote(int key, String syote) {
        syoteKartta.put(KeyStroke.getKeyStroke(key, 0), syote);
        toimntoKartta.put(syote, new PelipaneeliSyote(syote, this));
    }

    private BufferedImage palautaKuva(String hakemisto) {
        BufferedImage kuva = null;
        try {
            kuva = ImageIO.read(getClass().getResource(hakemisto));
        } catch (IOException e) {
            System.out.println("kuva ei lataudu");
        }
        return kuva;
    }
}
