package graphicInterface;

import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import game.HighScores;
import game.Scores;
import guiControllers.MouseContrMenu;
import util.GameConstants;

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
	private String imgP="\\data\\MenuImages\\topScores.png";
	private Image i;
	private GridBagConstraints gbc= new GridBagConstraints();
	
	
	private HighScoresPanel()
	{
		loadImage();
		this.setLayout(new GridBagLayout());
		gbc.gridx=1;
		gbc.gridy=0;
		gbc.gridwidth=2;
		gbc.gridheight=2;
		gbc.fill= GridBagConstraints.BOTH;
		back.addMouseListener(new MouseContrMenu());
		this.add(back,gbc);
		model = new DefaultTableModel(completeTable(), headers);
		this.table.setModel(model);
		completeTable();
		/*
		for(Scores scores: HighScores.getInstance().getLovelyScores())
		{
			
			area1.setText("Score--> "+ scores);
		}
		*/
		gbc.gridx=1;
		gbc.gridy=3;
		gbc.gridwidth=2;
		gbc.gridheight=2;
		gbc.fill= GridBagConstraints.BOTH;
		this.add(table,gbc);
		this.setVisible(true);
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

	private void loadImage()
	{
		URL urlImg = getClass().getClassLoader().getResource(imgP);
		if (urlImg == null) {
			System.out.println("No se encuentra la imagen");
		} else {
			try {
				i = ImageIO.read(urlImg);

			} catch (IOException e) {
				System.out.println("dem");
				e.getStackTrace();
			}
		}
	}
	public static HighScoresPanel getInstance() {
		if (instance==null) {
			instance=new HighScoresPanel();
		}
		return instance;
	}

	@Override
	public void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		draw(g);
		
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		g.drawImage(i, 0, 0, GameConstants.WINDOW_WIDTH, GameConstants.WINDOW_HEIGHT, null);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		completeTable();
	}
	public static void main(String args[])
	{
		JFrame m= new JFrame();
		HighScoresPanel p= HighScoresPanel.getInstance();
		m.add(p);
		m.setSize(1080, 720);
		m.setVisible(true);
		
	}

}
