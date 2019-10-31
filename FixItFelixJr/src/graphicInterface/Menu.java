package graphicInterface;

import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Menu  extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton play= new JButton("¡A JUGAR!");
	private JButton instruccions= new JButton("¿COMO JUGAR?");
	private JButton ranking= new JButton("TOP 5");
	
	/**
	 * El constructor instancia todas las cosas necesarias del Frame
	 */
	public Menu()
	{
		this.setLayout(new GridLayout(1, 3));
		this.add(play);
		this.add(instruccions);
		this.add(ranking);
		this.setSize(1000, 1000);
		this.setVisible(true);
	}
	
	
	
}
