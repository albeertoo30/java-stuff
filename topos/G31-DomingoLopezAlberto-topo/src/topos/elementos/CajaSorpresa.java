package topos.elementos;

import java.util.Random;

import topos.geometria.Point;

public class CajaSorpresa extends Elemento implements Puntuable, Recargable{

	private final int puntos;
	private final int municion;
	
	private static final Random random = new Random();
	private static final int POSIBLES_VALORES = 10;
	
	public CajaSorpresa(Point posicion) {
		super(posicion);
		this.puntos = random.nextInt(POSIBLES_VALORES);
		this.municion = random.nextInt(POSIBLES_VALORES); 
	}

	@Override
	public String getRutaImagen() {
		return "imagenes/caja-sorpresa.png";
	}

	@Override
	public int getMunicion() {
		return municion;
	}

	@Override
	public int getPuntos() {
		return puntos;
	}

}
