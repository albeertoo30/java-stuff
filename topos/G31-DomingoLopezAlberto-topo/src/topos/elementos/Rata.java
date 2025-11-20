package topos.elementos;

import topos.geometria.Direccion;
import topos.geometria.Point;
import topos.juego.ContextoVisibilidad;
import topos.juego.Visibilidad;

public class Rata extends ElementoActivo {

	public Rata(Point posicion) {
		super(posicion);
	}

	@Override
	public int getPuntos() {
		return -1;
	}

	@Override
	protected boolean quiereMoverse(ContextoVisibilidad cv) {
		return cv.centro() == Visibilidad.OCULTA;
	}

	@Override
	protected Direccion direccionSiguienteMovimiento(ContextoVisibilidad cv) {
		for(Direccion dir: Direccion.values()) {
			Visibilidad vis = switch(dir) {
			case ARRIBA -> cv.arriba();
			case ABAJO -> cv.abajo();
			case IZQUIERDA -> cv.izquierda();
			case DERECHA -> cv.derecha();
			};
			
			if(vis == Visibilidad.VISIBLE) {
				return dir;
			}
		}
		return null;
	}

	@Override
	public String getRutaImagen() {
		return "imagenes/rata.png";
	}

}
