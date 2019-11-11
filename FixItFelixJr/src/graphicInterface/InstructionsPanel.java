package graphicInterface;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

import guiControllers.MouseContrMenu;
import util.GameConstants;
import util.ResourcePathConstants;

public class InstructionsPanel extends GenericWindowPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static InstructionsPanel instance;
	
	private String imageUrl = ResourcePathConstants.INSTRUCTIONS;
	// ResourcePathConstants.INSTRUCTIONS;
	private Image img;
	private JButton back = new JButton("<<");

	private InstructionsPanel() {
		super();
		back.setBounds(0, 0, 50, 50);
		back.addMouseListener(new MouseContrMenu());
		this.add(back, 0, 0);
		URL urlImg = getClass().getClassLoader().getResource(imageUrl);
		if (urlImg == null) {
			System.out.println("No se encuntra la imagen");
		} else {
			try {
				setImg(ImageIO.read(urlImg));

			} catch (IOException e) {
				e.getStackTrace();
			}
		}
	}
	
	public static InstructionsPanel getInstance() {
		if (instance==null) {
			instance=new InstructionsPanel();
		}
		return instance;
	}
	
	

	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		draw(g);

	}

	public void draw(Graphics g) {
		g.drawImage(img, 0, 0, GameConstants.WINDOW_WIDTH, GameConstants.WINDOW_HEIGHT, null);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
}
