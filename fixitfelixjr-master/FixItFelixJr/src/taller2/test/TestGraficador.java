package taller2.test;
import java.awt.Color;
import java.util.ArrayList;

import taller2.modelo.Dibujable;
import taller2.vista.Graficador;

/* Clase que prueba donde aparece el contenido. 
 * Para graficar continuamente, simplemente en lugar de dibujar
 * sólo 1 vez, debería iterar N veces sobre la colección de objetos a mostrar
 */
public class TestGraficador {
	public static void main(String[] args) {
		//prueba cuando dibuja de arriba a abajo
		ArrayList<Dibujable> lista = new ArrayList<Dibujable>(); 
		lista.add(new Dato(100,100,'A'));
		lista.add(new Dato(200,200,'B'));
		lista.add(new Dato(300,300,'C'));
		Graficador.refrescarTopDown(lista,1000);
		
		//prueba cuando dibuja de abajo hacia arriba
		lista = new ArrayList<Dibujable>(); 
		lista.add(new Dato(10,10,'D'));
		lista.add(new Dato(20,20,'E'));
		lista.add(new Dato(30,30,'F'));
		
		Graficador.refrescarDownTop(lista, 1000);
	}
}
