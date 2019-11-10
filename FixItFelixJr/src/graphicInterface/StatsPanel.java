package graphicInterface;

import java.awt.Graphics;
import java.awt.Image;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import guiControllers.MouseContrMenu;
import util.GameConstants;

public class StatsPanel extends GenericWindowPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FileInputStream f;
	private BufferedReader br;
	private int[] statsR= new int[3];
	private int[] statsA= new int[3];
	private static StatsPanel instance;
	private JTextArea area1= new JTextArea();
	private String[] s= {"La cantidad de veces que se ejecuto la Aplicacion es: ", "La cantidad de veces que se clickeo el QUIERO JUGAR es: ", "La cantidad de ganadores a lo largo del timepo es: "};
	private JButton back= new JButton("<<");
	private Image i;
	private String imgP="data\\MenuImages\\stats.jpg";
	private StatsPanel() throws IOException
	{
		loadImage();
//		readFile();
//		addToArea();
//		this.add(area1);
		back.addMouseListener(new MouseContrMenu());
		this.add(back);
//		this.setVisible(false);
	}

	private void readFile() {
		try
		{
			f=new FileInputStream("C:\\Users\\jeron\\Documents\\GitHub\\fixitfelixjr\\FixItFelixJr\\src\\game\\Archivos\\Stats.txt");
			br= new BufferedReader(new InputStreamReader(f));
		}
		catch(FileNotFoundException e)
		{
			System.out.println("Error al abrir el archivo");
		}
		String lnRead;
		int i=0;
		statsA= MainGameWindow.getInstance().getStats();
		try {
			while((lnRead= br.readLine()) != null)
			{
				statsR[i]= Integer.parseInt(lnRead);
				i++;
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(i=0;i<statsA.length;i++)
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
			try
			{
				instance= new StatsPanel();
			}
			catch(IOException e)
			{
				System.out.println("Error en la instancia");
			}
			
		}
		return instance;
	}

	private void loadImage()
	{
		URL urlImg = getClass().getClassLoader().getResource(imgP);
		if (urlImg == null) {
			System.out.println("No se encuentra la imagen");
		} else {
			try {
				this.i = ImageIO.read(urlImg);

			} catch (IOException e) {
				System.out.println("dem");
				e.getStackTrace();
			}
		}
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
		
	}
	
}
