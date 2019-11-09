package graphicInterface.utils;

import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;

import javax.imageio.ImageIO;

import util.ResourcePathConstants;
import util.Vector2D;

public class ImageHashLoader {
	
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
	
	
	

	public Hashtable<String, Image> getImages() {
		Hashtable<String, Image> ret=new Hashtable<String, Image>();
		Hashtable<String, URL> aux=new Hashtable<String, URL>();
		ClassLoader c = getClass().getClassLoader();
		
		
		
		
		
		//aux.put("", c.getResource(ResourcePathConstants.));
		aux.put("BG_FIRST",c.getResource(ResourcePathConstants.BG_FIRST));
		aux.put("BG_THEN",c.getResource(ResourcePathConstants.BG_THEN));
		aux.put("BD_ALL",c.getResource(ResourcePathConstants.BD_ALL));
		aux.put("BD_SECTION1",c.getResource(ResourcePathConstants.BD_SECTION1));
		aux.put("BD_SECTION2",c.getResource(ResourcePathConstants.BD_SECTION2));
		aux.put("BD_SECTION3",c.getResource(ResourcePathConstants.BD_SECTION3));
//		aux.put("",c.getResource(ResourcePathConstants.));
//		aux.put("",c.getResource(ResourcePathConstants.));
//		aux.put("",c.getResource(ResourcePathConstants.));
//		aux.put("",c.getResource(ResourcePathConstants.));
//		aux.put("",c.getResource(ResourcePathConstants.));
//		aux.put("",c.getResource(ResourcePathConstants.));
//		aux.put("",c.getResource(ResourcePathConstants.S));
//		aux.put("",c.getResource(ResourcePathConstants.));
//		aux.put("",c.getResource(ResourcePathConstants.));
//		aux.put("",c.getResource(ResourcePathConstants.));
//		aux.put("",c.getResource(ResourcePathConstants.));
//		aux.put("",c.getResource(ResourcePathConstants.));
//		aux.put("",c.getResource(ResourcePathConstants.S));
//		aux.put("",c.getResource(ResourcePathConstants.));
//		aux.put("",c.getResource(ResourcePathConstants.));
//		aux.put("",c.getResource(ResourcePathConstants.));
//		aux.put("",c.getResource(ResourcePathConstants.));
//		aux.put("",c.getResource(ResourcePathConstants.));
//		aux.put("",c.getResource(ResourcePathConstants.S));
		
		
		
		
		aux.put("F_QUIET",c.getResource(ResourcePathConstants.F_QUIET));
		aux.put("F_MOVING_L",c.getResource(ResourcePathConstants.F_MOVING_L));

		for (String s : aux.keySet()) {
			if(aux.get(s)!=null) {
				try {
					ret.put(s, ImageIO.read(aux.get(s)));
				} catch (Exception e) {
					System.out.println("Error:");
					e.printStackTrace();
				}
			}
			else {
				System.out.println("Error: url: "+ s + " --> " + aux.get(s) );
			}
			
		}
		
		
		
		return ret;
	}
	
	
	

}
