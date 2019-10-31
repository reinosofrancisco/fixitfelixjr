package graphicInterface;


import javax.swing.JPanel;

import guiControllers.KeyL;

public class GameWindow extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	public GameWindow()
	{
		
		this.addKeyListener(new KeyL());
		this.setSize(200, 200);
	}
	

}

