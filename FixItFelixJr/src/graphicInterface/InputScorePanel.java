package graphicInterface;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import guiControllers.MouseContInputHS;
public class InputScorePanel extends JPanel{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//TODO singletone
	private JLabel inputN= new JLabel("Ingrese su nombre: ");
	private JTextField area1= new JTextField(100);
	private JButton send= new JButton("Enviar");
	private static InputScorePanel instance;
	
	private InputScorePanel()
	{
		this.add(inputN);
		this.add(area1);
		send.addMouseListener(new MouseContInputHS());
		this.add(send);
	}
	
	public static InputScorePanel getInstance()
	{
		if(instance == null)
		{
			instance= new InputScorePanel();
		}
		return instance;
	}

	public JTextField getArea1() {
		return area1;
	}

	public void setArea1(JTextField area1) {
		this.area1 = area1;
	}

}
