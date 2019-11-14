package graphicInterface;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import guiControllers.MouseContConfig;
import guiControllers.MouseContGameWin;
import guiControllers.MouseContInstr;
import guiControllers.MouseContRank;
import guiControllers.MouseContStats;
import util.GameConstants;
import util.ResourcePathConstants;

public class MenuPanel extends GenericWindowPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static MenuPanel instance;
	
	
	private JButton play = new JButton("¡A JUGAR!");
	private JButton instructions = new JButton("¿COMO JUGAR?");
	private JButton ranking = new JButton("TOP 5");
	private JButton config = new JButton("Configuracion");
	private JButton stats = new JButton("Estadisticas");

	private GridBagConstraints gbc = new GridBagConstraints();
	
	private String iconfURL= ResourcePathConstants.MENU_ICONFIG;
	
	
	private String imageUrl = ResourcePathConstants.MENU_BACKGROUND;
	private Image img;

	/**
	 * El constructor instancia todas las cosas necesarias del Frame
	 * 
	 */
	private MenuPanel() {
		super();
		this.setLayout(new GridBagLayout());
		
		
		
			//-SETUP CONFIG-/
		URL urlImg = getClass().getClassLoader().getResource(iconfURL);
		if (urlImg == null) {
			System.out.println("No se encuentra la imagen iconf");
		} else {
			try {
				Icon iconf=new ImageIcon(ImageIO.read(urlImg));
				config.setIcon(iconf);
				
			} catch (IOException e) {
				System.out.println("well F..");
				e.getStackTrace();
			}
		}
		config.setPreferredSize(new Dimension(200,50));
		
		
		//-SETUP PLAY-/
		
		
		
		
		
		play.setBackground(Color.WHITE);
		instructions.setBackground(Color.WHITE);
		ranking.setBackground(Color.WHITE);
		config.setBackground(Color.YELLOW);
		stats.setBackground(Color.CYAN);
		
		
		

		// ---SETUP BUTTONS-----//
			//--POSITIONS--/


		gbc.fill = GridBagConstraints.BOTH;
		gbc.insets= new Insets(20, 20, 20, 20);
		addGB(this, config, 6, 0);
		gbc.weighty = 1.0;
		gbc.weightx = 1.0;
		gbc.insets=new Insets(300, 70, 250, 50);
		addGB(this, stats, 0, 2);
		gbc.insets=new Insets(300, 60, 250, 0);
		addGB(this, instructions, 1, 2);
		gbc.insets=new Insets(300, 50, 250, 0);
		addGB(this, play, 2, 2);
		gbc.insets=new Insets(300, 50, 250, 50);
		addGB(this, ranking, 3, 2);
		
		this.instructions.addMouseListener(new MouseContInstr());
		this.play.addMouseListener(new MouseContGameWin());
		this.ranking.addMouseListener(new MouseContRank());
		this.config.addMouseListener(new MouseContConfig());
		this.stats.addMouseListener(new MouseContStats());
		//TODO
		//this.config.addMouseListener(new MouseContConfig);
		
		
		
		// --END OF SETUP BUTTONS--//

		// --SETUP BACKGROUND--//

		urlImg = getClass().getClassLoader().getResource(imageUrl);
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
	}
	
	
	public static MenuPanel getInstance() {
		if (instance==null) {
			instance=new MenuPanel();
		}
		return instance;
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