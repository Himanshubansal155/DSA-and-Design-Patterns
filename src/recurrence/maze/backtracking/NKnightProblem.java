package recurrence.maze.backtracking;

public class NKnightProblem {

    static int count;

    public static void main(String[] args) {
        // Place N knights/horses in their places and find pattersn
        boolean[][] board = new boolean[4][4];
        knights(board, 0, 0, 4);
        System.out.println(count);

    }

    private static void knights(boolean[][] board, int row, int col, int knights) {
        if (knights == 0) {
            display(board);
            count++;
            System.out.println();
            return;
        }

        if (row == board.length - 1 && col == board.length) {
            return;
        }

        if (col == board.length) {
            knights(board, row + 1, 0, knights);
            return;
        }

        if (isSafe(board, row, col)) {
            board[row][col] = true;
            knights(board, row, col + 1, knights - 1);
            board[row][col] = false;
        }

        knights(board, row, col + 1, knights);

    }

    private static boolean isSafe(boolean[][] board, int row, int col) {

        if (isValid(board, row - 1, col + 2) && board[row - 1][col + 2]) {
            return false;
        }

        if (isValid(board, row - 1, col - 2) && board[row - 1][col - 2]) {
            return false;
        }

        if (isValid(board, row - 2, col - 1) && board[row - 2][col - 1]) {
            return false;
        }

        return !(isValid(board, row - 2, col + 1) && board[row - 2][col + 1]);
    }

    private static boolean isValid(boolean[][] board, int row, int col) {
        return (row > 0 && row < board.length && col > 0 && col < board.length);
    }

    private static void display(boolean[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board.length; col++) {
                if (board[row][col]) {
                    System.out.print("K ");
                } else {
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }
}
