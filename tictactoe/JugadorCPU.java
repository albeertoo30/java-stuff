package tictactoe;

import java.util.Random;

public class JugadorCPU implements Jugador {
	
    private char ficha;
    private Random random;
    
    public JugadorCPU(char ficha) {
        this.ficha = ficha;
        this.random = new Random();
    }
    
    @Override
    public Movimiento getMovimiento(Tablero tablero) {
        int fila, columna;
        
        System.out.println("Turno de la CPU (" + ficha + ")...");
        
        do {
            fila = random.nextInt(3);
            columna = random.nextInt(3);
        } while (!tablero.esPosicionValida(fila, columna));
        
        System.out.println("CPU colocó en: fila " + fila + ", columna " + columna);
        return new Movimiento(fila, columna);
    }
    
    @Override
    public char getFicha() {
        return ficha;
    }
    
    @Override
    public String getNombre() {
        return "CPU";
    }
}