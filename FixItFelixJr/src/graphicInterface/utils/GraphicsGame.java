package graphicInterface.utils;

import java.util.Hashtable;
import java.util.SortedSet;
import java.util.TreeSet;

public class GraphicsGame {

	private Hashtable<String, ExtImage> images;
	private SortedSet<ExtImage> imgAct;
	private static GraphicsGame instance;
	
	
	
	//borrar
	int i=0;
	
	private GraphicsGame()
	{
		imgAct= new TreeSet<ExtImage>();
		images= (new ImageHashLoader()).getImages(); //instancio porque es mas facil cargar imagenes desde instancia
		imgAct.add(images.get(new String("Felix")));
		
		
		
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
	public void addImagToAct(ExtImage i)
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
		i++;
		if ((i%2)==0) {
			imgAct.remove(imgAct.first());
			imgAct.add(images.get("Felix_2"));
			System.out.println("Quieto");
			
		}
		else {
			imgAct.remove(imgAct.first());
			imgAct.add(images.get("Felix"));
			System.out.println("Camina");
		}
		
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
