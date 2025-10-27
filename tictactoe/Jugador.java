package tictactoe;

public interface Jugador {
	
	Movimiento getMovimiento(Tablero tablero);
	char getFicha();
	String getNombre();
}
