package topos.paneles;

import topos.geometria.Point;

public class PanelDebil extends Panel {
	
	private int numDerribos;
	
	//CONSTANTE
	private final static int MAXIMO_DERRIBOS = 3;

	public int getNumDerribos() {
		return numDerribos;
	}
	
	//Constructor
	public PanelDebil(Point posicion) {
		super(posicion);
		this.numDerribos = 0;
	}
	
	//Actualización funcionalidad
	@Override
	public boolean golpear() {
		if(numDerribos <= MAXIMO_DERRIBOS) {
			numDerribos++;
			super.golpear();
		}
		return false;
	}
	
	//falta levantar

	
	@Override
	public String getRutaImagen() {
		if(getEstado() != Estado.LEVANTADO) {
			return null;
		}
		return "imagenes/panel-debil.gif";
	}
	
	
	@Override
	public String toString() {
		return super.toString() + "[numDerribos=" + numDerribos + "]";
	}
		
}
