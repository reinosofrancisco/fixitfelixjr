package graphicInterface;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import com.sun.org.apache.bcel.internal.generic.CPInstruction;

import graphicInterface.utils.ExtImage;
import graphicInterface.utils.GraphicsGame;
import guiControllers.KeyL;
import guiControllers.MouseContrMenu;
import util.GameConstants;

public class GamePanel extends GenericWindowPanel {

	/**
	 * 
	 */

	private static final long serialVersionUID = 1L;
	private static GamePanel instance;
	private GraphicsGame graphicsController;

	private GamePanel() {
		super();
		setFocusable(true); //PARA QUE FUNCIONE KEYLISTENER
		requestFocus();
		graphicsController = GraphicsGame.getInstance();
		
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
		
		this.addKeyListener(new KeyL());
		
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
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		// DIBUJO CADA VARIABLE DE INSTANCIA EN EL PANEL
		for (ExtImage i : graphicsController.getImagesAct()) {
			g.drawImage(i.getImg(), i.getPos().getPosx(), i.getPos().getPosy(), i.getWidth(), i.getHeight(),i.getColor(),null);
		}
//		System.out.println("pintando");

	}

	public void update() {
		// Actualizo imagenes de todos mis paneles y componentes

//		graphicsController.update();

		// POR AHORA IMAGENES ESTATICAS
		// VARIABLES DE INSTANCIA TIENEN IMAGENES Y POSICION
		// PARA CADA VARIABLE DE INSTANCIA PINTO LA IMAGEN DE DICHA VARIABLE EN LA
		// POSICION
		// INDICADA POR LA MISMA

		// llamo a repaint de todas mis cosas
//		MainGameWindow.getInstance().repaint();

	}

}
