package topos.geometria;

public record Point(int x, int y) implements Comparable<Point>{

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

	@Override
	public int compareTo(Point otro) {
		int criterio1 = this.y - otro.y;
		if(criterio1 == 0) {
			int criterio2 = this.x - otro.x;
			return criterio2;
		}
		return criterio1;
	}
}
