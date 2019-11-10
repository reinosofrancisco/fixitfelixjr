package graphicInterface;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import guiControllers.MouseContS;
import guiControllers.MouseContrMenu;
import util.GameConstants;

public class ConfigurePanel extends GenericWindowPanel {


	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	//TODO singletone
	private JLabel selection= new JLabel("Selecccione la dificultad");
	private Choice dificulty= new Choice();
	private JButton selected= new JButton("Seleccionar");
	private JButton back= new JButton("<<");
	private GridBagConstraints gbc= new GridBagConstraints();
	private static ConfigurePanel instance;
	private String imgP="\\data\\MenuImages\\configBackGround.jpg";
	private Image i;
	private ConfigurePanel()
	{
		loadImage();
		this.setLayout(new GridBagLayout());
		gbc.gridx= 1;
		gbc.gridy= 2;
		gbc.gridheight=2;
		gbc.gridwidth=2;
		gbc.fill= GridBagConstraints.BOTH;
		selection.setForeground(Color.WHITE);
		this.add(selection,gbc);
		completChoice();
		gbc.gridx= 1;
		gbc.gridy= 4;
		gbc.gridheight=2;
		gbc.gridwidth=2;
		gbc.fill= GridBagConstraints.BOTH;
		this.add(dificulty,gbc);
		back.addMouseListener(new MouseContrMenu());
		gbc.gridx=1;
		gbc.gridy=0;
		gbc.gridheight=1;
		gbc.gridwidth=1;
		this.add(back, gbc);
		this.selected.addMouseListener(new MouseContS());
		gbc.gridx= 1;
		gbc.gridy= 6;
		gbc.gridheight=2;
		gbc.gridwidth=2;
		gbc.fill= GridBagConstraints.BOTH;
		this.add(selected, gbc);
	}

	public static ConfigurePanel getInstance()
	{
		if(instance == null)
		{
			instance= new ConfigurePanel();
		}
		return instance;
	}


	private void completChoice()
	{
		int i;
		for(i=0;i<10;i++)
		{
			dificulty.add( ""+(i+1));

		}
	}

	public Choice getDificulty()
	{
		return this.dificulty;
	}
	private void loadImage()
	{
		URL urlImg = getClass().getClassLoader().getResource(imgP);
		if (urlImg == null) {
			System.out.println("No se encuentra la imagen");
		} else {
			try {
				this.i = ImageIO.read(urlImg);

			} catch (IOException e) {
				System.out.println("dem");
				e.getStackTrace();
			}
		}
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		draw(g);
	}
	public void draw(Graphics g) {
		g.drawImage(i, 0, 0, GameConstants.WINDOW_WIDTH, GameConstants.WINDOW_HEIGHT, null);
	}

	public static void main(String args[])
	{
		JFrame m= new JFrame();
		ConfigurePanel p= ConfigurePanel.getInstance();
		m.add(p);
		m.setSize(1080, 720);
		m.setVisible(true);

	}



}
