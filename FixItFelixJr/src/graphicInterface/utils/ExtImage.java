package graphicInterface.utils;

import java.awt.Color;
import java.awt.Image;
import util.Vector2D;

public  class ExtImage implements Comparable<ExtImage>
{
	
	
	
	
	
	

	private Image img;
	private Vector2D pos;
	private int width;
	private int height;
	private int layer;
	private Color color;
	
	

	public ExtImage (Image img, Vector2D pos,int w, int h,int l)
	{
		this.img= img;
		this.pos= new Vector2D (pos);
		width=w;
		height=h;
		layer=l;
		color=new Color(255,255,255,0);
		
	}
	public ExtImage (Image img, Vector2D pos,int w, int h,int l,Color c)
	{
		this.img= img;
		this.pos= new Vector2D (pos);
		width=w;
		height=h;
		layer=l;
		color=new Color(c.getRed(),c.getGreen(),c.getBlue(),c.getAlpha());
	}
	
	public ExtImage(ExtImage e) {
		this.height=e.height;
		this.layer=e.layer;
		this.width=e.width;
		this.img=e.img;
		this.pos=new Vector2D(e.pos);
		
		
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof ExtImage) {
			if(((ExtImage) obj).getLayer()==layer) {
				return true;
			}
		}
		return false;
	}
	
	
	@Override
	//Cambiado para que si es igual, lo tome como "mayor"
	public int compareTo(ExtImage i) {
		if(this.layer < i.layer)
		{
			return -1;
		}
		else
		{
			return 1;
		}
		
	}
	public Image getImg() {
		return img.getScaledInstance(this.width, this.height, Image.SCALE_FAST);
	}

	public void setImg(Image img) {
		this.img = img ;
		
	}

	public Vector2D getPos() {
		return pos;
	}

	public void setPos(Vector2D pos) {
		this.pos = pos;
	}

	public int getLayer() {
		return layer;
	}

	public void setLayer(int layer) {
		this.layer = layer;
	}

	public int getWidth() {
		// TODO Auto-generated method stub
		return width;
	}

	public int getHeight() {
		// TODO Auto-generated method stub
		return height;
	}
	
	public Color getColor() {
		return color;
	}
	
	public void setColor(Color color) {
		this.color = color;
	}
}