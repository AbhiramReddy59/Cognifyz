import java.util.*;

public class TicTacToe {
    public static void main(String[] args) {
        // Create a sc object for input
        Scanner sc = new Scanner(System.in);

        // Variables to control the game
        boolean playAgain = true;

        // Main loop to play multiple rounds
        while (playAgain) {
            // Initialize the game board
            char[][] board = new char[3][3];
            initializeBoard(board);

            // Track whose turn it is (X or O)
            char currentPlayer = 'X';
            boolean gameOver = false;

            // Start the game loop
            while (!gameOver) {
                displayBoard(board);

                // Prompt the current player for a move
                System.out.println("Player " + currentPlayer + "'s turn!");
                System.out.print("Enter row (1-3): ");
                int row = sc.nextInt() - 1; // Subtract 1 to make it 0-indexed
                System.out.print("Enter column (1-3): ");
                int col = sc.nextInt() - 1; // Subtract 1 to make it 0-indexed

                // Check if the cell is valid (empty)java -cp ".;json-20240303.jar" CurrencyConverter

                if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ') {
                    board[row][col] = currentPlayer; // Place the player's mark
                } else {
                    System.out.println("Invalid move, try again.");
                    continue; // Skip to the next iteration to ask for a valid move
                }

                // Check for a winner
                if (checkWin(board, currentPlayer)) {
                    displayBoard(board);
                    System.out.println("Player " + currentPlayer + " wins!");
                    gameOver = true;
                } else if (isBoardFull(board)) {
                    // Check for a draw
                    displayBoard(board);
                    System.out.println("It's a draw!");
                    gameOver = true;
                } else {
                    // Switch players
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }
            }

            // Ask if the players want to play again
            System.out.print("Do you want to play again? (y/n): ");
            char playAgainInput = sc.next().charAt(0);
            playAgain = (playAgainInput == 'y' || playAgainInput == 'Y');
        }

        // Close the sc when done
        sc.close();
    }

    // Function to initialize the board
    public static void initializeBoard(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' '; // Empty spaces on the board
            }
        }
    }

    // Function to display the board
    public static void displayBoard(char[][] board) {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    // Function to check if a player has won
    public static boolean checkWin(char[][] board, char player) {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
        }

        // Check columns
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }

        // Check diagonals
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }

        return false;
    }

    // Function to check if the board is full (draw)
    public static boolean isBoardFull(char[][] board) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false; // Empty spot found
                }
            }
        }
        return true; // No empty spots, board is full
    }
}
