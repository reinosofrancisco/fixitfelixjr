package graphicInterface;

import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import game.HighScores;
import game.Scores;
import guiControllers.MouseContrMenu;

public class HighScoresPanel  extends GenericWindowPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static HighScoresPanel instance;
	
	
	private JButton back= new JButton("<<");
	private JTable table= new JTable();
	private Object [] headers= {"Posicion","Nombre", "Puntos"};
	private DefaultTableModel model;
	
	
	
	private HighScoresPanel()
	{
		this.setLayout(new GridLayout(2,1));
		back.setBounds(0, 0, 100, 100);
		back.addMouseListener(new MouseContrMenu());
		this.add(back, 0, 0);
		model = new DefaultTableModel(completeTable(), headers);
		this.table.setModel(model);
		
		/*
		for(Scores scores: HighScores.getInstance().getLovelyScores())
		{
			
			area1.setText("Score--> "+ scores);
		}
		*/
		this.add(table);
		setVisible(false);
	}
	
	private Object[][] completeTable() {
		if( HighScores.getInstance().getScoreList() != null)
		{
			int f=0, c=0, p=1;
			Object[][] datos= new Object[5][3];
			for(Scores i: HighScores.getInstance().getScoreList())
			{
				datos[f][c]= p;
				datos[f][c+1]= i.getName();
				datos[f][c+2]= i.getPoints();
				f++;
				p++;
			}
			return datos;
		}
		return null;
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
