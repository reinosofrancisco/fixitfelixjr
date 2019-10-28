package taller2.modelo;


public class InformacionDibujable
{
  private int x;
  

  private int y;
  

  private Character representacion;
  


  public InformacionDibujable(int x, int y, Character representacion)
  {
    this.x = x;
    this.y = y;
    this.representacion = representacion;
  }
  
  public int getX() {
    return x;
  }
  
  public void setX(int x) {
    this.x = x;
  }
  
  public int getY() {
    return y;
  }
  
  public void setY(int y) {
    this.y = y;
  }
  
  public Character getRepresentacion() {
    return representacion;
  }
  
  public void setRepresentacion(Character representacion) {
    this.representacion = representacion;
  }
}