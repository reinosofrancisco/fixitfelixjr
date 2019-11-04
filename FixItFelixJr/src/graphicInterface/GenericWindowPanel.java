package graphicInterface;

import java.awt.Graphics;

import javax.swing.JPanel;

public abstract class GenericWindowPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	protected GenericWindowPanel() {
		
	}
	
	
	//IS THIS NECESARIO??!=?!?!!??
	public abstract void paintComponent(Graphics g);
	
	public abstract void draw(Graphics g);

}
