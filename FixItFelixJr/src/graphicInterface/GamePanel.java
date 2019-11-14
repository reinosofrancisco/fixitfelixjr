package graphicInterface;

import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
		
		//borrar dsp
		addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				System.out.println("Pressed mouse at X: [" + getMousePosition().x +"] [" + getMousePosition().y + "]");
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		//BORRAR DESPUES LO DE ARRIBA
		
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
//		graphicsController.update(); PREGUNTAR si puedo hacerlo
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
