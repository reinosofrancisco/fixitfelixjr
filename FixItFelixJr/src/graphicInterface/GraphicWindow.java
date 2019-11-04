package graphicInterface;

import javax.swing.JPanel;

import building.Building;
import windows.Window;

public class GraphicWindow extends JPanel{
	
	
	
	
	public GraphicWindow() {
		super();
		
	}
	
	public GraphicWindow(int x,int y) {
		super();
		Window w= Building.getInstance().getWindows()[x][y];
		//la lectura y armado de panel
	}
	
	
	

}
