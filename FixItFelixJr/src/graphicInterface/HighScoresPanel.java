package graphicInterface;

import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import java.awt.Image;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import game.HighScores;
import game.Scores;
import graphicInterface.utils.ImageHashLoader;
import guiControllers.MouseContrMenu;
import util.ResourcePathConstants;

public class HighScoresPanel  extends GenericWindowPanel{

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private static final int WIDTH = 600;
	private static final int HEIGHT = 300;
	private static HighScoresPanel instance;


	private JButton back= new JButton("Volver al Menu");
	private JTable table= new JTable();
	private Object [] headers= {"Posicion","Nombre", "Puntos"};
	private DefaultTableModel model;
	private Image i;
	private GridBagConstraints gbc= new GridBagConstraints();


	private HighScoresPanel()
	{
		super(WIDTH,HEIGHT);
		i=ImageHashLoader.getImages().get(ResourcePathConstants.TOPSCORES_BG_S);
		this.setLayout(new GridBagLayout());



		gbc.fill= GridBagConstraints.BOTH;
		gbc.weightx=1.0;

		//BACK
		gbc.weighty=0.1;
		gbc.insets=new Insets(0,100,0,100);
		addGB(this, back, 0, 0);
		back.addMouseListener(new MouseContrMenu());


		//TABLE
		gbc.weighty=1.0;
		gbc.insets=new Insets(110, 50, 50, 50);
		addGB(this, new JScrollPane(table), 0, 2);
		add();
	}



	private void add() {
		model = new MyTableModel(headers,0);
		table.setModel(model);
		table.setAutoResizeMode(JTable.AUTO_RESIZE_ALL_COLUMNS);
		table.setEditingColumn(0);
		table.setEditingRow(0);
		int i=0;
		for (Scores s : HighScores.getInstance().getScoreList()) {
			i++;
			model.addRow(new String[] {""+i,s.getName(),""+s.getPoints()});
		}
	}



	void addGB(Container cont, Component comp, int x, int y) {
		gbc.gridx = x;
		gbc.gridy = y;
		cont.add(comp, gbc);
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
		g.drawImage(i, 0, 0, WIDTH, HEIGHT, null);
	}

	@Override
	public void update() {
		add();
		repaint();
	}


}
