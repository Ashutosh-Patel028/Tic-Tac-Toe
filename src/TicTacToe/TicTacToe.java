package TicTacToe;

import java.util.Scanner;

public class TicTacToe {

	public static void main(String[] args) {
		char[][] board = new char[3][3];

		// initialize board with empty spaces
		for (int row = 0; row < board.length; row++) {
			for (int col = 0; col < board[row].length; col++) {
				board[row][col] = ' ';
			}
		}
		char player = 'X';
		boolean gameOver = false;
		Scanner sc = new Scanner(System.in);

		System.out.println("\nWelcome to Tic-Tac-Toe Console Game 🎲\n");

		while (!gameOver) {
			System.out.println("Current Status of Board:");
			printBoard(board);
			System.out.print("Player " + player + " enter: ");
			int row = sc.nextInt();
			int col = sc.nextInt();

			if (row < 3 && row >= 0 && col >= 0 && col < 3 && board[row][col] == ' ') {
				// place the element on the board
				board[row][col] = player;
				gameOver = haveWon(board, player);
				if (gameOver) {
					System.out.println("\nPlayer " + player + " has won! 🎉");
					System.out.println("\nThank You for playing Tic-Tac-Toe Console Game! 🎲");
				} else {
					player = (player == 'X') ? 'O' : 'X';
				}
			} else {
				System.out.println("\n⚠Invalid Move. Try again!\n");
			}
		}

		sc.close();
	}

	// Method to check Winner
	public static boolean haveWon(char[][] board, char player) {
		// check rows for winner
		for (int row = 0; row < board.length; row++) {
			if (board[row][0] == player && board[row][1] == player && board[row][2] == player) {
				return true;
			}
		}
		// check columns for winner
		for (int col = 0; col < board.length; col++) {
			if (board[0][col] == player && board[1][col] == player && board[2][col] == player) {
				return true;
			}
		}

		// check Principal diagonal for winner
		if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
			return true;
		}
		// check secondary diagonal for winner
		if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
			return true;
		}
		return false;
	}

	// Method to print Board on console
	public static void printBoard(char[][] board) {
		for (int row = 0; row < board.length; row++) {
			System.out.print("\t" + "|");
			for (int col = 0; col < board[row].length; col++) {
				System.out.print(board[row][col] + "|");
			}
			System.out.println();
		}
	}

}
