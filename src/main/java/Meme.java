import java.awt.image.BufferedImage;

/**
 * A Meme
 *
 * @author Huw Jones
 * @since 21/04/2016
 */
public class Meme {
    public BufferedImage getImage () {
        return image;
    }

    public String getText () {
        return text;
    }

    private final BufferedImage image;
    private final String text;


    public Meme (BufferedImage image, String text) {
        this.image = image;
        this.text = text;
    }
}
