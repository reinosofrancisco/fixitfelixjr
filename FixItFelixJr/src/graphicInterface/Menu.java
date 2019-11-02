package graphicInterface;

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import guiControllers.MouseContGameWin;
import guiControllers.MouseContInstr;
import guiControllers.MouseContRank;
import util.GameConstants;
import util.ResourcePathConstants;

public class Menu  extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton play= new JButton("¡A JUGAR!");
	private JButton instructions= new JButton("¿COMO JUGAR?");
	private JButton ranking= new JButton("TOP 5");
	private JButton config= new JButton(new ImageIcon(ResourcePathConstants.CONFIG));
	
	/**
	 * El constructor instancia todas las cosas necesarias del Frame
	 */
	public Menu()
	{
		this.setLayout(new GridBagLayout());
		this.play.addMouseListener(new MouseContGameWin());
		GridBagConstraints c1= new GridBagConstraints();
		c1.gridx= 1;
		c1.gridy= 1;
		this.add(play, c1);
		this.instructions.addMouseListener(new MouseContInstr());
		GridBagConstraints c2= new GridBagConstraints();
		c2.gridx=0;
		c1.gridy=1;
		this.add(instructions,c2);
		this.ranking.addMouseListener(new MouseContRank());
		GridBagConstraints c3= new GridBagConstraints();
		c3.gridx=2;
		c3.gridy=1;
		this.add(ranking,c3);
	    //this.config.addMouseListener();
		GridBagConstraints c4= new GridBagConstraints();
		c4.gridx=2;
		c4.gridy=0;
		this.add(config, c4);
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
