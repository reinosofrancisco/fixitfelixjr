package graphicInterface;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import graphicInterface.utils.ImageHashLoader;
import guiControllers.MouseContInputHS;
import guiControllers.MouseContS;
import guiControllers.MouseContrMenu;
import util.GameConstants;
import util.ResourcePathConstants;
public class InputScorePanel extends GenericWindowPanel{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final static int WIDTH=300; //i put this variables here for better code understanding
	private final static int HEIGHT=300;
	
	//TODO singletone
	private JLabel inputN= new JLabel("NUEVO HIGHSCORE!! \nIngrese su nombre: ");
	private JTextField area1= new JTextField(100);
	private JButton send= new JButton("Enviar");
	private GridBagConstraints gbc=new GridBagConstraints();
	
	
	private static InputScorePanel instance;
	
	private InputScorePanel()
	{
		super(WIDTH,HEIGHT);
		this.setLayout(new GridBagLayout());

		gbc.fill=GridBagConstraints.BOTH;
		gbc.weighty=0.25;
		gbc.insets=new Insets(0,100,0,100);
		addGB(this, inputN, 0, 0);
		gbc.weighty=0.4;
		gbc.insets=new Insets(20,90,5,90);
		addGB(this, area1, 0, 1);
		gbc.weighty=1.0;
		gbc.insets=new Insets(0,90,150,90);
		addGB(this, send, 0, 2);
		send.addMouseListener(new MouseContInputHS());
		
	}
	
	public static InputScorePanel getInstance()
	{
		if(instance == null)
		{
			instance= new InputScorePanel();
		}
		return instance;
	}
	
	void addGB(Container cont, Component comp, int x, int y) {
		gbc.gridx = x;
		gbc.gridy = y;
		cont.add(comp, gbc);
	}

	public JTextField getArea1() {
		return area1;
	}

	public void setArea1(JTextField area1) {
		this.area1 = area1;
	}

	@Override
	public void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
