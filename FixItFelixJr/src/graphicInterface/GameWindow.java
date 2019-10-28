package graphicInterface;

import javax.swing.JFrame;

import guiControllers.KeyL;

public class GameWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public GameWindow()
	{
		super("Fix It Felix");
		this.addKeyListener(new KeyL());
		this.setSize(200, 200);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}
	

}

