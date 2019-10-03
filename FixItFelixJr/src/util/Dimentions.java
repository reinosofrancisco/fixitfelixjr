package util;

public enum Dimentions 
{
	HEIGHT(3),
	WIDTH(5);
	
	private int size;
	
	 Dimentions(int size)
	{
		this.size= size;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) 
	{
		this.size = size;
	}
	 
}
