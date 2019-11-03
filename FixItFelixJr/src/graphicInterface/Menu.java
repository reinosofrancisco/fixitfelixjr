package graphicInterface;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import guiControllers.MouseContGameWin;
import guiControllers.MouseContInstr;
import guiControllers.MouseContRank;
import util.GameConstants;
import util.ResourcePathConstants;

public class Menu extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton play = new JButton("¡A JUGAR!");
	private JButton instructions = new JButton("¿COMO JUGAR?");
	private JButton ranking = new JButton("TOP 5");
	private JButton config = new JButton("Config");
	private JButton stats = new JButton("Estadisticas");
	private GridBagConstraints gbc = new GridBagConstraints();

	private String imageUrl = ResourcePathConstants.MENU_BACKGROUND;
	private Image img;

	/**
	 * El constructor instancia todas las cosas necesarias del Frame
	 * 
	 * PREGUNTAR: Agrego filas y columnas de jpanels vacios porque me permite que
	 * quede todo mas bonito
	 * 
	 */
	Menu() {
		super();
		this.setLayout(new GridBagLayout());

		// ---SETUP BUTTONS-----//

		play.setBackground(Color.WHITE);
		instructions.setBackground(Color.WHITE);
		ranking.setBackground(Color.WHITE);
		config.setBackground(Color.YELLOW);
		stats.setBackground(Color.CYAN);

		gbc.weightx = 0.1;
		gbc.weighty = 0.1;
		gbc.fill = GridBagConstraints.BOTH;
		addGB(this, new transparentPanel(), 2, 0); // *
		addGB(this, new transparentPanel(), 4, 0); // *
		addGB(this, config, 6, 0);
		gbc.weighty = 0.05; // *
		addGB(this, new transparentPanel(), 0, 1); // *
		gbc.weightx = 0.5;
		gbc.weighty = 0.2;
		gbc.gridwidth = 1;
		addGB(this, new transparentPanel(), 0, 2);
		addGB(this, stats, 1, 0);
		gbc.weightx = 0.1; // *
		gbc.weighty = 0.9; // *
		addGB(this, new transparentPanel(), 0, 3); // *
		gbc.weighty = 0.4;
		gbc.weightx = 1.0;
		gbc.gridwidth = 1;
		gbc.gridheight = 1;
		addGB(this, instructions, 1, 4);
		addGB(this, play, 3, 4);
		addGB(this, ranking, 5, 4);
		gbc.weightx = 0.1; // *
		gbc.weighty = 0.9; // *
		addGB(this, new transparentPanel(), 0, 5); // *
		this.instructions.addMouseListener(new MouseContInstr());
		this.play.addMouseListener(new MouseContGameWin());
		this.ranking.addMouseListener(new MouseContRank());
		// --END OF SETUP BUTTONS--//

		// --SETUP BACKGROUND--//

		URL urlImg = getClass().getClassLoader().getResource(imageUrl);
		if (urlImg == null) {
			System.out.println("No se encuentra la imagen");
		} else {
			try {
				this.img = ImageIO.read(urlImg);

			} catch (IOException e) {
				System.out.println("dem");
				e.getStackTrace();
			}
		}

		this.setSize(GameConstants.WINDOW_WIDTH, GameConstants.WINDOW_HEIGHT);
		setVisible(false);
	}

	/**
	 * adds component (setted with black background) in containter with gridbag
	 * layout at
	 * 
	 * @param cont container (must have layout gridbaglayout)
	 * @param comp component to add
	 * @param x    column
	 * @param y    row
	 */
	void addGB(Container cont, Component comp, int x, int y) {
		gbc.gridx = x;
		gbc.gridy = y;
		cont.add(comp, gbc);
	}

	public static void main(String args[]) {

		JFrame m = new JFrame();
		Menu me = new Menu();
		m.add(me);
		m.setSize(GameConstants.WINDOW_WIDTH, GameConstants.WINDOW_HEIGHT);
		m.setVisible(true);
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		draw(g);

	}

	public void draw(Graphics g) {
		g.drawImage(img, 0, 0, GameConstants.WINDOW_WIDTH, GameConstants.WINDOW_HEIGHT, null);
	}

}

class transparentPanel extends JPanel {
	public transparentPanel() {
		super();
		super.setOpaque(false);
	}

}
