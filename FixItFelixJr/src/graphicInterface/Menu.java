package graphicInterface;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

import guiControllers.MouseContGameWin;
import guiControllers.MouseContInstr;

public class Menu  extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton play= new JButton("¡A JUGAR!");
	private JButton instructions= new JButton("¿COMO JUGAR?");
	private JButton ranking= new JButton("TOP 5");
	
	/**
	 * El constructor instancia todas las cosas necesarias del Frame
	 */
	public Menu()
	{
		this.setLayout(new GridLayout(1, 3));
		this.play.addMouseListener(new MouseContGameWin());
		this.add(play);
		this.instructions.addMouseListener(new MouseContInstr());
		this.add(instructions);
		this.add(ranking);
		this.setSize(1000, 1000);
		this.setVisible(true);
	}
	
	
	
}
