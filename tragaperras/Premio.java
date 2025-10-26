package tragaperras;

import java.util.ArrayList;
import java.util.Arrays;

public class Premio {
	
	//ATRIBUTOS
	private final double cantidad;
	private final ArrayList<Fruta> combinacion;
	
	//Getters
	public double getCantidad() {
		return cantidad;
	}
	public ArrayList<Fruta> getCombinacion() {
		//copia para evitar aliasing
		return new ArrayList<Fruta>(combinacion);
	}
	
	//CONSTRUCTOR
	public Premio(double cantidad, Fruta... combinacion) {
		this.cantidad = cantidad;
		this.combinacion = new ArrayList<Fruta>(Arrays.asList(combinacion));
	}
	
}
