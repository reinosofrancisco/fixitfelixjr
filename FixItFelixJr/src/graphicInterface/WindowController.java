package graphicInterface;

import javax.swing.JFrame;

import util.GameConstants;

public class WindowController extends JFrame {
	
	private  Menu menu= new Menu();
	private  Instructions instr= new Instructions();
	private  GameWindow gameW= new GameWindow();
	private static WindowController instance= new WindowController();
	
	private WindowController()
	{
		this.setSize(GameConstants.WINDOW_WEI, height);
	}
	
	public static WindowController getInstance()
	{
		return instance;
	}
	/**
	 * Cambia a la pantalla del juego
	 */
	public  void changeGameWin()
	{
		instr.setVisible(false);
		menu.setVisible(false);
		gameW.setVisible(true);
	}
	
	/**
	 * Cambia a la pantalla de las instrucciones
	 */
	public void changeInstr() {
		
		menu.setVisible(false);
		gameW.setVisible(false);
		instr.setVisible(true);
	}
	
}
