package graphicInterface;

import java.awt.Choice;
import java.awt.Graphics;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ConfigurePanel extends JPanel {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//TODO singletone
	private JLabel selection= new JLabel("Selecccione la dificultad");
	private Choice dificulty= new Choice();
	private static ConfigurePanel instance;
	
	private ConfigurePanel()
	{
		this.add(selection);
		completChoice();
		this.add(dificulty);
	}
	
	public static ConfigurePanel getInstance()
	{
		if(instance== null)
		{
			instance= new ConfigurePanel();
		}
		return instance;
	}
	
	
	private void completChoice()
	{
		int i;
		for(i=0;i<10;i++)
		{
			dificulty.add( ""+(i+1));
			
		}
	}

}
