package graphicInterface;

import java.awt.Image;

import util.Vector2D;

public  class ExtImage implements Comparable<ExtImage>
{
	
	private Image img;
	private Vector2D pos;
	private int layer;
	public ExtImage (Image img, Vector2D pos)
	{
		this.img= img;
		this.pos= new Vector2D (pos);
	}
	
	public static ExtImage changeImgToExt(Image i, Vector2D pos)
	{
		return new ExtImage(i, pos);
	}

	@Override
	public int compareTo(ExtImage i) {
		if(this.layer < i.layer)
		{
			return -1;
		}
		else 
		{
			if(this.layer > i.layer)
			{
				return 1;
			}
			else return 0;
		}
		
	}
	public Image getImg() {
		return img;
	}

	public void setImg(Image img) {
		this.img = img;
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
	
}