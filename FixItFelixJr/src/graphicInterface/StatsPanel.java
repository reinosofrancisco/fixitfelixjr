package graphicInterface;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import javax.swing.JButton;
import game.Stats;
import graphicInterface.utils.ImageHashLoader;
import guiControllers.MouseContrMenu;
import util.ResourcePathConstants;

public class StatsPanel extends GenericWindowPanel
{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private static final int WIDTH = 800;
	private static final int HEIGHT = 500;

	
	private JButton back= new JButton("Volver al menu");
	private GridBagConstraints gbc=new GridBagConstraints();
	private Image i;
	private static StatsPanel instance;



	private StatsPanel()
	{
		super(WIDTH,HEIGHT);
		i=ImageHashLoader.getImages().get(ResourcePathConstants.STATS_BG_S);
		this.setLayout(new GridBagLayout());
		gbc.fill= GridBagConstraints.BOTH;
		gbc.weightx=1.0;
		//BACK
		gbc.weighty=0.1;
		gbc.insets=new Insets(10,150,450,150);
		addGB(this, back, 0, 0);
		back.addMouseListener(new MouseContrMenu());
	}



	void addGB(Container cont, Component comp, int x, int y) {
		gbc.gridx = x;
		gbc.gridy = y;
		cont.add(comp, gbc);
	}
	
	
	public static StatsPanel getInstance()
	{
		if(instance == null)
		{
			instance=new StatsPanel();
		}
		return instance;
	}

	@Override
	public void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		draw(g);
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(i, 0, 0, WIDTH, HEIGHT, null);
		g.setFont(new Font(Font.MONOSPACED, Font.BOLD, 20));
		g.setColor(Color.white);
		String s= "La cantidad de veces que se ejecuto la Aplicacion es: " + Stats.getTimesExecuted();
		g.drawString(s, 50, 100);
		s="La cantidad de veces que se clickeo el QUIERO JUGAR es: " + Stats.getTimesPressedPlay();
		g.drawString(s, 50, 130);
		s="La cantidad de ganadores a lo largo del timepo es: " + Stats.getTimesNewHighscore();
		g.drawString(s, 50, 160);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

}
