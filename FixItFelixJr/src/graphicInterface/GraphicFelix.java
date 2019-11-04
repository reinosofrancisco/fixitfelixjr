package graphicInterface;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

import building.Building;
import entities.Felix;
import game.Core;
import util.Direction;
import util.GameConstants;

public class GraphicFelix extends JPanel{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String uQuiet= "data/game/felix/quiet.png";
	private String uMovingLeft="data/game/felix/movingLeft.png";
	private String uCantMoveLeft= "data/game/felix/cantMoveLeft.png";
	private String uFixing1Left= "data/game/felix/fixing1Left.png";
	private String uFixing2Left= "data/game/felix/fixing2Left.png";
	private String uWithCakeLeft= "data/game/felix/withCakeLeft.png";
	private String uEatingCakeLeft="data/game/felix/eatingCakeLeft.png";
	private String uWining1= "data/game/felix/wining1.png";
	private String uWining2= "data/game/felix/wining2.png";
	private String uWining3= "data/game/felix/wining3.png";
	private String uColitionLeft="data/game/felix/colitionLeft.png";
	private String uStart= "data/game/felix/start.png";
	private String uMovingRigth="data/game/felix/movingRight.png";
	private String uCantMoveRight= "data/game/felix/cantMoveRight.png";
	private String uFixing1Right="data/game/felix/fixing1Right";
	private String uFixing2Right="data/game/felix/fixing2Right";
	private String uColitionRight="data/game/felix/colitionRight";
	private String uWithCakeRight= "data/game/felix/withCakeRight.png";
	private String uEatingCakeRight="data/game/felix/eatingCakeRight.png";
	private String uFalling="data/game/felix/faling.png";
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
	private Image WithCakeRight;
	private Image EatingCakeRight;
	private Image Falling;
	private static GraphicFelix instance;
	private Image imgAct;
	private Direction dirAct;
	
	private GraphicFelix()
	{
		Quiet=loadImage(uQuiet);
		MovingLeft=loadImage(uMovingLeft);
		CantMoveLeft=loadImage(uCantMoveLeft);
		Fixing1Left=loadImage(uFixing1Left );
		Fixing2Left=loadImage(uFixing2Left );
		WithCakeLeft=loadImage(uWithCakeLeft );
		EatingCakeLeft=loadImage(uEatingCakeLeft );
		Wining1=loadImage(uWining1 );
		Wining2=loadImage(uWining2);
		Wining3=loadImage(uWining3 );
		ColitionLeft=loadImage(uColitionLeft );
		Start=loadImage(uStart );
		MovingRigth=loadImage(uMovingRigth );
		CantMoveRight=loadImage(uCantMoveRight );
		Fixing1Right=loadImage(uFixing1Right );
		Fixing2Right=loadImage(uFixing2Right );
		ColitionRight=loadImage(uColitionRight );
		WithCakeRight=loadImage(uWithCakeRight );
		EatingCakeRight=loadImage(uEatingCakeRight );
		Falling=loadImage(uFalling );
		setImgActual(Start);
		setDirAct(Direction.UNDIFINED);
		
	}
	
	public static GraphicFelix getInstance()
	{
		if(instance == null)
		{
			instance= new GraphicFelix();
		}
		return instance;
	}
	
	/**
	 *  Carga una imagen
	 * @param url representa el path de la imagen
	 * @param i representa el objeto imagen
	 * 	Si la imagen no se encuentra muestra un aviso en pantalla
	 */
	
	private Image loadImage(String url)
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
				
				 return (ImageIO.read(urlImg));
				
			}
			catch(IOException e)
			{
				e.printStackTrace();
			}
		}
		return null;
		
	}

	public Image getImgActual() {
		return imgAct;
	}

	public void setImgActual(Image actual) {
		this.imgAct = actual;
	}
	
	/**
	 *  Cambia de imagen respecto a la direccion que se quiere mover felix
	 * @param d define la direccion en la que hay que cambiar la foto
	 */
	public void changeImgMove(Direction d )
	{
		if(d == Direction.LEFT)
		{
			setImgActual(MovingLeft);
			setDirAct(Direction.LEFT);
		}
		else
		{
			if(d== Direction.RIGHT)
			{
				setImgActual(MovingRigth);	
				setDirAct(Direction.RIGHT);
			}	
		}
	}
	/**
	 * Cambia la imagen de felix a arreglar
	 * 
	 */
	public void changeImgFix()
	{
		if(dirAct == Direction.RIGHT)
		{
			setImgActual(Fixing1Right);
			pause();
			setImgActual(Fixing2Right);
		}
		else
		{
			if(dirAct == Direction.LEFT)
			{
				setImgActual(Fixing1Left);
				pause();
				setImgActual(Fixing2Left);
			}
		}
	}
	
	/**
	 * Cambia la imagen de Felix cuando choca con un pajaro o ladrillo
	 */
	
	public void changeImgColition()
	{
		if(Core.getInstance().isColliding())
		{
			if(dirAct == Direction.LEFT)
			{
				setImgActual(ColitionLeft);
				pause();
				setImgActual(Falling);
				
			}
			else
			{
				if(dirAct == Direction.RIGHT)
				{
					setImgActual(ColitionRight);
					pause();
					setImgActual(Falling);
				}
			}
		}
		
		
	}
	
	/**
	 * Cambia la imagen de Felix caundo como una torta
	 */
	public void changeImgCake()
	{
		if(Building.getInstance().isFelixWitCake())
		{
			if(dirAct == Direction.RIGHT)
			{
				setImgActual(WithCakeRight);
				pause();
				setImgActual(EatingCakeRight);
			}
			else
			{
				if(dirAct == Direction.LEFT)
				{
					setImgActual(WithCakeLeft);
					pause();
					setImgActual(EatingCakeLeft);
				}
			}
			
		}
	}
	
	/**
	 * Es el tiempo de espera entre una imagen y otra
	 */
	public void pause()
	{
		try {
			Thread.sleep(20);
		}
		catch(InterruptedException e){
			
			e.printStackTrace();
			
		}
	}
	public void update()
	{
		changeImgColition();
	}

	public Direction getDirAct() {
		return dirAct;
	}

	public void setDirAct(Direction dirAct) {
		this.dirAct = dirAct;
	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		draw(g);
		
	}
	
	public void draw(Graphics g)
	{
		g.setFont(new Font(Font.DIALOG, Font.BOLD, 30));
		g.drawImage(imgAct, Felix.getInstnance().getVector2D().getPosx(), Felix.getInstnance().getVector2D().getPosy(), 29, 52, null);
	}
	
	public static void main(String args[])
	{
		Felix f= Felix.getInstnance();
		GraphicFelix fe= GraphicFelix.getInstance();
		JFrame j= new JFrame();
		j.getContentPane().add(fe);
		f.move(Direction.UP);
		j.setSize(500, 500);
		j.setVisible(true);
	}
}
