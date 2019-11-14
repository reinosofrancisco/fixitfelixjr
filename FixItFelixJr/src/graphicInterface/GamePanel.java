package graphicInterface;

import java.awt.Graphics;
import graphicInterface.utils.ExtImage;
import graphicInterface.utils.GraphicsGame;

public class GamePanel extends GenericWindowPanel {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	private static GamePanel instance;
	private GamePanel() {
		super();
		setFocusable(true); //PARA QUE FUNCIONE KEYLISTENER
		requestFocus();
		GraphicsGame.getInstance();
		
	}

	public static GamePanel getInstance() {
		if (instance == null) {
			instance = new GamePanel();
		}
		return instance;
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		draw(g);
	}

	@Override
	public void draw(Graphics g) {
		// DIBUJO CADA VARIABLE DE INSTANCIA EN EL PANEL
		for (ExtImage i : GraphicsGame.getInstance().getImagesAct()) {
			g.drawImage(i.getImg(), i.getPos().getPosx(), i.getPos().getPosy(), i.getWidth(), i.getHeight(),i.getColor(),null);
		}

	}

	public void update() {
		
	}

}
