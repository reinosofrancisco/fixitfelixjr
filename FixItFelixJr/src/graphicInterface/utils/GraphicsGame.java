package graphicInterface.utils;

import java.awt.Image;
import java.util.Hashtable;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

import building.Building;
import entities.Felix;
import entities.Ralph;
import randomenvironment.Bullet;
import randomenvironment.Nicelander;
import randomenvironment.RandomEnvironment;
import util.Direction;
import util.GameConstants;
import util.ResourcePathConstants;
import util.Vector2D;
import windows.Window;

public class GraphicsGame {

	private Hashtable<String, Image> images;
	
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
		images= ImageHashLoader.getImages(); 
		
		
		addBackground();
		addWindows();
		addNiceanders();
		addRalph();
		addFelix();
		addEnemies();
		
		
		
		
		
		
		
		
		
	}
	private void addNiceanders() {
		List<Nicelander> l = Building.getInstance().getNicelanders();
		for (Nicelander nicelander : l) {
			Vector2D v = nicelander.getPos();
			if(nicelander.getScreenTime()>Nicelander.CAKETIME) {
				imgAct.add(new ExtImage(images.get(ResourcePathConstants.NICELANDER_S),new Vector2D(phaseXToPixels(v.getPosx()-1),phaseYToPixels(v.getPosy()-1)),50,50,NICLANDER_LAYER));
			}
			else {
				imgAct.add(new ExtImage(images.get(ResourcePathConstants.CAKE1_S),new Vector2D(phaseXToPixels(v.getPosx()-1),phaseYToPixels(v.getPosy()-1)),50,50,NICLANDER_LAYER));
			}
		}
		
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
		imgAct.add(new ExtImage(images.get(ResourcePathConstants.BG_FIRST_S),new Vector2D(0,-50), GameConstants.WINDOW_WIDTH, GameConstants.WINDOW_HEIGHT, BACKGROUND_LAYER));
		imgAct.add(new ExtImage(images.get(ResourcePathConstants.BD_SECTION1_S),new Vector2D(240,0), 620, GameConstants.WINDOW_HEIGHT, BACKGROUND_LAYER));
	}
	private void addFelix() {
		Vector2D v = Felix.getInstnance().getVector2D();
		imgAct.add(new ExtImage(images.get(ResourcePathConstants.F_QUIET_S),new Vector2D(phaseXToPixels(v.getPosx()-1),phaseYToPixels(v.getPosy()-1)),100 , 100, FELIX_LAYER));
	}
	private void addWindows() {
		Window[][] w = Building.getInstance().getWindows();
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
		
	}
	public void update()
	{	
		
		imgAct=new TreeSet<ExtImage>();
		addBackground();
		addWindows();
		addNiceanders();
		addRalph();
		addEnemies();
		addFelix();
		
	}
	
}
