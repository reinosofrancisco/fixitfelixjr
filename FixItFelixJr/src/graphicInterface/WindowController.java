package graphicInterface;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

//import gamemain.GameStarter;
import util.GameConstants;

public class WindowController extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GenericWindowPanel menu= MenuWindow.getInstance();
	private GenericWindowPanel instr= InstructionsWindow.getInstance();
	private GenericWindowPanel gameW= GameWindow.getInstance();
	private GenericWindowPanel hScores= HighScoresWindow.getInstance();
	private static WindowController instance;
	
	private WindowController()
	{
		super("Fix It FelixJr");
		//
		this.setSize(GameConstants.WINDOW_WIDTH, GameConstants.WINDOW_HEIGHT);
		this.add(menu);
		this.add(instr);
		this.add(gameW);
		this.add(hScores);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setResizable(false);
		this.menu.setVisible(true);
		this.addWindowListener(new WindowAdapter() {
			
			
			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				salir();
			}
			
		});
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

	
	private void salir()
	{
		int opt= JOptionPane.showConfirmDialog(new JButton(), "Si sale se perderan sus datos, desea salir??", "Salva", JOptionPane.YES_NO_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE);
		if(opt == JOptionPane.YES_OPTION)
		{
			System.exit(0);
		}
	}
	public static void main(String[] args)
	{
		WindowController.getInstance().setVisible(true);
	}
}
