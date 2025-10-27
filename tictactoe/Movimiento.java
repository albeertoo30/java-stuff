package tictactoe;

public class Movimiento {
	
	private int fila;
    private int columna;
    
    public Movimiento(int fila, int columna) {
        this.fila = fila;
        this.columna = columna;
    }
    
    public int getFila() {
        return fila;
    }
    
    public int getColumna() {
        return columna;
    }
	
}
