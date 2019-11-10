package graphicInterface.utils;

import java.awt.Image;
import java.net.URL;
import java.util.Hashtable;
import javax.imageio.ImageIO;

import util.ResourcePathConstants;

public class ImageHashLoader {
	
	/**
	 *  La letra delante de cada imagen representa a que Objeto pertenece( por ej F se refiere a Felix), la S al final significa que es el String que contiene el path de la imagen
	 */
	
//	private String F_CantMoveLeft_S= ResourcePathConstants.F_CANT_MOVE_L;
//	private String F_Fixing1Left_S= ResourcePathConstants.F_FIXING1_L;
//	private String F_Fixing2Left_S= ResourcePathConstants.F_FIXING2_L;
//	private String F_WithCakeLeft_S= ResourcePathConstants.F_WITHCAKE_L;
//	private String F_EatingCakeLeft_S=ResourcePathConstants.F_EATINGCAKE_L;
//	private String F_Wining1_S= ResourcePathConstants.F_WINING1;
//	private String F_Wining2_S= ResourcePathConstants.F_WINING2;
//	private String F_Wining3_S= ResourcePathConstants.F_WINING3;
//	private String F_ColitionLeft_S=ResourcePathConstants.F_COLITION_L;
//	private String F_Start_S= ResourcePathConstants.F_START;
//	private String F_MovingRigth_S=ResourcePathConstants.F_MOVING_R;
//	private String F_CantMoveRight_S= ResourcePathConstants.F_CANT_MOVE_R;
//	private String F_Fixing1Right_S= ResourcePathConstants.F_FIXING1_R;
//	private String F_Fixing2Right_S= ResourcePathConstants.F_FIXING2_R;
//	private String F_ColitionRight_S= ResourcePathConstants.F_COLITION_R;
//	private String F_WithCakeRight_S= ResourcePathConstants.F_WITHCAKE_R;
//	private String F_EatingCakeRight_S=ResourcePathConstants.F_EATINGCAKE_R;
//	private String F_Falling_S= ResourcePathConstants.F_FALLING;
//	
	
	

	public Hashtable<String, Image> getImages() {
		Hashtable<String, Image> ret=new Hashtable<String, Image>();
		Hashtable<String, URL> aux=new Hashtable<String, URL>();
		ClassLoader c = getClass().getClassLoader();
		
		
		
		
		
		//aux.put(ResourcePathConstants.XX_S,c.getResource(ResourcePathConstants.XX));
		aux.put(ResourcePathConstants.BG_FIRST_S,c.getResource(ResourcePathConstants.BG_FIRST));
		aux.put(ResourcePathConstants.BG_THEN_S,c.getResource(ResourcePathConstants.BG_THEN));
		aux.put(ResourcePathConstants.BD_ALL_S,c.getResource(ResourcePathConstants.BD_ALL));
		aux.put(ResourcePathConstants.BD_SECTION1_S,c.getResource(ResourcePathConstants.BD_SECTION1));
		aux.put(ResourcePathConstants.BD_SECTION3_S,c.getResource(ResourcePathConstants.BD_SECTION2));
		aux.put(ResourcePathConstants.BD_SECTION2_S,c.getResource(ResourcePathConstants.BD_SECTION3));
		aux.put(ResourcePathConstants.V_ENTR0_S,c.getResource(ResourcePathConstants.V_ENTR0));
		aux.put(ResourcePathConstants.V_ENTR1_S,c.getResource(ResourcePathConstants.V_ENTR1));
		aux.put(ResourcePathConstants.V_ENTR2_S,c.getResource(ResourcePathConstants.V_ENTR2));
		aux.put(ResourcePathConstants.V_ENTR3_S,c.getResource(ResourcePathConstants.V_ENTR3));
		aux.put(ResourcePathConstants.V_ENTR4_S,c.getResource(ResourcePathConstants.V_ENTR4));
		aux.put(ResourcePathConstants.V_PAN0_S,c.getResource(ResourcePathConstants.V_PAN0));
		aux.put(ResourcePathConstants.V_PAN1_S,c.getResource(ResourcePathConstants.V_PAN1));
		aux.put(ResourcePathConstants.V_PAN2_S,c.getResource(ResourcePathConstants.V_PAN2));
		aux.put(ResourcePathConstants.V_PAN3_S,c.getResource(ResourcePathConstants.V_PAN3));
		aux.put(ResourcePathConstants.V_PAN4_S,c.getResource(ResourcePathConstants.V_PAN4));
		aux.put(ResourcePathConstants.V_PAN_OBS1_S,c.getResource(ResourcePathConstants.V_PAN_OBS1));
		aux.put(ResourcePathConstants.V_PAN_OBS2_S,c.getResource(ResourcePathConstants.V_PAN_OBS2));
		aux.put(ResourcePathConstants.V_PAN_OBS3_S,c.getResource(ResourcePathConstants.V_PAN_OBS3));
		aux.put(ResourcePathConstants.V_LEAVES0_S,c.getResource(ResourcePathConstants.V_LEAVES0));
		aux.put(ResourcePathConstants.V_LEAVES1_S,c.getResource(ResourcePathConstants.V_LEAVES1));
		aux.put(ResourcePathConstants.V_LEAVES2_S,c.getResource(ResourcePathConstants.V_LEAVES2));
		aux.put(ResourcePathConstants.V_SEMICIRCULAR_UP_HEALTHY_S,c.getResource(ResourcePathConstants.V_SEMICIRCULAR_UP_HEALTHY));
		aux.put(ResourcePathConstants.V_CONPSANA_S,c.getResource(ResourcePathConstants.V_CONPSANA));
		aux.put(ResourcePathConstants.V_CONPCERRADA_S,c.getResource(ResourcePathConstants.V_CONPCERRADA));
		aux.put(ResourcePathConstants.BUL_GENERIC_S,c.getResource(ResourcePathConstants.BUL_GENERIC));
		
		
		aux.put(ResourcePathConstants.R_QUIET_S,c.getResource(ResourcePathConstants.R_QUIET));
		
//		aux.put(ResourcePathConstants.XX_S,c.getResource(ResourcePathConstants.XX));
		
		
		
		
		
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
