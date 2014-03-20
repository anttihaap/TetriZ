/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetriz.peliElementit;

import tetriz.peliElementit.Nelio;
import java.awt.Color;

public enum Pala {

    //Palatyypit ja niiden värit:
    NELIOPALA(Color.pink),
    SUORAPALA(Color.red),
    KOLMIOPALA(Color.blue),
    OIKEAVINO(Color.green),
    VASENVINO(Color.black),
    OIKEAL(Color.orange),
    VASENL(Color.yellow);

    //Kyseisein palan ominaisuudet
    public Color palatyypinVari;
    public Nelio[] neliot;
    public int kaantoNelionIndeksi;
    public int aloitusPisteX;
    public int aloitusPisteY;

    public int palanKaantoKerrat;

    Pala(Color vari) {
        this.aloitusPisteX = 0;
        this.aloitusPisteY = 0;
        
        //Asetetaan palatyylin väri:
        this.palatyypinVari = vari;

        //Luodaan palalle palatyypin ominaiset neliöt
        //this.luoPalanNeliot();
        this.palanKaantoKerrat = 0;
    }

    //Luokka palauttaa satunnaisen Pala luokan
    //esim. Pala randomPala = Pala.luoSatunnainenPala();
    public static Pala luoSatunnainenPala() {
        return values()[(int) (Math.random() * values().length)];
    }
    
    public void luoPalaJaAnnaAloitusPiste(int x, int y) {
        this.aloitusPisteX = x;
        this.aloitusPisteY = y;
        this.luoNeliot();
    }

    public void luoNeliot() {        
        this.neliot = new Nelio[4];
        switch (this.toString()) {
            case "NELIOPALA":
                this.neliot[0] = new Nelio(aloitusPisteX - 1, aloitusPisteY, this.palatyypinVari);
                this.neliot[1] = new Nelio(aloitusPisteX - 1, aloitusPisteY + 1, this.palatyypinVari);
                this.kaantoNelionIndeksi = 2;
                this.neliot[2] = new Nelio(aloitusPisteX, aloitusPisteY, this.palatyypinVari);
                this.neliot[3] = new Nelio(aloitusPisteX, aloitusPisteY + 1, this.palatyypinVari);
                break;
            case "SUORAPALA":
                for (int i = 0; i < 4; i++) {
                    this.neliot[i] = new Nelio(aloitusPisteX - 2 + i, 0, palatyypinVari);
                }
                this.kaantoNelionIndeksi = 2;
                break;
            case "KOLMIOPALA":
                this.kaantoNelionIndeksi = 2;
                this.neliot[0] = new Nelio(aloitusPisteX - 1, aloitusPisteY, palatyypinVari);
                this.neliot[1] = new Nelio(aloitusPisteX - 2, aloitusPisteY + 1, palatyypinVari);
                this.neliot[2] = new Nelio(aloitusPisteX - 1, aloitusPisteY + 1, palatyypinVari);
                this.neliot[3] = new Nelio(aloitusPisteX, aloitusPisteY + 1, palatyypinVari);
                break;
            case "OIKEAVINO":
                this.neliot[0] = new Nelio(aloitusPisteX - 2, aloitusPisteY + 1, palatyypinVari);
                this.neliot[1] = new Nelio(aloitusPisteX - 1, aloitusPisteY + 1, palatyypinVari);
                this.neliot[2] = new Nelio(aloitusPisteX - 1, aloitusPisteY, palatyypinVari);
                this.neliot[3] = new Nelio(aloitusPisteX, aloitusPisteY + 1, palatyypinVari);
                break;
            case "VASENVINO":
                this.neliot[0] = new Nelio(aloitusPisteX - 2, aloitusPisteY, palatyypinVari);
                this.neliot[1] = new Nelio(aloitusPisteX - 1, aloitusPisteY, palatyypinVari);
                this.neliot[2] = new Nelio(aloitusPisteX - 1, aloitusPisteY + 1, palatyypinVari);
                this.neliot[3] = new Nelio(aloitusPisteX, aloitusPisteY + 1, palatyypinVari);
                break;
            case "OIKEAL":
                this.neliot[0] = new Nelio(aloitusPisteX - 2, aloitusPisteY, palatyypinVari);
                this.neliot[1] = new Nelio(aloitusPisteX - 2, aloitusPisteY + 1, palatyypinVari);
                this.neliot[2] = new Nelio(aloitusPisteX - 1, aloitusPisteY + 1, palatyypinVari);
                this.neliot[3] = new Nelio(aloitusPisteX, aloitusPisteY + 1, palatyypinVari);
                break;
            case "VASENL":
                this.neliot[0] = new Nelio(aloitusPisteX, aloitusPisteY, palatyypinVari);
                this.neliot[1] = new Nelio(aloitusPisteX - 2, aloitusPisteY + 1, palatyypinVari);
                this.neliot[2] = new Nelio(aloitusPisteX - 1, aloitusPisteY + 1, palatyypinVari);
                this.neliot[3] = new Nelio(aloitusPisteX, aloitusPisteY + 1, palatyypinVari);
                break;
        }
    }

    public Nelio[] palautaPalanNeliot() {
        return this.neliot;
    }

    public Color palautaVariKordinaatista(int x, int y) {
        for (Nelio nelio : neliot) {
            if (nelio.X == x && nelio.Y == y) {
                return nelio.palautaVari();
            }
        }
        return null;
    }

    public void liikutaPalaaAlas() {
        for (Nelio n : this.neliot) {
            n.alas();
        }
    }

    public void liikuOikealle() {
        for (Nelio n : this.neliot) {
            n.oikealle();
        }
    }
    
    public void liikuVasemmalle() {
        for (Nelio nelio : neliot) {
            nelio.vasemmalle();           
        }
    }

    //Ei toimi, kesken!
    public void rotaatio() {
        for (Nelio nelio : neliot) {
            int uusiX = (int) ((nelio.X) * Math.cos(Math.PI / 2) - (nelio.Y) * Math.sin(Math.PI / 2));
            int uusiY = (int) ((nelio.X) * Math.sin(Math.PI / 2) - (nelio.Y) * Math.cos(Math.PI / 2));
            nelio.asetaKordinaatit(- 1 * uusiX, -1 * uusiY);
        }

    }

}
