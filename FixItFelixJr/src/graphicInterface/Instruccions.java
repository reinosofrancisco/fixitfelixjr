package graphicInterface;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Instruccions extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String imageUrl= "graphicInterface/Image/fixItFelix.webp";
	private Image img;
	
	public Instruccions()
	{
		super("FixItFelix -Instrucciones");
		URL urlImg= getClass().getClassLoader().getResource(imageUrl);
		if(urlImg == null)
		{
			System.out.println("No se encuntra la imagen");
		}
		else
		{
			try {
				setImg(ImageIO.read(urlImg));
				
			}
			catch (IOException e)
			{
				e.getStackTrace();
			}
		}
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setSize(1000,1000);
		this.setVisible(true);
		this.dibujar();
		
	}

	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
	}
	
	public void paintConponent(Graphics g)
	{
		dibujar();
	}
	public void dibujar()
	{
		this.getGraphics().setColor(Color.RED);
		this.getGraphics().setFont(new Font(Font.DIALOG, Font.BOLD, 30));
		this.getGraphics().drawImage(img, 0, 0, 1000, 1000, null);
	}
	public static void main(String args[])
	{
		Instruccions i= new Instruccions();
	}
}
