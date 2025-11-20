package topos.elementos;

import java.time.Duration;
import java.time.LocalDateTime;

import topos.geometria.Direccion;
import topos.geometria.Point;
import topos.juego.ContextoVisibilidad;
import topos.juego.Puntuable;

public abstract class ElementoActivo extends Elemento implements Puntuable{

	private LocalDateTime ultimoMovimiento;
	private Direccion ultimaDireccion;
	
	//Constructor
	public ElementoActivo(Point posicion) {
		super(posicion);
		this.ultimoMovimiento = LocalDateTime.now();
		this.ultimaDireccion = null;
	}
	
	//Getters
	public LocalDateTime getUltimoMovimiento() {
		return ultimoMovimiento;
	}

	public Direccion getUltimaDireccion() {
		return ultimaDireccion;
	}
	
	//Funcionalidad
	public final void actualizar(ContextoVisibilidad cv) {
		if(quiereMoverse(cv)) {
			int tiempoTranscurrido = (int) Duration.between(ultimoMovimiento, LocalDateTime.now()).getSeconds();
			if(tiempoTranscurrido > 1) {
				Direccion dir = direccionSiguienteMovimiento(cv);
				if(dir != null) {
					desplazar(dir);
					this.ultimaDireccion = dir;
					this.ultimoMovimiento = LocalDateTime.now();
				}
			}
		}
	}

	//Métodos de apoyo para actualizar
	protected abstract boolean quiereMoverse(ContextoVisibilidad cv);
	
	protected abstract Direccion direccionSiguienteMovimiento(ContextoVisibilidad cv);
	
}
