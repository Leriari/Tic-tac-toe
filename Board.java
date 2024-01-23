public class Board {
    private Cell[][] cells;

    public Board() {
        cells = new Cell[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                cells[i][j] = new Cell();
            }
        }
    }

    public void displayBoard() {
        // Display the current state of the board
        // You can customize the formatting based on your preferences
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(cells[i][j].getSymbol() + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public Cell getCell(int row, int col) {
        return cells[row][col];
    }

    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (cells[i][j].getSymbol() == ' ') {
                    return false; // If any cell is empty, the board is not full
                }
            }
        }
        return true; // All cells are filled, board is full
    }
}
