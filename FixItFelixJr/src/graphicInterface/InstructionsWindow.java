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

public class InstructionsWindow extends GenericWindowPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static InstructionsWindow instance;
	
	private String imageUrl = ResourcePathConstants.INSTRUCTIONS;
	// ResourcePathConstants.INSTRUCTIONS;
	private Image img;
	private JButton back = new JButton("<<");

	private InstructionsWindow() {
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
		this.setSize(GameConstants.WINDOW_WIDTH, GameConstants.WINDOW_HEIGHT);
		setVisible(false);
	}
	
	public static InstructionsWindow getInstance() {
		if (instance==null) {
			instance=new InstructionsWindow();
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
		// TODO Auto-generated method stub
		super.paintComponents(g);
		draw(g);

	}

	public void draw(Graphics g) {
		g.setFont(new Font(Font.DIALOG, Font.BOLD, 30));
		g.drawImage(img, 0, 0, GameConstants.WINDOW_WIDTH, GameConstants.WINDOW_HEIGHT, null);
	}
}
