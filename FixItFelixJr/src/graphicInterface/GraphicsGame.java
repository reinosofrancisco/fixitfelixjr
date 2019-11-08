package graphicInterface;

import java.awt.Image;
import java.util.Hashtable;
import java.util.SortedSet;
import java.util.TreeSet;

import util.ResourcePathConstants;

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
	private Hashtable<String, ExtImage> images;
	private SortedSet<ExtImage> imgAct;
	private static GraphicsGame instance;
	
	private GraphicsGame()
	{
		imgAct= new TreeSet<ExtImage>();
		images= ImageHashLoader.getImages();
		
		
		
		
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
	private void addElement(ExtImage i, String key)
	{
		images.put(key, i);
	}
	public ExtImage getImage(String key)
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
	public SortedSet<ExtImage> getImagesAct()
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
		imgAct.remove(f);
//		for (ExtImage i : imgAct) {
//			if (i == f) {
//				imgAct.remove(f);
//				return;
//			}
//		}
	}
	
	
	/**
	 * Que imagenes podrían llegar a cambiar en el update?
	 * 
	 * -Felix
	 * -Alguna ventana
	 * -Nicelander y tortas
	 * -Pajaros (cammbio de direccion)
	 * -Ralph (cambio de direccion)
	 * -Nuevos ladrillos
	 *  
	 */
	
	public void update()
	{
		
		//actualizo felix si hizo algo el jugador o si recibio un golpe o si agarro torta--->posicion e imagen
		
		//actualizo a ralph si se movió-->posicion e imagen
		
		//actualizo a ventana (y panel) si se rompió o arregló-->imagen
		
		//actualizo a pajaros si cambiaron de direccion--->posicion e imagen
		
		//actualizo a ladrillos si ya no existen--->posicion e imagen
		
		//actualizo a nicelander si dejo torta, desaparecio o hay que matarlo--->imagen
		
		//actualizo a building (con ventanas) si cambie de seccion o me mori--->imagen
		
		//actualizo a ...
		
		//
		
		
		
		
		
		
		
		//COMO SÉ QUE COSAS ACTUALIZAR Y QUE NO? VUELVO A LEER TOOODO Y REAGREGAR O...
		//CORE MANEJA QUE COSAS CAMBIARON EN FUNCION DEL ANTERIOR TURNO Y DE ESA LISTA DE COSAS
		//QUE CAMBIARON ACTUALIZO LO QUE SI CAMBIO
		
		//PSEUDOCODIGO?
//		if c.felix.repaired {
//			int n= c.getbuilding.getwindows[c.felix.x-1,f.felix.y-1].getlive
//			if n>2 blablabla
//		}
		
	//opcion 2
//		
//		Core c=Core.getInstance();
//		for(GameEvent g : c.getEvents()) {
//			switch g
//			case WINDOW_REPAIRED
//				int n= c.getbuilding.getwindows[c.felix.x-1,f.felix.y-1].getlive
//				//			if n>2 blablabla
//			
//			
//		}
		
		
		
		
		
	}
	
}
