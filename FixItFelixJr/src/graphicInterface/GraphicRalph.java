package graphicInterface;

import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import entities.Ralph;
import util.Direction;

public class GraphicRalph extends JPanel{
	
	private String uBreaking1="data/game/ralph/breaking1.png";
	private String uBreaking2="data/game/ralph/breaking2.png";
	private String uBreaking3="data/game/ralph/breaking3.png";
	private String uBreaking4="data/game/ralph/breaking4.png";
	private String uBreaking5="data/game/ralph/breaking5.png";
	private String uBreaking6="data/game/ralph/breaking6.png";
	private String uBreaking7="data/game/ralph/breaking7.png";
	private String uBreaking8="data/game/ralph/breaking8.png";
	private String uMovingRight1= "data/game/ralph/movingRight1.png";
	private String uMovingRight2= "data/game/ralph/movingRight2.png";
	private String uQuiet="data/game/ralph/quiet.png";
	private String uMovingLeft1="data/game/ralph/movingLeft1.png";
	private String uWining="data/game/ralph/wining";
	private Image Breaking1;
	private Image Breaking2;
	private Image Breaking3;
	private Image Breaking4;
	private Image Breaking5;
	private Image Breaking6;
	private Image Breaking7;
	private Image Breaking8;
	private Image MovingRight1;
	private Image MovingRight2;
	private Image Quiet;
	private Image MovingLeft1;
	private Image Wining;
	private static GraphicRalph instance;
	private Image imgAct;
	private Direction dirAct;
	
	private GraphicRalph()
	{
		loadImage(uBreaking1, Breaking1);
		loadImage(uBreaking2, Breaking2);
		loadImage(uBreaking3, Breaking3);
		loadImage(uBreaking4, Breaking4);
		loadImage(uBreaking5, Breaking5);
		loadImage(uBreaking6, Breaking6);
		loadImage(uBreaking7, Breaking7);
		loadImage(uBreaking8, Breaking8);
		loadImage(uMovingRight1, MovingRight1);
		loadImage(uMovingRight2, MovingRight2);
		loadImage(uMovingLeft1, MovingLeft1);
		loadImage(uQuiet, Quiet);
		loadImage(uWining, Wining);
		setImgAct(Quiet);
		setDirAct(Direction.UNDIFINED);
	}
	
	public static GraphicRalph getInstance()
	{
		if(instance == null)
		{
			instance= new GraphicRalph();
		}
		return instance;
	}
	
	/**
	 * Carga una imagen
	 * @param url representa el path de la imagen
	 * @param i representa el objeto imagen en si
	 * si no puede leer la imagen imprime por pantalla
	 */
	private void loadImage(String url, Image i)
	{
		URL urlImg= getClass().getClassLoader().getResource(url);
		if(urlImg== null)
		{
			System.out.println("No se encuntra la imagen");
		}
		else
		{
			try 
			{
				
				i=(ImageIO.read(urlImg));
				
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
		
	}

	public Image getImgAct() {
		return imgAct;
	}

	public void setImgAct(Image imgAct) {
		this.imgAct = imgAct;
	}

	public Direction getDirAct() {
		return dirAct;
	}

	public void setDirAct(Direction dirAct) {
		this.dirAct = dirAct;
	}
	
	/**
	 * Va cambiando la imagen a medida que ralph se mueve 
	 */
	public void changeImgMove()
	{
		if(Ralph.getInstance().getDir() == Direction.RIGHT)
		{
			setImgAct(MovingRight1);
			pause();
			setImgAct(MovingRight2);
		}
		else 
		{
			if(Ralph.getInstance().getDir() == Direction.LEFT)
			{
				setImgAct(MovingLeft1);
			}
		}
	}
	
	/**
	 * Va cambiando las imagenes cuando Ralph rompe el edificio
	 */
	public void changeImgBreak()
	{
		setImgAct(Breaking1);
		pause();
		setImgAct(Breaking2);
		pause();
		setImgAct(Breaking3);
		pause();
		setImgAct(Breaking4);
		pause();
		setImgAct(Breaking5);
		pause();
		setImgAct(Breaking6);
		pause();
		setImgAct(Breaking7);
		pause();
		setImgAct(Breaking8);
		
	}
	
	/**
	 * Es el tiempo de espera entre imagen e imagen
	 */
	private void pause()
	{
		try {
			
			Thread.sleep(20);
		}
		catch(InterruptedException e)
		{
			e.printStackTrace();
		}
	}

}
