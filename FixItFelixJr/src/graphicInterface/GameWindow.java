package graphicInterface;


import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JButton;

import guiControllers.KeyL;
import guiControllers.MouseContrMenu;
import util.GameConstants;

public class GameWindow extends GenericWindowPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static GameWindow instance;
	private JButton back= new JButton("<<");
	
	
	private GameWindow()
	{
		super();
		setFocusable(true);
		requestFocus();
		this.setLayout(new GridLayout(2,1));
		back.setBounds(0, 0, 100, 100);
		back.addMouseListener(new MouseContrMenu());
		this.add(back, 0, 0);
		this.addKeyListener(new KeyL());
		this.setSize(GameConstants.WINDOW_WIDTH, GameConstants.WINDOW_HEIGHT);
	}
	
	public static GameWindow getInstance() {
		if(instance== null) {
			instance=new GameWindow();
		}
		return instance;
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void paintComponent(Graphics g) {
		//super.paintComponents(g);
		
	}

	public void update() {
		//aki viene lo shido
		
	}
	

}

