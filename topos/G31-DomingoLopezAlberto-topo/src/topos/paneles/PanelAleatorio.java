package topos.paneles;

import topos.geometria.Point;

import java.util.Random;

public class PanelAleatorio extends Panel {
	
	public PanelAleatorio(Point posicion) {
		super(posicion);
	}
	
	@Override
	public boolean golpear() {
		Random random = new Random();
		boolean ignorado = random.nextBoolean();
		if(ignorado == false) {
			return super.golpear();
		}
		return false;
	}
	
	@Override
	public String getRutaImagen() {
		if(getEstado() != Estado.LEVANTADO) {
			return null;
		}
		return "imagenes/panel-aleatorio.gif";
	}

	@Override
	public Object clone() {
		return (PanelAleatorio) super.clone();
	}

	/* no es necesario
	@Override
	public String toString() {
	    return super.toString();  // No tiene atributos propios, solo hereda
	}*/
	
	

}
