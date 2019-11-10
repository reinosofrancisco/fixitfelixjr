package graphicInterface;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import graphicInterface.utils.GraphicsGame;
//import gamemain.GameStarter;
import util.GameConstants;

public class MainGameWindow extends JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private GenericWindowPanel menu= MenuPanel.getInstance();
	private GenericWindowPanel instr= InstructionsPanel.getInstance();
	private GenericWindowPanel gameW= GamePanel.getInstance();
	private HighScoresPanel hScores= HighScoresPanel.getInstance();
	private ConfigurePanel config= ConfigurePanel.getInstance();
	private StatsPanel stat= StatsPanel.getInstance();
	/**
	 * En la pos 0 del arreglo se va a guardar la cantidad de veces que se ejecuto la aplicacion
	 * En la pos 1 la cantidad de veces que se clickeo el boton de jugar
	 * Y en la pos 2 la cantidad de veces que se agrego un HS
	 */
	private int[] stats= new int[3];
	private static MainGameWindow instance;
	
	private MainGameWindow()
	{
		super("Fix It FelixJr");
		//
		inicializationArre();
		stats[0]++;
		this.setSize(GameConstants.WINDOW_WIDTH, GameConstants.WINDOW_HEIGHT);
		this.add(menu);
		this.add(instr);
		this.add(gameW);
		this.add(hScores);
		this.add(config);
		this.add(stat);
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
	
	public static MainGameWindow getInstance()
	{
		if(instance == null)
		{
			instance=new MainGameWindow();
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
		//stat.setVisible(false);
		stats[1]++;
		gameW.setVisible(true);
		
	}
	
	/**
	 * Cambia a la pantalla de las instrucciones
	 */
	public void changeInstr() {
		
		menu.setVisible(false);
		hScores.setVisible(false);
		gameW.setVisible(false);
		config.setVisible(false);
		//stat.setVisible(false);
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
		config.setVisible(false);
		menu.setVisible(true);
	}
	
	public void changeRank()
	{
		gameW.setVisible(false);
		instr.setVisible(false);
		menu.setVisible(false);
		config.setVisible(false);
		stat.setVisible(false);
		hScores.setVisible(true);
	}
	
	public void changeConfig()
	{
		gameW.setVisible(false);
		instr.setVisible(false);
		menu.setVisible(false);
		hScores.setVisible(false);
		stat.setVisible(false);
		config.setVisible(true);
	}
	public void changeStat()
	{
		gameW.setVisible(false);
		instr.setVisible(false);
		menu.setVisible(false);
		hScores.setVisible(false);
		config.setVisible(false);
		stat.setVisible(true);
	}

	
	private void salir()
	{
		int opt= JOptionPane.showConfirmDialog(new JButton(), "Si sale se perderan sus datos, desea salir??", "Salva", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
		if(opt == JOptionPane.YES_OPTION)
		{
			System.exit(0);
		}
	}
	public static void main(String[] args)
	{
		MainGameWindow.getInstance().setVisible(true);
		
	}

	public void update() {
		if (gameW.isEnabled()) {
			GraphicsGame.getInstance().update();
			repaint();			
		}
		
		
		//TODO
			
	}

	private void inicializationArre()
	{
		int i;
		for(i=0;i<stats.length;i++)
		{
			stats[i]=0;
		}
	}
	public int[] getStats() {
		return stats;
	}

	public void setStats(int[] stats) {
		this.stats = stats;
	}
	
}
