import java.util.Scanner;

public class TicTacToeGame {
    private Board board;
    private Player playerX;
    private Player playerO;
    private Player currentPlayer;

    public TicTacToeGame(String playerXName, String playerOName) {
        board = new Board();
        playerX = new Player(playerXName, 'X');
        playerO = new Player(playerOName, 'O');
        currentPlayer = playerX; // Player X goes first
    }

    public void playGame() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            board.displayBoard();
            System.out.println(currentPlayer.getName() + ", enter your move (row and column, separated by space): ");
            int row = scanner.nextInt();
            int col = scanner.nextInt();

            if (isValidMove(row, col)) {
                board.getCell(row, col).setSymbol(currentPlayer.getSymbol());

                if (isWinner()) {
                    board.displayBoard();
                    System.out.println(currentPlayer.getName() + " wins!");
                    break;
                } else if (board.isBoardFull()) {
                    board.displayBoard();
                    System.out.println("It's a tie!");
                    break;
                }

                // Switch to the next player
                currentPlayer = (currentPlayer == playerX) ? playerO : playerX;
            } else {
                System.out.println("Invalid move. Try again.");
            }
        }

        scanner.close();
    }

    private boolean isValidMove(int row, int col) {
        // Check if the chosen cell is within the board bounds and not already occupied
        return row >= 0 && row < 3 && col >= 0 && col < 3 && board.getCell(row, col).getSymbol() == ' ';
    }

    private boolean isWinner() {
        // Check for a winner in rows, columns, and diagonals
        return checkRows() || checkColumns() || checkDiagonals();
    }

    private boolean checkRows() {
        for (int i = 0; i < 3; i++) {
            if (board.getCell(i, 0).getSymbol() == currentPlayer.getSymbol() &&
                    board.getCell(i, 1).getSymbol() == currentPlayer.getSymbol() &&
                    board.getCell(i, 2).getSymbol() == currentPlayer.getSymbol()) {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumns() {
        for (int i = 0; i < 3; i++) {
            if (board.getCell(0, i).getSymbol() == currentPlayer.getSymbol() &&
                    board.getCell(1, i).getSymbol() == currentPlayer.getSymbol() &&
                    board.getCell(2, i).getSymbol() == currentPlayer.getSymbol()) {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonals() {
        return (board.getCell(0, 0).getSymbol() == currentPlayer.getSymbol() &&
                board.getCell(1, 1).getSymbol() == currentPlayer.getSymbol() &&
                board.getCell(2, 2).getSymbol() == currentPlayer.getSymbol()) ||
                (board.getCell(0, 2).getSymbol() == currentPlayer.getSymbol() &&
                        board.getCell(1, 1).getSymbol() == currentPlayer.getSymbol() &&
                        board.getCell(2, 0).getSymbol() == currentPlayer.getSymbol());
    }

    public static void main(String[] args) {
        TicTacToeGame game = new TicTacToeGame("PlayerX", "PlayerO");
        game.playGame();
    }
}

