package tetriz.piirto;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

public class PaintKentta extends JPanel {

    Color[][] pelitilanne;

    public PaintKentta(Color[][] pelitilanne) {
        this.pelitilanne = pelitilanne;
    }
         
    @Override
    public void paint(Graphics g) {
        for (int y = 0; y < 20; y++) {
            for (int x = 0; x < 10; x++) {
                if (pelitilanne[x][y] == null) {
                    g.setColor(Color.white);
                } else {
                    g.setColor(pelitilanne[x][y]);
                }
                g.fillRect(x * 30, y * 30, 30, 30);
            }
        }
    }

}

