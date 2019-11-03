package graphicInterface;

import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;

import util.Direction;

public class GraphicFelix {
	
	private String uQuiet= "data.game.felix/quiet.png";
	private String uMovingLeft="data.game.felix/movingLeft.png";
	private String uCantMoveLeft= "data.game.felix/cantMoveLeft.png";
	private String uFixing1Left= "data.game.felix/fixing1Left.png";
	private String uFixing2Left= "data.game.felix/fixing2Left.png";
	private String uWithCakeLeft= "data.game.felix/withCakeLeft.png";
	private String uEatingCakeLeft="data.game.felix/eatingCakeLeft.png";
	private String uWining1= "data.game.felix/wining1.png";
	private String uWining2= "data.game.felix/wining2.png";
	private String uWining3= "data.game.felix/wining3.png";
	private String uColitionLeft="data.game.felix/colitionLeft.png";
	private String uStart= "data.game.felix/start.png";
	private String uMovingRigth="data.game.felix/movingRight.png";
	private String uCantMoveRight= "data.game.felix/cantMoveRight.png";
	private String uFixing1Right="data.game.felix/fixing1Right";
	private String uFixing2Right="data.game.felix/fixing2Right";
	private String uColitionRight="data.game.felix/colitionRight";
	private String uEatingCakeRight="data.game.felix/eatingCakeRight.png";
	private String uFalling="data.game.felix/faling.png";
	private Image Quiet;
	private Image MovingLeft;
	private Image CantMoveLeft;
	private Image Fixing1Left;
	private Image Fixing2Left;
	private Image WithCakeLeft;
	private Image EatingCakeLeft;
	private Image Wining1;
	private Image Wining2;
	private Image Wining3;
	private Image ColitionLeft;
	private Image Start;
	private Image MovingRigth;
	private Image CantMoveRight;
	private Image Fixing1Right;
	private Image Fixing2Right;
	private Image ColitionRight;
	private Image EatingCakeRight;
	private Image Falling;
	private static GraphicFelix instance;
	private Image actual;
	
	private GraphicFelix()
	{
		loadImage(uQuiet, Quiet);
		loadImage(uMovingLeft, MovingLeft);
		loadImage(uCantMoveLeft, CantMoveLeft);
		loadImage(uFixing1Left, Fixing1Left);
		loadImage(uFixing2Left, Fixing2Left);
		loadImage(uWithCakeLeft, WithCakeLeft);
		loadImage(uEatingCakeLeft, EatingCakeLeft);
		loadImage(uWining1, Wining1);
		loadImage(uWining2, Wining2);
		loadImage(uWining3, Wining3);
		loadImage(uColitionLeft, ColitionLeft);
		loadImage(uStart, Start);
		loadImage(uMovingRigth, MovingRigth);
		loadImage(uCantMoveRight, CantMoveRight);
		loadImage(uFixing1Right, Fixing1Right);
		loadImage(uFixing2Right, Fixing2Right);
		loadImage(uColitionRight, ColitionRight);
		loadImage(uEatingCakeRight, EatingCakeRight);
		loadImage(uFalling, Falling);
		setActual(Start);
		
	}
	
	public static GraphicFelix getInstance()
	{
		if(instance == null)
		{
			instance= new GraphicFelix();
		}
		return instance;
	}
	
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

	public Image getActual() {
		return actual;
	}

	public void setActual(Image actual) {
		this.actual = actual;
	}
	
	/**
	 *  Cambia de imagen respecto a la direccion que se quiere mover felix
	 * @param d define la direccion en la que hay que cambiar la foto
	 */
	public void changeImgMove(Direction d )
	{
		if(d == Direction.LEFT)
		{
			setActual(MovingLeft);
		}
		else
		{
			if(d== Direction.RIGHT)
			{
				setActual(MovingRigth);	
			}
			else setActual(Quiet);
			
		}
	}
	/**
	 * Cambia la imagen de felix a arreglar
	 * 
	 */
	public void changeImgFix()
	{
		
	}

}
