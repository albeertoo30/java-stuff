package topos.geometria;

public record Point(int x, int y) {

	//constantes
	public static final int DESPLAZAMIENTO_DEFAULT = 1;
	
	public Point desplazar(int incX, int incY) {
		Point nuevo = new Point(x+incX, y+incY);
		return nuevo;
	}
	
	public Point desplazar(Direccion dir) {
		Point desplazado = null;
	    switch (dir) {
	        case ARRIBA:
	            desplazado = desplazar(0, DESPLAZAMIENTO_DEFAULT);
	            break;
	        case ABAJO:
	        	desplazado = desplazar(0, -DESPLAZAMIENTO_DEFAULT);
	            break;
	        case IZQUIERDA:
	        	desplazado = desplazar(-DESPLAZAMIENTO_DEFAULT,0);
	            break;
	        case DERECHA:
	        	desplazado = desplazar(DESPLAZAMIENTO_DEFAULT,0);
	            break;
	    }
	    return desplazado;
	}
}
