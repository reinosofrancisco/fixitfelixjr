package graphicInterface;

import java.awt.Image;
import java.util.Hashtable;
import java.util.LinkedList;

import com.sun.org.apache.regexp.internal.RE;

import entities.Felix;
import util.ResourcePathConstants;
import util.Vector2D;

public class GraphicsGame {
	/**
	 *  La letra delante de cada imagen representa a que Objeto pertenece( por ej F se refiere a Felix), la S al final significa que es el String que contiene el path de la imagen
	 */
	private String F_Quiet_S= ResourcePathConstants.F_QUIET;
	private String F_MovingLeft_S= ResourcePathConstants.F_MOVING_L;
	private String F_CantMoveLeft_S= ResourcePathConstants.F_CANT_MOVE_L;
	private String F_Fixing1Left_S= ResourcePathConstants.F_FIXING1_L;
	private String F_Fixing2Left_S= ResourcePathConstants.F_FIXING2_L;
	private String F_WithCakeLeft_S= ResourcePathConstants.F_WITHCAKE_L;
	private String F_EatingCakeLeft_S=ResourcePathConstants.F_EATINGCAKE_L;
	private String F_Wining1_S= ResourcePathConstants.F_WINING1;
	private String F_Wining2_S= ResourcePathConstants.F_WINING2;
	private String F_Wining3_S= ResourcePathConstants.F_WINING3;
	private String F_ColitionLeft_S=ResourcePathConstants.F_COLITION_L;
	private String F_Start_S= ResourcePathConstants.F_START;
	private String F_MovingRigth_S=ResourcePathConstants.F_MOVING_R;
	private String F_CantMoveRight_S= ResourcePathConstants.F_CANT_MOVE_R;
	private String F_Fixing1Right_S= ResourcePathConstants.F_FIXING1_R;
	private String F_Fixing2Right_S= ResourcePathConstants.F_FIXING2_R;
	private String F_ColitionRight_S= ResourcePathConstants.F_COLITION_R;
	private String F_WithCakeRight_S= ResourcePathConstants.F_WITHCAKE_R;
	private String F_EatingCakeRight_S=ResourcePathConstants.F_EATINGCAKE_R;
	private String F_Falling_S= ResourcePathConstants.F_FALLING;
	private Image F_Quiet;
	private Image F_MovingLeft;
	private Image F_CantMoveLeft;
	private Image F_Fixing1Left;
	private Image F_Fixing2Left;
	private Image F_WithCakeLeft;
	private Image F_EatingCakeLeft;
	private Image F_Wining1;
	private Image F_Wining2;
	private Image F_Wining3;
	private Image F_ColitionLeft;
	private Image F_Start;
	private Image F_MovingRigth;
	private Image F_CantMoveRight;
	private Image F_Fixing1Right;
	private Image F_Fixing2Right;
	private Image F_ColitionRight;
	private Image F_WithCakeRight;
	private Image F_EatingCakeRight;
	private Image F_Falling;
	private Hashtable<String, Image> images= new Hashtable<String, Image>();
	private LinkedList<ExtImage> imgAct= new LinkedList<ExtImage>(); 	
	private static GraphicsGame instance;
	
	private GraphicsGame()
	{
		
	}
	public static GraphicsGame getInstance()
	{
		if(instance == null)
		{
			instance = new GraphicsGame();
		}
		return instance;
	}
	/**
	 * Agrega elementos a la hashTable de Imagenes
	 * @param i representa la Imagen
	 * @param key representa la key de la imagen dentro de Hash Table
	 */
	private void addElement(Image i, String key)
	{
		images.put(key, i);
	}
	public Image getImage(String key)
	{
		if(images.containsKey(key))
		{
			return images.get(key);
		}
		return null;
	}
	/**
	 * Devuelve en un arreglo todas las imagenes que estan en la lista de Imagenes Actuales
	 * @return retorna el arreglo
	 */
	public LinkedList<ExtImage> getImagesAct()
	{
		return imgAct;
	}
	
	/**
	 *  Agrega una Imagen a la lista de imagenes actuales
	 * @param i representa la imagen que se quiere agregar a las actuales
	 */
	public void addImgToAct(ExtImage i)
	{
			imgAct.add(i);
	}
	/**
	 *  Borra una imagen de la lista de Actuales
	 * @param f representa la imagen a borrar
	 */
	public void delateImgOfAct(ExtImage f)
	{
		for(ExtImage i: imgAct)
		{
			if(i == f)
			{
				imgAct.remove(f);
				return;
			}
		}
	}
	
	public void update()
	{
		
	}
	
}
