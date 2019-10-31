package graphicInterface;


import javax.swing.JButton;
import javax.swing.JPanel;

import guiControllers.KeyL;
import guiControllers.MouseContrMenu;

public class GameWindow extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton back= new JButton("<<");
	
	public GameWindow()
	{
		back.setBounds(0, 0, 100, 100);
		back.addMouseListener(new MouseContrMenu());
		this.add(back, 0, 0);
		this.addKeyListener(new KeyL());
		this.setSize(200, 200);
	}
	

}

