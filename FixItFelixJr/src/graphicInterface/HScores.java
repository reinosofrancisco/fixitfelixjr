package graphicInterface;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import game.HighScores;
import game.Scores;
import guiControllers.MouseContrMenu;
import util.GameConstants;

public class HScores  extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JButton back= new JButton("<<");
	private String s= "ACA IRIAN LOS HIGH SCORES GIL";
	private JTextArea area1= new JTextArea(s);
	
	public HScores()
	{
		this.setLayout(new GridLayout(2,1));
		back.setBounds(0, 0, 100, 100);
		back.addMouseListener(new MouseContrMenu());
		this.add(back, 0, 0);
		/*
		for(Scores scores: HighScores.getInstance().getLovelyScores())
		{
			
			area1.setText("Score--> "+ scores);
		}
		*/
		area1.setEditable(false);
		this.add(area1);
	}

}
