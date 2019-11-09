package graphicInterface.utils;

import java.awt.Image;
import java.io.IOException;
import java.net.URL;
import java.util.Hashtable;

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
	
	
	

	public Hashtable<String, ExtImage> getImages() {
		Hashtable<String, ExtImage> ret=new Hashtable<String, ExtImage>();
		
		
		
		URL u = getClass().getClassLoader().getResource(F_Quiet_S);
		URL u2 = getClass().getClassLoader().getResource(F_MovingLeft_S);
		if(u!=null) {
			try {
				Image i= ImageIO.read(u);
				ret.put("Felix", new ExtImage(i, new Vector2D(200,200), 100, 100, 0));
				i=ImageIO.read(u2);
				ret.put("Felix_2", new ExtImage(i, new Vector2D(200,200),100, 100, 0));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				System.out.println("Error:");
				e.printStackTrace();
			}
			
		}
		else {
			System.out.println("No se encontró la imagen");
		}
		
		
		
		
		return ret;
	}
	
	
	

}
