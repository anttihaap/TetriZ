

package tetriz.tyokalut;

import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 * Luokka lataa kuvia.
 * 
 */
public class Kuvanlataaja {
    
    /**
     * Palauttaa kuvan polusta.
     * @param polku
     * @return kuva
     */
    public static BufferedImage palautaKuva(String polku) {
       BufferedImage kuva = null;
        try {
            kuva = ImageIO.read(Kuvanlataaja.class.getClass().getResource(polku));
        } catch (IOException e) {
            System.out.println("kuva ei lataudu");
        }
        return kuva;
    }
}
