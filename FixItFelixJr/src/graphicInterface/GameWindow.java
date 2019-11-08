package graphicInterface;


import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

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
	private GraphicsGame graphicsController;
	
	
	
	
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
		setVisible(false);
		this.setSize(GameConstants.WINDOW_WIDTH, GameConstants.WINDOW_HEIGHT);
		
		
		graphicsController=GraphicsGame.getInstance();
	}
	
	public static GameWindow getInstance() {
		if(instance== null) {
			instance=new GameWindow();
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
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		//DIBUJO CADA VARIABLE DE INSTANCIA EN EL PANEL
		for (ExtImage i : graphicsController.getImagesAct()) {
			g.drawImage(i.getImg(), i.getPos().getPosx(), i.getPos().getPosy(), i.getWidth(), i.getHeight(), null);
		}
		
	}

	public void update() {
		//Actualizo imagenes de todos mis paneles y componentes
		
		graphicsController.update();
		
		//POR AHORA IMAGENES ESTATICAS
		//VARIABLES DE INSTANCIA TIENEN IMAGENES Y POSICION
		//PARA CADA VARIABLE DE INSTANCIA PINTO LA IMAGEN DE DICHA VARIABLE EN LA POSICION
		//INDICADA POR LA MISMA
		
		
		
		
		
		//llamo a repaint de todas mis cosas
		repaint();		
		
		
		
		
	}

	

}

