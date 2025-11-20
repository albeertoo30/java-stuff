package topos.elementos;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import topos.geometria.Direccion;
import topos.geometria.Point;
import topos.juego.ContextoVisibilidad;
import topos.juego.Visibilidad;

public class TopoTorpe extends ElementoActivo {
	
	private static final Random random = new Random();

	public TopoTorpe(Point posicion) {
		super(posicion);
	}

	@Override
	public int getPuntos() {
		return 2;
	}

	@Override
	protected boolean quiereMoverse(ContextoVisibilidad cv) {
		return cv.centro() == Visibilidad.VISIBLE;
	}

	@Override
	protected Direccion direccionSiguienteMovimiento(ContextoVisibilidad cv) {
		List<Direccion> direccionesValidas = new ArrayList<>();
		for (Direccion dir : Direccion.values()) {
			Visibilidad vis = switch (dir) {
            case ARRIBA -> cv.arriba();
            case ABAJO -> cv.abajo();
            case DERECHA -> cv.derecha();
            case IZQUIERDA -> cv.izquierda();
			};
			 
			if(vis != Visibilidad.NO_VALIDA) {
				direccionesValidas.add(dir);
			}
			 
			return direccionesValidas.get(random.nextInt(direccionesValidas.size()));
		 }
	            
		 return null;
	}

	@Override
	public String getRutaImagen() {
		return "imagenes/topo-torpe.png";
	}

}
