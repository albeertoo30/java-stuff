package topos.juego;

import java.awt.Color;
import java.util.ArrayList;

import topos.geometria.Direccion;
import topos.vista1.Alarma;
import topos.vista1.Pantalla;

public class Programa {

	//CONSTANTES:
	public static final int ALTO = 7;
	public static final int ANCHO = 7;
	public static final int TIEMPO_JUEGO = 60;
	public static final int DISPAROS_INICIO = 5;
	
	public static final int TAMANO_SECCION = 50;
	public static final Color COLOR = Color.GREEN;
	
	public static final String ARRIBA = "w";
	public static final String ABAJO = "s";
	public static final String IZQUIERDA = "a";
	public static final String DERECHA = "d";
	public static final String DISPARO = "p";
	
	public static final int TIEMPO_ESPERA = 200;
	
	
	public static void main(String[] args) {
		ConfigPartida configuracion = new ConfigPartida(ANCHO, ALTO, TIEMPO_JUEGO, DISPAROS_INICIO);
		
		Partida partida = new Partida(configuracion);
		
		Pantalla pantalla = new Pantalla(ANCHO, ALTO, TAMANO_SECCION, COLOR);
		
		partida.arrancar();
		
		while(partida.isEnJuego()) {
			pantalla.resetear();
			if(pantalla.hayTecla()) {
				String tecla = pantalla.leerTecla();
				switch(tecla) {
				case ARRIBA:
					partida.desplazarObjetivo(Direccion.ARRIBA);
					break;
				case ABAJO:
					partida.desplazarObjetivo(Direccion.ABAJO);
					break;
				case IZQUIERDA:
					partida.desplazarObjetivo(Direccion.IZQUIERDA);
					break;
				case DERECHA:
					partida.desplazarObjetivo(Direccion.DERECHA);
					break;
				case DISPARO:
					partida.disparar();
					break;
				}
			}
			partida.actualizar();
			ArrayList<Imagen> imagenes = partida.getImagenes();
			for(Imagen i: imagenes) {
				pantalla.addImagen(i.x(), i.y(), i.ruta());
			}
			pantalla.dibujar();
			String barraEstado = "Tiempo restante: " + partida.getSegundosRestantes() +
					" - Disparos: " + partida.getDisparosRestantes();
			pantalla.setBarraEstado(barraEstado);
			
			Alarma.dormir(TIEMPO_ESPERA);
		}
		
		
		pantalla.setBarraEstado("Game over");
	}
}
