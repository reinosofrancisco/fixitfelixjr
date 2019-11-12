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
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import game.Stats;
import graphicInterface.utils.ImageHashLoader;
import guiControllers.MouseContrMenu;
import util.GameConstants;
import util.ResourcePathConstants;

public class StatsPanel extends GenericWindowPanel
{
	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private static final int WIDTH = 800;
	private static final int HEIGHT = 500;

	
	private JTextArea t1=new JTextArea();
	private JTextArea t2=new JTextArea();
	private JTextArea t3=new JTextArea();
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
		// TABLE
//		gbc.weighty = 1.0;
//		gbc.insets = new Insets(110, 50, 50, 50);
//		addGB(this, t1, 0, 2);
		
//		//TEXT CONFIGURE
//		Font f = new Font(Font.MONOSPACED, Font.BOLD, 30);
//		t1.setFont(f);
//		t1.setText("La cantidad de veces que se ejecuto la Aplicacion es: " + Stats.getTimesExecuted());
//		
//		t2.setFont(f);
//		t2.setText("La cantidad de veces que se clickeo el QUIERO JUGAR es: " + Stats.getTimesPressedPlay());
//		
//		t3.setFont(f);
//		t3.setText("La cantidad de ganadores a lo largo del timepo es: " + Stats.getTimesNewHighscore());
		
		
		
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
