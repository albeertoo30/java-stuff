package tictactoe;

public class VistaConsola {
    
    public void mostrarBienvenida() {
        System.out.println("=== BIENVENIDO AL TIC TAC TOE ===");
        System.out.println("Tú eres X, la CPU es O");
    }
    
    public void mostrarTablero(Tablero tablero) {
        char[][] casillas = tablero.getCasillas();
        System.out.println("\n  0 1 2");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + " ");
            for (int j = 0; j < 3; j++) {
                System.out.print(casillas[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    public void mostrarGanador(String nombreJugador) {
        System.out.println("¡" + nombreJugador + " ha ganado!");
    }
    
    public void mostrarEmpate() {
        System.out.println("¡Empate! El tablero está lleno.");
    }
}