package graphicInterface;

import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JTextArea;
import guiControllers.MouseContrMenu;

public class HighScoresPanel  extends GenericWindowPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static HighScoresPanel instance;
	
	
	private JButton back= new JButton("<<");
	private String s= "ACA IRIAN LOS HIGH SCORES G.I.L. (Genie Idole Leal)";
	private JTextArea area1= new JTextArea(s);
	
	
	
	
	private HighScoresPanel()
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
		setVisible(false);
	}
	
	public static HighScoresPanel getInstance() {
		if (instance==null) {
			instance=new HighScoresPanel();
		}
		return instance;
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		draw(g);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	

}
