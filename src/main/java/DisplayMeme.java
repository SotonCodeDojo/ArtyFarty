import java.awt.Graphics;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.JFrame;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class DisplayMeme extends JFrame {

	public DisplayMeme(Meme meme) {
		this((Image)meme.getImage());
	}
	
	public DisplayMeme (Image image){
		super("Generated meme");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		Insets insets = getInsets();
		setSize(image.getWidth(null)+insets.left+insets.right, image.getHeight(null)+insets.top+insets.bottom);
//		setResizable(false);
		setContentPane(new JPanel(){
			@Override
			public void paint(Graphics g){
				super.paint(g);
				g.drawImage(image, 0, 0, null);
			}
		});
	}
}
