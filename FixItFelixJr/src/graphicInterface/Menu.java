package graphicInterface;


import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import guiControllers.MouseContGameWin;
import guiControllers.MouseContInstr;
import guiControllers.MouseContRank;
import util.GameConstants;


public class Menu  extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton play= new JButton("¡A JUGAR!");
	private JButton instructions= new JButton("¿COMO JUGAR?");
	private JButton ranking= new JButton("TOP 5");
	private JButton config= new JButton("Config");
	private JButton stats= new JButton("Estadisticas");
	private GridBagConstraints cont= new GridBagConstraints();
	
	/**
	 * El constructor instancia todas las cosas necesarias del Frame
	 */
	public Menu()
	{
		this.setLayout(new GridBagLayout());
		//this.stats.addMouseListener(new MouseContGameWin());
		cont.gridx=0;
		cont.gridy=0;
		this.add(stats, cont);
		cont.gridx=2;
		this.add(config, cont);
		this.instructions.addMouseListener(new MouseContInstr());
		cont.gridx=0;
		cont.gridy=8;
		this.add(instructions, cont);
		this.play.addMouseListener(new MouseContGameWin());
		cont.gridx=1;
		cont.gridy=8;
		this.add(play,cont);
		this.ranking.addMouseListener(new MouseContRank());
		cont.gridx=2;
		cont.gridy=8;
		this.add(ranking,cont);
		this.setSize(GameConstants.WINDOW_WIDTH, GameConstants.WINDOW_HEIGHT);
	}
	
	public static void main(String args[]) {
		
		JFrame m= new JFrame();
		Menu me= new Menu();
		m.add(me);
		m.setSize(GameConstants.WINDOW_WIDTH, GameConstants.WINDOW_HEIGHT);
		m.setVisible(true);
	}
	
}
