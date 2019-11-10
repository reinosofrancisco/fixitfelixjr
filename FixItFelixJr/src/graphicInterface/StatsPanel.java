package graphicInterface;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;

import guiControllers.MouseContrMenu;

public class StatsPanel extends JPanel
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
	private StatsPanel() throws IOException
	{
//		readFile();
//		addToArea();
//		this.add(area1);
//		back.addMouseListener(new MouseContrMenu());
//		this.add(back);
//		this.setVisible(false);
	}

	private void readFile() {
		try
		{
			f=new FileInputStream("/game/Archivos/Stats.txt");
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
	
}
