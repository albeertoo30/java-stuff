package game;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Puzzle8 puzzle = new Puzzle8(); // tablero aleatorio
        Scanner scanner = new Scanner(System.in);

        while (true) {
            puzzle.printBoard();
            if (puzzle.isSolved()) {
                System.out.println("¡Felicidades! Has resuelto el puzzle.");
                break;
            }

            System.out.println("Introduce un movimiento (up, down, left, right): ");
            String move = scanner.nextLine();

            if (!puzzle.move(move)) {
                System.out.println("Movimiento inválido. Intenta de nuevo.");
            }
        }

        scanner.close();
    }
}
