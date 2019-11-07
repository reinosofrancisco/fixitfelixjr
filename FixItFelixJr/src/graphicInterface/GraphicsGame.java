package graphicInterface;

import java.awt.Image;
import java.util.Hashtable;
import java.util.LinkedList;

public class GraphicsGame {
	/**
	 * aca irian guardadas todas las imagenes
	 */
	private Hashtable<String, Image> images= new Hashtable<String, Image>();
	private LinkedList<Image> imgAct= new LinkedList<Image>(); 	
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
	public Image[] getImagesAct()
	{
		Image[] img = new Image[imgAct.size()-1];
		int p=0;
		for(Image i :imgAct)
		{
			img[p] = i;
			p++;
		}
		return img;
	}
	
	/**
	 *  Agrega una Imagen a la lista de imagenes actuales
	 * @param i representa la imagen que se quiere agregar a las actuales
	 */
	public void addImgToAct(Image i)
	{
		imgAct.add(i);
	}
	/**
	 *  Borra una imagen de la lista de Actuales
	 * @param f representa la imagen a borrar
	 */
	public void delateImgOfAct(Image f)
	{
		for(Image i: imgAct)
		{
			if(i == f)
			{
				imgAct.remove(f);
				return;
			}
		}
	}
	
}
