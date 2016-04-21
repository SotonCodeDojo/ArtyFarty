import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Reddit Meme Browser
 *
 * @author Huw Jones
 * @since 21/04/2016
 */
public class RedditBrowser {

    public Meme getMemeFromSubreddit(String subreddit){

    }

    public BufferedImage getFinalImage(Meme meme) {
        BufferedImage image = new BufferedImage(800, 600, BufferedImage.TYPE_INT_RGB);
        String words[] = meme.getText().toUpperCase().split(" ");
        String text = "";
        for (int i = 0; i < words.length; i++) {
            text += words[i] + " ";
            if (i == words.length / 2) {
                text += "\n";
            }
        }

        Graphics g1d = image.getGraphics();
        Graphics2D g = (Graphics2D) g1d;
        g.drawImage(meme.getImage(), 0, 0, 800, 600, null);

        Font font = new Font("Impact", Font.PLAIN, 60);
        g.setFont(font);
        g.setColor(getColor(image));

        int y = 20;
        for (String line : text.split("\n")) {
            g.drawString(line, 40, y += g.getFontMetrics().getHeight());
        }

        return image;
    }

    private Color getColor(BufferedImage image) {
        int overall = 0;
        for(int y = 0; y < image.getHeight(); y++){
            for(int x = 0; x < image.getWidth(); x++){
                int red = (new Color(image.getRGB(x, y))).getRed();
                int green = (new Color(image.getRGB(x, y))).getGreen();
                int blue = (new Color(image.getRGB(x, y))).getBlue();
                int average = Math.round((float) (red + green + blue) / (float) 3);
                overall += average;
            }
        }
        int pixels = image.getWidth() * image.getHeight();
        double average = Math.round((float) overall / (float) pixels);

        if (average > 127) {
            return Color.BLACK;
        } else {
            return Color.WHITE;
        }
    }
}
