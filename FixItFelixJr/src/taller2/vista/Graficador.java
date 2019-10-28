package taller2.vista;

import java.awt.Graphics;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.swing.JFrame;

import taller2.modelo.Dibujable;
import taller2.modelo.InformacionDibujable;

/*
 * Muestra en pantalla elementos. Por ejemplo, si tengo varios personajes (implementan la 
 * interfaz Dibujable), sólo necesito su posicón y un caracter representativo para mostrarlo
 * */
public class Graficador {
   private static final int ANCHO = 650;
   private static final int ALTO = 550;
   private static final int DELTA = 50;
   private static JFrame frame = new JFrame("Visualización Fix It Felix");
   private static final int margen = 50;

   static {
      frame.setSize(700, 600);
      frame.setVisible(true);
      frame.setResizable(false);
   }

   public static void refrescarTopDown(List<? extends Dibujable> listaDibujables, int delayMilis) {
      Graphics gr = frame.getContentPane().getGraphics();
      Iterator var4 = listaDibujables.iterator();

      while(var4.hasNext()) {
         Dibujable i = (Dibujable)var4.next();
         InformacionDibujable id = i.getInformacionDibujable();
         gr.drawString(id.getRepresentacion().toString(), id.getX() + margen, id.getY() + margen);
      }

      try {
         TimeUnit.MILLISECONDS.sleep((long)delayMilis);
      } catch (InterruptedException var6) {
         var6.printStackTrace();
      }

      gr.clearRect(0, 0, ANCHO + margen, ALTO + margen);
   }

   public static void refrescarDownTop(List<? extends Dibujable> listaDibujables, int delayMilis) {
      Graphics gr = frame.getContentPane().getGraphics();
      Iterator var4 = listaDibujables.iterator();

      while(var4.hasNext()) {
         Dibujable i = (Dibujable)var4.next();
         InformacionDibujable id = i.getInformacionDibujable();
         gr.drawString(id.getRepresentacion().toString(), id.getX() + margen, 500 - id.getY());
      }

      try {
         TimeUnit.MILLISECONDS.sleep((long)delayMilis);
      } catch (InterruptedException var6) {
         var6.printStackTrace();
      }

      gr.clearRect(0, 0, ANCHO + margen, ALTO + margen);
   }
}