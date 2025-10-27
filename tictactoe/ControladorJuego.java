package tictactoe;

import java.util.Scanner;

public class ControladorJuego {
	
    private Tablero tablero;
    private Jugador jugador1;
    private Jugador jugador2;
    private Jugador jugadorActual;
    private VistaConsola vista;
    private boolean juegoTerminado;
    
    public ControladorJuego() {
        this.tablero = new Tablero();
        this.vista = new VistaConsola();
        Scanner scanner = new Scanner(System.in);
        this.jugador1 = new JugadorHumano('X', scanner);
        this.jugador2 = new JugadorCPU('O');
        this.jugadorActual = jugador1; // El jugador humano empieza
        this.juegoTerminado = false;
    }
    
    public void iniciarJuego() {
        vista.mostrarBienvenida();
        
        while (!juegoTerminado) {
            vista.mostrarTablero(tablero);
            
            // Obtener y realizar movimiento
            Movimiento movimiento = jugadorActual.getMovimiento(tablero);
            tablero.colocarFicha(movimiento.getFila(), movimiento.getColumna(), 
                                jugadorActual.getFicha());
            
            // Verificar estado del juego
            if (verificarFinJuego()) {
                vista.mostrarTablero(tablero);
                break;
            }
            
            // Cambiar de jugador
            cambiarTurno();
        }
    }
    
    private boolean verificarFinJuego() {
        char ganador = tablero.verificarGanador();
        
        if (ganador != '-') {
            if (ganador == jugador1.getFicha()) {
                vista.mostrarGanador(jugador1.getNombre());
            } else {
                vista.mostrarGanador(jugador2.getNombre());
            }
            juegoTerminado = true;
            return true;
        }
        
        if (tablero.estaLleno()) {
            vista.mostrarEmpate();
            juegoTerminado = true;
            return true;
        }
        
        return false;
    }
    
    private void cambiarTurno() {
        jugadorActual = (jugadorActual == jugador1) ? jugador2 : jugador1;
    }
}