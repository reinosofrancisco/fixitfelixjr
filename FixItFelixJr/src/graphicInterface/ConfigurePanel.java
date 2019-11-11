package graphicInterface;

import java.awt.Choice;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import graphicInterface.utils.ImageHashLoader;
import guiControllers.MouseContS;
import guiControllers.MouseContrMenu;
import util.ResourcePathConstants;

public class ConfigurePanel extends GenericWindowPanel {


	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	
	private final static int WIDTH=300; //i put this variables here for better code understanding
	private final static int HEIGHT=300;
	
	private JLabel selection= new JLabel("Selecccione el nivel");
	private Choice difficulty= new Choice();
	private JButton selected= new JButton("Seleccionar");
	private JButton back= new JButton("Volver al menu");
	private GridBagConstraints gbc= new GridBagConstraints();
	private static ConfigurePanel instance;
	private Image i;
	private ConfigurePanel()
	{
		super(WIDTH,HEIGHT);
		i=ImageHashLoader.getImages().get(ResourcePathConstants.CONFIG_BG_S);
		this.setLayout(new GridBagLayout());
		
		gbc.fill=GridBagConstraints.BOTH;
		gbc.weighty=0.25;
		gbc.insets=new Insets(0,100,0,100);
		addGB(this, back, 0, 0);
		gbc.weighty=0.4;
		gbc.insets=new Insets(20,90,5,90);
		addGB(this, selected, 0, 1);
		gbc.weighty=1.0;
		gbc.insets=new Insets(0,90,150,90);
		addGB(this, difficulty, 0, 2);
		completChoice();
		back.addMouseListener(new MouseContrMenu());
		selected.addMouseListener(new MouseContS());
		selection.setForeground(Color.WHITE);
		
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
			difficulty.add(""+(i+1));

		}
	}

	public Choice getDificulty()
	{
		return this.difficulty;
		
	}
	
	void addGB(Container cont, Component comp, int x, int y) {
		gbc.gridx = x;
		gbc.gridy = y;
		cont.add(comp, gbc);
	}	
	
	@Override
	public void update() {
		// TODO Auto-generated method stub

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		draw(g);
	}
	public void draw(Graphics g) {
		g.drawImage(i, 0, 0, getWidth(), getHeight(), null);
	}

	public static void main(String args[])
	{
		JFrame m= new JFrame();
		ConfigurePanel p= ConfigurePanel.getInstance();
		m.add(p);
		m.setSize(1080, 720);
		p.setVisible(true);
		m.setVisible(true);

	}



}
