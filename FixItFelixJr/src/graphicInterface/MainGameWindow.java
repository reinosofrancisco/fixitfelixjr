	package graphicInterface;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import game.HighScores;
import game.Stats;
import graphicInterface.utils.GraphicsGame;
import guiControllers.KeyL;
//import gamemain.GameStarter;
import util.GameConstants;

public class MainGameWindow extends JFrame {
	
	
	
	
	private static final long serialVersionUID = 1L;
	private GenericWindowPanel menu= MenuPanel.getInstance();
	private GenericWindowPanel instr= InstructionsPanel.getInstance();
	private GenericWindowPanel gameW= GamePanel.getInstance();
	private HighScoresPanel hScores= HighScoresPanel.getInstance();
	private ConfigurePanel config= ConfigurePanel.getInstance();
	private StatsPanel stat= StatsPanel.getInstance();
	private InputScorePanel inputHs= InputScorePanel.getInstance();
	private KeyL keyListener=new KeyL();
	private static MainGameWindow instance;
	
	private MainGameWindow()
	{
		super("Fix It FelixJr");
		//
		this.setSize(GameConstants.WINDOW_WIDTH, GameConstants.WINDOW_HEIGHT);
		this.add(menu);
		this.add(instr);
		this.add(gameW);
		this.add(hScores);
		this.add(config);
		this.add(stat);
		this.add(inputHs);
		this.addKeyListener(keyListener);
		this.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
		this.setResizable(false);
		changeMenu();
		this.addWindowListener(new WindowAdapter() {
			
			
			@Override
			public void windowClosing(WindowEvent e) {
				salir();
			}
			
		});
		
	}
	
	public static MainGameWindow getInstance()
	{
		if(instance == null)
		{
			instance=new MainGameWindow();
		}
		return instance;
	}
	
	/**
	 * Desactiva todas las ventanas
	 */
	private void deactivateAll() {
		menu.setVisible(false);
		hScores.setVisible(false);
		gameW.setVisible(false);
		config.setVisible(false);
		stat.setVisible(false);
		instr.setVisible(false);
		inputHs.setVisible(false);
		this.setFocusable(false);
	}
	
	/**
	 * Secuencia de activacion de panel
	 * @param p panel a activar
	 */
	private void activate(GenericWindowPanel p) {
		deactivateAll();
		setSize(p.getSize());
		p.setVisible(true);
	}
	
	/**
	 * Cambia a la pantalla del juego--->ANDA
	 */
	public  void changeGameWin()
	{
		Stats.incrementTimesPressedPlay();
		activate(gameW);
		this.setFocusable(true);
		requestFocus();
	}
	

	/**
	 * Cambia a la pantalla de las instrucciones--->ANDA
	 */
	public void changeInstr() {
		activate(instr);
	}
	
 /**
  * Cambia la pantalla de nuevo al menu--->Anda
  * 
  */
	public void changeMenu()
	{
		activate(menu);
	}
	
	public void changeRank()
	{
		activate(hScores);
	}
	

	public void changeConfig()
	{
		activate(config);
	}
	public void changeStat()
	{
		activate(stat);
	}
	
	private void salir()
	{
		int opt= JOptionPane.showConfirmDialog(new JButton(), "Si sale se perderan sus datos, desea salir??", "Salva", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
		if(opt == JOptionPane.YES_OPTION)
		{
			HighScores.getInstance().savePersistentScore(); //BORRAR DESPUES
			Stats.savePersistentScore();
			System.exit(0);
		}
	}
	public static void main(String[] args)
	{
		MainGameWindow.getInstance().setVisible(true);
		
	}

	public void changeInputScore()
	{
		activate(inputHs);
	}
	public void update() {
		if (gameW.isEnabled()) {
			GraphicsGame.getInstance().update(); 
			repaint();
		}
		
	}
}
