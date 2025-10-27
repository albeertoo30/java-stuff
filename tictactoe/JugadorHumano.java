package tictactoe;

import java.util.Scanner;

public class JugadorHumano implements Jugador {
	
    private char ficha;
    private Scanner scanner;
    
    public JugadorHumano(char ficha, Scanner scanner) {
        this.ficha = ficha;
        this.scanner = scanner;
    }
    
    @Override
    public Movimiento getMovimiento(Tablero tablero) {
        int fila, columna;
        boolean movimientoValido = false;
        
        while (!movimientoValido) {
            System.out.print("Tu turno (" + ficha + "). Ingresa fila (0-2): ");
            fila = scanner.nextInt();
            System.out.print("Ingresa columna (0-2): ");
            columna = scanner.nextInt();
            
            if (tablero.esPosicionValida(fila, columna)) {
                return new Movimiento(fila, columna);
            } else {
                System.out.println("Movimiento inválido. Intenta de nuevo.");
            }
        }
        return null;
    }
    
    @Override
    public char getFicha() {
        return ficha;
    }
    
    @Override
    public String getNombre() {
        return "Jugador";
    }
}