package graphicInterface.utils;

import java.awt.Image;
import java.util.Collection;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import building.Building;
import entities.Felix;
import entities.Ralph;
import randomenvironment.Bullet;
import randomenvironment.RandomEnvironment;
import util.Direction;
import util.GameConstants;
import util.ResourcePathConstants;
import util.Vector2D;
import windows.Window;

public class GraphicsGame {

	private static Hashtable<String, Image> images; //PREGUNTAR? la hago estatica para poder accederla desde cualquier lugar
	
	//MOVER ABAJO SI APRUEBAN LA IDEA (despues de preguntar)
	public static Hashtable<String, Image> getImages() {
		return images;
	} 
	
	private SortedSet<ExtImage> imgAct;
	private static GraphicsGame instance;
	
	private static final int BACKGROUND_LAYER=0;
	private static final int WINDOWS_LAYER=1;
	private static final int FELIX_LAYER=2;
	private static final int RALPH_LAYER=3;
	private static final int BIRDS_LAYER=4;
	private static final int BRICKS_LAYER=5;
	private static final int NICLANDER_LAYER=6;
	
	
	
	private GraphicsGame()
	{
		imgAct= new TreeSet<ExtImage>();
		images= (new ImageHashLoader()).getImages(); //instancio porque es mas facil cargar imagenes desde instancia
		
		
		addBackground();
		addWindows();
		addRalph();
		addEnemies();
		addFelix();
		
		
		
		
		
		
		
	}
	private void addEnemies() {
		List<Bullet> l = RandomEnvironment.getInstance().getBullets();
		for (Bullet bullet : l) {
			Vector2D v = bullet.getVector2D();
			if(bullet.getType()==Bullet.BIRD) {
				if(bullet.getDirection()==Direction.LEFT) {
					imgAct.add(new ExtImage(images.get(ResourcePathConstants.BIRD_LEFT_S),new Vector2D(phaseXToPixels(v.getPosx()-1),phaseYToPixels(v.getPosy()-1)),50,50,BIRDS_LAYER));
				}
				else {
					imgAct.add(new ExtImage(images.get(ResourcePathConstants.BIRD_RIGHT_S),new Vector2D(phaseXToPixels(v.getPosx()-1),phaseYToPixels(v.getPosy()-1)),50,50,BIRDS_LAYER));
				}
			}
			else if(bullet.getType()==Bullet.BRICK) {
				imgAct.add(new ExtImage(images.get(ResourcePathConstants.BUL_GENERIC_S),new Vector2D(phaseXToPixels(v.getPosx()-1),phaseYToPixels(v.getPosy()-1)),50,50,BRICKS_LAYER));
				
			}
			
		}
	}
	private void addRalph() {
		Vector2D v = Ralph.getInstance().getPos();
		imgAct.add(new ExtImage(images.get(ResourcePathConstants.R_QUIET_S),new Vector2D(phaseXToPixels(v.getPosx()-1),phaseYToPixels(v.getPosy()-1)),100,100,RALPH_LAYER));
		
	}
	private void addBackground() {
		imgAct.add(new ExtImage(images.get(ResourcePathConstants.BG_FIRST_S),new Vector2D(0,-50), GameConstants.WINDOW_WIDTH, GameConstants.WINDOW_HEIGHT, 0));
		imgAct.add(new ExtImage(images.get(ResourcePathConstants.BD_SECTION1_S),new Vector2D(240,0), 620, GameConstants.WINDOW_HEIGHT, 0));
	}
	private void addFelix() {
		Vector2D v = Felix.getInstnance().getVector2D();
		imgAct.add(new ExtImage(images.get(ResourcePathConstants.F_QUIET_S),new Vector2D(phaseXToPixels(v.getPosx()-1),phaseYToPixels(v.getPosy()-1)),100 , 100, FELIX_LAYER));
	}
	private void addWindows() {
		Building b = Building.getInstance();
		Window[][] w = b.getWindows();
		for (int i = 0,posX=phaseXToPixels(i); i < w.length; i++,posX=phaseXToPixels(i)) {
			for (int j = 0,posY=phaseYToPixels(j); j < w[i].length; j++,posY=phaseYToPixels(j)) {
				switch (w[i][j].getType()) {
				case Window.HALFCIRCLE:
					if(j==0) {
						imgAct.add(new ExtImage(images.get(ResourcePathConstants.V_ENTR_S + w[i][j].getNotHealthyPannelsAmmount()),new Vector2D(posX,posY),100,150,WINDOWS_LAYER));
					}
					else {
						imgAct.add(new ExtImage(images.get(ResourcePathConstants.V_SEMI_S + w[i][j].getNotHealthyPannelsAmmount()),new Vector2D(posX,posY),100,150,WINDOWS_LAYER)); //TODO
					}

					break;
				case Window.RALPHWINDOW:
					imgAct.add(new ExtImage(images.get(ResourcePathConstants.V_CONPSANA_S),new Vector2D(posX,posY),100,150,WINDOWS_LAYER));
					break;
				case Window.TWOPANELS:
					imgAct.add(new ExtImage(images.get(ResourcePathConstants.V_PAN_S + w[i][j].getNotHealthyPannelsAmmount()),new Vector2D(posX,posY),100,150,WINDOWS_LAYER));
					int obs=w[i][j].getObstacles();
					if(obs!=0) {
						imgAct.add(new ExtImage(images.get(ResourcePathConstants.V_PAN_OBS_S + obs),new Vector2D(posX,posY),100,150,WINDOWS_LAYER));
					}
					break;
				case Window.WITHLEAVES:
					
					imgAct.add(new ExtImage(images.get(ResourcePathConstants.V_LEAVES_S + w[i][j].getObstacles()),new Vector2D(posX,posY),100,150,WINDOWS_LAYER));
					break;


				default:
					break;
				}
				
				
//				imgAct.add(new ExtImage(images.get(ResourcePathConstants.V_ENTRSANA_S),new Vector2D(290+(i*(100+4)),20+(j*(150+10))),100,150,1));
			}
		}
	}
	private int phaseYToPixels(int i2) {
		return GameConstants.WINDOW_HEIGHT-(150+i2*(150+10)+50);
	}
	private int phaseXToPixels(int i2) {
		return 290+(i2*(100+4));
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
	 * Devuelve en un arreglo todas las imagenes que estan en la lista de Imagenes Actuales
	 * @return retorna el arreglo
	 */
	public SortedSet<ExtImage> getImagesAct()
	{
		//retorno COPIA de imagenes
		return new TreeSet<ExtImage>(imgAct);
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
//		i++;
//		ExtImage e;
//		if ((i%2)==0) {
//			imgAct.first().setImg(images.get("F_QUIET"));
//			System.out.println("Quieto");
//			
//		}
//		else {
//			
//			imgAct.first().setImg(images.get("F_MOVING_L"));
//			System.out.println("Camina");
//		}
		
		
		
		//BORRAR TODAS LAS VENTANAS
//		Collection<ExtImage> c=new TreeSet<ExtImage>();
//		for (ExtImage extImage : imgAct) {
//			if(extImage.getLayer()==GraphicsGame.WINDOWS_LAYER) {
//				c.add(extImage);
//			}
//		}
//		imgAct.removeAll(c);
//		addWindows(); //unimplemented method. adds windows to imgAct collection using the same method the constructor uses
		
		
		imgAct=new TreeSet<ExtImage>();
		addBackground();
		addWindows();
		addRalph();
		addEnemies();
		addFelix();
		
		
		
		
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
