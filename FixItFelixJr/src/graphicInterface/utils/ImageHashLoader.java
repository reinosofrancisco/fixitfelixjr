package graphicInterface.utils;

import java.awt.Image;
import java.net.URL;
import java.util.Hashtable;
import javax.imageio.ImageIO;

import util.ResourcePathConstants;

public class ImageHashLoader {
	
	private static Hashtable<String, Image> allImages;
	

	public static Hashtable<String, Image> getImages() {
		if (allImages == null) {

			Hashtable<String, Image> ret = new Hashtable<String, Image>();
			Hashtable<String, URL> aux = new Hashtable<String, URL>();
			ClassLoader c = ImageHashLoader.class.getClassLoader();

			// aux.put(ResourcePathConstants.XX_S,c.getResource(ResourcePathConstants.XX));

			// FOR THE OTHER CLASSES
			
			aux.put(ResourcePathConstants.CONFIG_BG_S,c.getResource(ResourcePathConstants.CONFIG_BG));
			aux.put(ResourcePathConstants.TOPSCORES_BG_S,c.getResource(ResourcePathConstants.TOPSCORES_BG));
			aux.put(ResourcePathConstants.STATS_BG_S,c.getResource(ResourcePathConstants.STATS_BG));

			// FOR THE GAME (perdiste)
			aux.put(ResourcePathConstants.BG_FIRST_S, c.getResource(ResourcePathConstants.BG_FIRST));
			aux.put(ResourcePathConstants.BG_THEN_S, c.getResource(ResourcePathConstants.BG_THEN));
			aux.put(ResourcePathConstants.BD_ALL_S, c.getResource(ResourcePathConstants.BD_ALL));
			aux.put(ResourcePathConstants.BD_SECTION1_S, c.getResource(ResourcePathConstants.BD_SECTION1));
			aux.put(ResourcePathConstants.BD_SECTION3_S, c.getResource(ResourcePathConstants.BD_SECTION2));
			aux.put(ResourcePathConstants.BD_SECTION2_S, c.getResource(ResourcePathConstants.BD_SECTION3));
			aux.put(ResourcePathConstants.V_ENTR0_S, c.getResource(ResourcePathConstants.V_ENTR0));
			aux.put(ResourcePathConstants.V_ENTR1_S, c.getResource(ResourcePathConstants.V_ENTR1));
			aux.put(ResourcePathConstants.V_ENTR2_S, c.getResource(ResourcePathConstants.V_ENTR2));
			aux.put(ResourcePathConstants.V_ENTR3_S, c.getResource(ResourcePathConstants.V_ENTR3));
			aux.put(ResourcePathConstants.V_ENTR4_S, c.getResource(ResourcePathConstants.V_ENTR4));
			aux.put(ResourcePathConstants.V_SEMI0_S, c.getResource(ResourcePathConstants.V_SEMI0));
			aux.put(ResourcePathConstants.V_SEMI1_S, c.getResource(ResourcePathConstants.V_SEMI1));
			aux.put(ResourcePathConstants.V_SEMI2_S, c.getResource(ResourcePathConstants.V_SEMI2));
			aux.put(ResourcePathConstants.V_SEMI3_S, c.getResource(ResourcePathConstants.V_SEMI3));
			aux.put(ResourcePathConstants.V_SEMI4_S, c.getResource(ResourcePathConstants.V_SEMI4));
			aux.put(ResourcePathConstants.V_SEMI5_S, c.getResource(ResourcePathConstants.V_SEMI5));
			aux.put(ResourcePathConstants.V_SEMI6_S, c.getResource(ResourcePathConstants.V_SEMI6));
			aux.put(ResourcePathConstants.V_SEMI7_S, c.getResource(ResourcePathConstants.V_SEMI7));
			aux.put(ResourcePathConstants.V_SEMI8_S, c.getResource(ResourcePathConstants.V_SEMI8));
			aux.put(ResourcePathConstants.V_PAN0_S, c.getResource(ResourcePathConstants.V_PAN0));
			aux.put(ResourcePathConstants.V_PAN1_S, c.getResource(ResourcePathConstants.V_PAN1));
			aux.put(ResourcePathConstants.V_PAN2_S, c.getResource(ResourcePathConstants.V_PAN2));
			aux.put(ResourcePathConstants.V_PAN3_S, c.getResource(ResourcePathConstants.V_PAN3));
			aux.put(ResourcePathConstants.V_PAN4_S, c.getResource(ResourcePathConstants.V_PAN4));
			aux.put(ResourcePathConstants.V_PAN_OBS1_S, c.getResource(ResourcePathConstants.V_PAN_OBS1));
			aux.put(ResourcePathConstants.V_PAN_OBS2_S, c.getResource(ResourcePathConstants.V_PAN_OBS2));
			aux.put(ResourcePathConstants.V_PAN_OBS3_S, c.getResource(ResourcePathConstants.V_PAN_OBS3));
			aux.put(ResourcePathConstants.V_LEAVES0_S, c.getResource(ResourcePathConstants.V_LEAVES0));
			aux.put(ResourcePathConstants.V_LEAVES1_S, c.getResource(ResourcePathConstants.V_LEAVES1));
			aux.put(ResourcePathConstants.V_LEAVES2_S, c.getResource(ResourcePathConstants.V_LEAVES2));
			aux.put(ResourcePathConstants.V_CONPSANA_S, c.getResource(ResourcePathConstants.V_CONPSANA));
			aux.put(ResourcePathConstants.V_CONPCERRADA_S, c.getResource(ResourcePathConstants.V_CONPCERRADA));
			aux.put(ResourcePathConstants.BUL_GENERIC_S, c.getResource(ResourcePathConstants.BUL_GENERIC));
			aux.put(ResourcePathConstants.BIRD_LEFT_S, c.getResource(ResourcePathConstants.BIRD_LEFT));
			aux.put(ResourcePathConstants.BIRD_RIGHT_S, c.getResource(ResourcePathConstants.BIRD_RIGHT));
			aux.put(ResourcePathConstants.CAKE1_S,c.getResource(ResourcePathConstants.CAKE1));
			aux.put(ResourcePathConstants.NICELANDER_S,c.getResource(ResourcePathConstants.NICELANDER));
			
			
			aux.put(ResourcePathConstants.R_QUIET_S, c.getResource(ResourcePathConstants.R_QUIET));

//		aux.put(ResourcePathConstants.XX_S,c.getResource(ResourcePathConstants.XX));

			aux.put("F_QUIET", c.getResource(ResourcePathConstants.F_QUIET));
			aux.put("F_MOVING_L", c.getResource(ResourcePathConstants.F_MOVING_L));

			for (String s : aux.keySet()) {
				if (aux.get(s) != null) {
					try {
						ret.put(s, ImageIO.read(aux.get(s)));
					} catch (Exception e) {
						System.out.println("Error:");
						e.printStackTrace();
					}
				} else {
					System.out.println("Error: url: " + s + " --> " + aux.get(s));
				}

			}

			allImages=ret;
		}
		return allImages;
	}
	
	
	

}
