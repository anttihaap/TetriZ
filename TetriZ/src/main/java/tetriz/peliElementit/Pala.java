/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tetriz.peliElementit;

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
        this.neliot = new Nelio[4];
        
        //Asetetaan palatyylin väri:
        this.palatyypinVari = vari;

        this.palanKaantoKerrat = 0;
    }
    
    public void luoAloitusPisteJaNeliot(int x, int y) {
        this.aloitusPisteX = x;
        this.aloitusPisteY = y;
        luoNeliot();
    }

    public void luoNeliot() {        

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
            if (nelio.palautaX() == x && nelio.palautaY() == y) {
                return nelio.palautaVari();
            }
        }
        return null;
    }

    public void liikuAlas() {
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

    //TODO
    public void rotaatio() {


    }

}
