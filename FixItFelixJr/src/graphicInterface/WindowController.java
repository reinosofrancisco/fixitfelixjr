package graphicInterface;

import javax.swing.JFrame;

import util.GameConstants;

public class WindowController extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private  Menu menu= new Menu();
	private  Instructions instr= new Instructions();
	private  GameWindow gameW= new GameWindow();
	private HScores hScores= new HScores();
	private static WindowController instance;
	
	private WindowController()
	{
		super("Fix It FelixJr");
		this.setSize(GameConstants.WINDOW_WIDTH, GameConstants.WINDOW_HEIGHT);
		this.add(menu);
		this.add(instr);
		this.add(gameW);
		this.add(hScores);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);
		this.menu.setVisible(true);
	}
	
	public static WindowController getInstance()
	{
		if(instance == null)
		{
			instance=new WindowController();
		}
		return instance;
	}
	/**
	 * Cambia a la pantalla del juego
	 */
	public  void changeGameWin()
	{
		instr.setVisible(false);
		menu.setVisible(false);
		hScores.setVisible(false);
		gameW.setVisible(true);
	}
	
	/**
	 * Cambia a la pantalla de las instrucciones
	 */
	public void changeInstr() {
		
		menu.setVisible(false);
		hScores.setVisible(false);
		gameW.setVisible(false);
		instr.setVisible(true);
	}
	
 /**
  * Cambia la pantalla de nuevo al menu
  * 
  */
	public void changeMenu()
	{
		gameW.setVisible(false);
		instr.setVisible(false);
		hScores.setVisible(false);
		menu.setVisible(true);
	}
	
	public void changeRank()
	{
		gameW.setVisible(false);
		instr.setVisible(false);
		menu.setVisible(false);
		hScores.setVisible(true);
	}
	
	public static void main(String[] args)
	{
		WindowController.getInstance().setVisible(true);
	}
}
