package tictactoe;

public class Tablero {
	
	 private char[][] casillas;
	 private static final int TAMANIO = 3;
	 private static final char VACIO = '-';
	    
	 public Tablero() {
		 casillas = new char[TAMANIO][TAMANIO];
	     inicializar();
	 }
	    
	 private void inicializar() {
	     for (int i = 0; i < TAMANIO; i++) {
	         for (int j = 0; j < TAMANIO; j++) {
	             casillas[i][j] = VACIO;
	         }
	     }
	 }
	    
	 public boolean esPosicionValida(int fila, int columna) {
	     if (fila < 0 || fila >= TAMANIO || columna < 0 || columna >= TAMANIO) {
	         return false;
	     }
	     return casillas[fila][columna] == VACIO;
	 }
	    
		    public void colocarFicha(int fila, int columna, char ficha) {
		        if (esPosicionValida(fila, columna)) {
		            casillas[fila][columna] = ficha;
		        }
		    }
		    
		    public char verificarGanador() {
		        // Verificar filas
		        for (int i = 0; i < TAMANIO; i++) {
		            if (casillas[i][0] != VACIO && 
		                casillas[i][0] == casillas[i][1] && 
		                casillas[i][1] == casillas[i][2]) {
		                return casillas[i][0];
		            }
		        }
		        
		        // Verificar columnas
		        for (int j = 0; j < TAMANIO; j++) {
		            if (casillas[0][j] != VACIO && 
		                casillas[0][j] == casillas[1][j] && 
		                casillas[1][j] == casillas[2][j]) {
		                return casillas[0][j];
		            }
		        }
		        
		        // Verificar diagonal principal
		        if (casillas[0][0] != VACIO && 
		            casillas[0][0] == casillas[1][1] && 
		            casillas[1][1] == casillas[2][2]) {
		            return casillas[0][0];
		        }
		        
		        // Verificar diagonal secundaria
		        if (casillas[0][2] != VACIO && 
		            casillas[0][2] == casillas[1][1] && 
		            casillas[1][1] == casillas[2][0]) {
		            return casillas[0][2];
		        }
		        
		        return VACIO;
		    }
		    
		    public boolean estaLleno() {
		        for (int i = 0; i < TAMANIO; i++) {
		            for (int j = 0; j < TAMANIO; j++) {
		                if (casillas[i][j] == VACIO) {
		                    return false;
		                }
		            }
		        }
		        return true;
		    }
		    
		    public char[][] getCasillas() {
		        return casillas;
		    }
	
}
