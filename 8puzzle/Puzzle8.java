package game;

import java.util.Arrays;
import java.util.Random;

public class Puzzle8 {
    private int[][] board;
    private int emptyRow;
    private int emptyCol;
    private Random random = new Random();

    public Puzzle8() {
        board = new int[3][3];
        initializeRandomBoard(20); // 20 movimientos aleatorios por defecto
    }

    public Puzzle8(int[][] initialBoard) {
        board = new int[3][3];
        for (int i = 0; i < 3; i++) {
            board[i] = Arrays.copyOf(initialBoard[i], 3);
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == 0) {
                    emptyRow = i;
                    emptyCol = j;
                }
            }
        }
    }

 // Método para inicializar el tablero aleatoriamente
    public void initializeRandomBoard(int moves) {
        // Empezamos desde el tablero resuelto
        int count = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = count;
                count++;
            }
        }
        board[2][2] = 0; // espacio vacío
        emptyRow = 2;
        emptyCol = 2;

        // Movimientos aleatorios para desordenar
        String[] directions = {"up", "down", "left", "right"};
        for (int i = 0; i < moves; i++) {
			move(directions[random.nextInt(4)]);
        }
    }
    
    public boolean move(String direction) {
        int newRow = emptyRow;
        int newCol = emptyCol;

        switch (direction.toLowerCase()) {
            case "up": newRow++; break;
            case "down": newRow--; break;
            case "left": newCol++; break;
            case "right": newCol--; break;
            default: return false;
        }

        if (newRow >= 0 && newRow < 3 && newCol >= 0 && newCol < 3) {
            board[emptyRow][emptyCol] = board[newRow][newCol];
            board[newRow][newCol] = 0;
            emptyRow = newRow;
            emptyCol = newCol;
            return true;
        }
        return false;
    }

    public boolean isSolved() {
        int count = 1;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (i == 2 && j == 2) {
                    if (board[i][j] != 0) return false;
                } else if (board[i][j] != count) {
                    return false;
                }
                count++;
            }
        }
        return true;
    }

    public void printBoard() {
        System.out.println("-------");
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] == 0 ? " " : board[i][j]);
                System.out.print(" ");
            }
            System.out.println();
        }
        System.out.println("-------");
    }
}
