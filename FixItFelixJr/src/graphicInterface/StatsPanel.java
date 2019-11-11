package graphicInterface;

import java.awt.Component;
import java.awt.Container;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.table.DefaultTableModel;

import graphicInterface.utils.ImageHashLoader;
import guiControllers.MouseContrMenu;
import util.GameConstants;
import util.ResourcePathConstants;

public class StatsPanel extends GenericWindowPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final int WIDTH = 500;
	private static final int HEIGHT = 500;
	
	
	private int[] statsR= new int[3];
	private int[] statsA= new int[3];
	private static StatsPanel instance;
	private JTextArea area1= new JTextArea();
	private String[] s= {"La cantidad de veces que se ejecuto la Aplicacion es: ", "La cantidad de veces que se clickeo el QUIERO JUGAR es: ", "La cantidad de ganadores a lo largo del timepo es: "};
	private JButton back= new JButton("Volver al menu");
	private GridBagConstraints gbc=new GridBagConstraints();
	private Image i;
	
	
	
	private StatsPanel()
	{
		super(WIDTH,HEIGHT);
		i=ImageHashLoader.getImages().get(ResourcePathConstants.STATS_BG_S);
		this.setLayout(new GridBagLayout());
		
		
		
		gbc.fill= GridBagConstraints.BOTH;
		gbc.weightx=1.0;
		
		//BACK
		gbc.weighty=0.1;
		gbc.insets=new Insets(0,100,0,100);
		addGB(this, back, 0, 0);
		back.addMouseListener(new MouseContrMenu());
		
		
		// TABLE
		gbc.weighty = 1.0;
		gbc.insets = new Insets(110, 50, 50, 50);
		addGB(this, new JScrollPane(new JTextArea("EEEEEEEEEEEEEEEEEEEEEEEEEE\nEEEEEE\nEEEEEEE\nEEEEEEEEEEE\nEEEEEEEEEEEEEEE\nEEEEEEEE")), 0, 2);
		
		
//		readFile();
//		addToArea();
//		this.add(area1);
	}
	
	
	
	void addGB(Container cont, Component comp, int x, int y) {
		gbc.gridx = x;
		gbc.gridy = y;
		cont.add(comp, gbc);
	}	

	private void readFile() {
		ObjectInputStream input;
		try
		{
			FileInputStream fi=new FileInputStream(new File("src/data/stats/stats.dat"));
			input = new ObjectInputStream(fi);
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Error al abrir el archivo");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i=0;i<statsA.length;i++)
		{
			statsA[i]+= statsR[i];
		}
	}
	private void addToArea()
	{
		int i;
		for(i=0;i<statsA.length;i++)
		{
			String add= s[i];
			add+=statsA[i];
			area1.setText(add);
		}
	}
	
	public static StatsPanel getInstance()
	{
		if(instance == null)
		{
			instance=new StatsPanel();
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
		// TODO Auto-generated method stub
		
	}
	
}
