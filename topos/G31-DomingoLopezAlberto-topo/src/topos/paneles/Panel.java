package topos.paneles;

import topos.geometria.Direccion;
import topos.geometria.Point;

public class Panel {
	
	private Point posicion;
	private Estado estado;
	
	// Getters
	public Point getPosicion() {
		return posicion;
	}
	public Estado getEstado() {
		return estado;
	}
	
	// Constructor
	public Panel(Point posicion) {
		this.posicion = posicion;
		this.estado = Estado.LEVANTADO;
	}
	
	// Funcionalidad
	public boolean golpear() {
		if(estado.equals(Estado.LEVANTADO)) {
			estado = Estado.DERRIBADO;
			return true;
		}
		return false;
	}
	
	public boolean levantar() {
		if(estado.equals(Estado.DERRIBADO)) {
			estado = Estado.LEVANTADO;
			return true;
		}
		return false;
	}
	
	public void desplazar(Direccion dir) {
		this.posicion = posicion.desplazar(dir);
	}
	
	public void situar(Point posicion) {
		this.posicion = posicion;
	}
	
	// Funcionalidad añadida en la sesión 8
	public String getRutaImagen() {
		if(estado != Estado.LEVANTADO) {
			return null;
		}
		return "imagenes/panel-basico.gif";
	}
	
	
	@Override
	public String toString() {
		return getClass().getName() + " [posicion=" + posicion + ", estado=" + estado + "]";
	}	
	
}
