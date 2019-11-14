package graphicInterface;

import java.awt.Graphics;

import javax.swing.JPanel;

import util.GameConstants;

public abstract class GenericWindowPanel extends JPanel{

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private final int WIDTH;
	private final int HEIGHT;
	
	/**
	 * Makes the pannel with default width and height
	 */
	protected GenericWindowPanel() {
		this(GameConstants.WINDOW_WIDTH,GameConstants.WINDOW_HEIGHT);
	}
	/**
	 * Makes the panel have different width and height
	 * affects the window
	 * @param w width
	 * @param h height
	 */
	protected GenericWindowPanel(int w,int h) {
		super();
		WIDTH=w;
		HEIGHT=h;
		setSize(WIDTH, HEIGHT);
		setVisible(false);
		
		
	}
	
	public abstract void paintComponent(Graphics g);
	
	public abstract void draw(Graphics g);
	
	public abstract void update();

}
