package topos.paneles;

import topos.geometria.Point;

public class PanelResistente extends Panel{
		
	private int dureza;
	private int contadorGolpes;
	
	//Constante
	private final static int DUREZA_DEFAULT = 2;
	
	//Getters
	public int getDureza() {
		return dureza;
	}
	public int getContadorGolpes() {
		return contadorGolpes;
	}
	
	//Constructor
	public PanelResistente(Point posicion, int dureza) {
		super(posicion);
		this.dureza = dureza;
		this.contadorGolpes = 0;
	}
	
	public PanelResistente(Point posicion) {
		this(posicion, DUREZA_DEFAULT);
	}
	
	@Override
	public boolean golpear() {
		contadorGolpes++;
		if(contadorGolpes == getDureza()) {
			super.golpear();
		}
		return false;
	}
	
	@Override
	public String getRutaImagen() {
		if(getEstado() != Estado.LEVANTADO) {
			return null;
		}
		return "imagenes/panel-resistente.gif";
	}
	
	@Override
	public String toString() {
		return super.toString() + "[dureza=" + dureza + ", "
				+ "contadorGolpes=" + contadorGolpes + "]";
	}
	@Override
	public Object clone(){
		return (PanelResistente) super.clone();
	}
	
	
	
}
