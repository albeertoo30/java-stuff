package topos.elementos;

import topos.geometria.Direccion;
import topos.geometria.Point;

public abstract class Elemento {
	
	private Point posicion;

	public Elemento(Point posicion) {
		this.posicion = posicion;
	}
	
	public Point getPosicion() {
		return posicion;
	}
	
	protected void desplazar(Direccion dir) {
		this.posicion = posicion.desplazar(dir);
	}
	
	public abstract String getRutaImagen();
}
