/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetriz.kayttoliittyma;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.ActionMap;
import javax.swing.InputMap;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.Timer;

import tetriz.logiikka.Peli;

/**
 *
 * @author Antti
 */
public class Pelipaneeli extends JPanel implements Runnable {

    Peli peli;
    PelipaneeliSyote syote;

    //Syote
    InputMap im;
    ActionMap am;

    final boolean voikoNappiaPainaa = true;

    public Pelipaneeli() {
        setVisible(true);
        setFocusable(true);
        setBackground(Color.black);

        im = getInputMap(JPanel.WHEN_IN_FOCUSED_WINDOW);
        am = getActionMap();
        luoSyotteet();

    }

    @Override
    public void run() {
        System.out.println("run");
        peli = new Peli(500);
        peli.aloita();

        this.repaint();

        Timer ajastin;
        ajastin = new Timer(500, new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (peli.peliKaynnissa) {
                    peli.liikutaPalaaAlas();
                    repaint();
                } else {
                    
                }
            }

        });

        ajastin.start();

    }

    @Override
    public void paint(Graphics g) {
        super.paintComponent(g);

        for (int y = 0; y < 20; y++) {
            for (int x = 0; x < 10; x++) {
                if (peli.paivitaPeliTilanne()[x][y] == null) {
                    g.setColor(Color.white);
                } else {
                    g.setColor(peli.paivitaPeliTilanne()[x][y]);
                }
                g.fillRect(x * 30, y * 30, 30, 30);
            }
        }
    }

    private void luoSyotteet() {
        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "Ylos");
        am.put("Ylos", new PelipaneeliSyote("Ylos", this));

        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_DOWN, 0), "Alas");
        am.put("Alas", new PelipaneeliSyote("Alas", this));

        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT, 0), "Oikealle");
        am.put("Oikealle", new PelipaneeliSyote("Oikealle", this));

        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_LEFT, 0), "Vasemmalle");
        am.put("Vasemmalle", new PelipaneeliSyote("Vasemmalle", this));

        im.put(KeyStroke.getKeyStroke(KeyEvent.VK_UP, 0), "Ylos");
        am.put("Ylos", new PelipaneeliSyote("Ylos", this));
    }

}
