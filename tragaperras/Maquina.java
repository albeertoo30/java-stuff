package tragaperras;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class Maquina {
	
	//ATRIBUTOS
	private final int casillas;
	private double precioJugada;
	private double credito;
	private final ArrayList<Premio> premios;
	//jugada disponible --> propiedad calculada
	
	//Getters
	public int getCasillas() {
		return casillas;
	}
	public double getPrecioJugada() {
		return precioJugada;
	}
	public double getCredito() {
		return credito;
	}
	public ArrayList<Premio> getPremios() {
		//copia para evitar aliasing
		return new ArrayList<Premio>(premios);
	}
	
	public void setPrecioJugada(double precioJugada) {
		this.precioJugada = precioJugada;
	}
	
	//CONSTRUCTOR
	public Maquina(int casillas, double precioJugada, Premio... premios) {
		this.casillas = casillas;
		this.precioJugada = precioJugada;
		this.premios = new ArrayList<Premio>(Arrays.asList(premios));
		this.credito = 0;
	}
	
	//propiedad calculada: jugada disponible
	public boolean isJugadaDisponible() {
		if(credito >= precioJugada) {
			return true;
		}
		return false;
	}
	
	//Funcionalidad
	public void incrementarCredito(double cantidad) {
		credito += cantidad;
	}
	
	private ArrayList<Fruta> generarCombinacion() {
		ArrayList<Fruta> combinacion = new ArrayList<Fruta>(this.casillas);
		Random random = new Random();
		Fruta[] todas = Fruta.values(); //array con todos los valores del enum
		
		for (int i = 0; i < this.casillas; i++) {
		//generamos un número entre 0 y el número de valores del enum
			int index = random.nextInt(todas.length);
			Fruta fruta = todas[index]; //seleccionamos ese valor del enum
			combinacion.add(fruta);
		}
		
		return combinacion;
	}

	
	public ArrayList<Fruta> jugar(){
		if(isJugadaDisponible()) {
			credito -= precioJugada;
			ArrayList<Fruta> combinacion = generarCombinacion();
			for(Premio p: premios) {
				if(combinacion.equals(p.getCombinacion())) {
					credito += p.getCantidad();
				}
			}
			return combinacion;
		}
		return null;
	}
	@Override
	public String toString() {
		return "Maquina [casillas=" + casillas + ", precioJugada=" + precioJugada + ", credito=" + credito
				+ ", premios=" + premios + "]";
	}
	
	
	
}
