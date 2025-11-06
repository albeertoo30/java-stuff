package topos.juego;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.ArrayList;

import topos.geometria.Direccion;
import topos.geometria.Point;
import topos.paneles.Estado;
import topos.paneles.Panel;

public class Partida {
	
	private ConfigPartida configuracion;
	private Point objetivo;
	private int disparosRestantes;
	private int puntos;
	private ArrayList<Panel> paneles;
	
	//Atributo de implementación
	private LocalDateTime fechaInicio;
	
	//Constantes
	public static final String RUTA_OBJETIVO = "imagenes/objetivo.png";
	
	//Getters
	public ConfigPartida getConfiguracion() {
		return configuracion;
	}
	public Point getObjetivo() {
		return objetivo;
	}
	public int getDisparosRestantes() {
		return disparosRestantes;
	}
	public int getPuntos() {
		return puntos;
	}
	public ArrayList<Panel> getPaneles() {
		//copia para evitar aliasing
		return new ArrayList<>(paneles);
	}
	
	//Propiedades calculadas
	public boolean isIniciada() {
		return fechaInicio != null;
	}
	
	public int getSegundosRestantes() {
	    if(!isIniciada()) {
	        return -1;
	    }
	    long transcurridos = Duration.between(fechaInicio, LocalDateTime.now()).getSeconds();
	    int restantes = configuracion.timeMax() - (int) transcurridos;
	    return restantes;
	}
	
	public boolean isFinalizada() {
		return isIniciada() && getSegundosRestantes() <= 0;
	}
	
	public boolean isEnJuego() {
		return isIniciada() && !isFinalizada() && disparosRestantes != 0;
	}
	
	// Constructores
	public Partida(ConfigPartida configuracion) {
		this.configuracion = configuracion;
		this.objetivo = new Point(0,0);
		this.puntos = 0;
		this.disparosRestantes = configuracion.disparos();
		this.paneles = new ArrayList<Panel>();
		this.fechaInicio = null;
	}
	
	// Funcionalidad
	private boolean isPosicionValida(Point posicion) {
		return posicion.x() >= 0 && posicion.x() < configuracion.ancho()
				&& posicion.y() >= 0 && posicion.y() < configuracion.alto();
	}
	
	public boolean addPanel(Panel panel) {
		if(isPosicionValida(panel.getPosicion())) {
			paneles.addFirst(panel);
			return true;
		}
		return false;
	}
	
	public ArrayList<Panel> getPaneles(Point posicion){
		ArrayList<Panel> listaPaneles = new ArrayList<Panel>();
		for(Panel p: paneles) {
			if(p.getPosicion().equals(posicion)) {
				listaPaneles.add(p);
			}
		}
		return listaPaneles;
	}
	
	public boolean isVisible(Point posicion) {
		for(Panel p: getPaneles(posicion)) {
			if(p.getEstado().equals(Estado.LEVANTADO)) {
				return false;
			}
		}
		return true;
	}
	
	public boolean arrancar() {
		if(!isIniciada()) {
			fechaInicio = LocalDateTime.now();
			return true;
		}
		return false;
	}
	
	public boolean desplazarObjetivo(Direccion dir) {
	    Point objetivoDesplazado = objetivo.desplazar(dir);
	    if(isPosicionValida(objetivoDesplazado)) {
	        objetivo = objetivoDesplazado;
	        return true;
	    }
	    return false;
	}
	
	public void disparar() {
		this.disparosRestantes--;
		ArrayList<Panel> panelesDisponibles = getPaneles(objetivo);
		for(Panel p: panelesDisponibles) {
			if(p.getEstado() == Estado.LEVANTADO) {
				p.golpear();
				break;
			}
		}
	}
	
	public void actualizar() {
		if(getSegundosRestantes() % 5 == 0) {
			for(Panel p: paneles) {
				if(p.getEstado() == Estado.DERRIBADO) {
					p.levantar();
				}
			}
		}
	}
	
	public ArrayList<Imagen> getImagenes(){
		ArrayList<Imagen> lista = new ArrayList<Imagen>();
		for(Panel p: this.paneles) {
			if(p.getRutaImagen() != null) {
				lista.add(new Imagen(p.getRutaImagen(), p.getPosicion().x(),
						p.getPosicion().y()));
			}
		}
		lista.add(new Imagen(RUTA_OBJETIVO, objetivo.x(), objetivo.y()));
		return lista;
	}
	
	//Métodos de Object
	@Override
	public String toString() {
		return getClass().getName() + " [configuracion=" + configuracion + ", objetivo=" + objetivo + ", disparosRestantes="
				+ disparosRestantes + ", puntos=" + puntos + ", paneles=" + paneles + ", fechaInicio=" + fechaInicio
				+ "]";
	}
	

}	
