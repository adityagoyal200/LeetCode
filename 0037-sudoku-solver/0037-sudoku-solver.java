class Solution {
    public void solveSudoku(char[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        
        solve(board);
    }

    private boolean solve(char[][] board) {
        int[] emptyCell = findEmptyCell(board);
        if (emptyCell == null) {
            return true; // No empty cells
        }

        int row = emptyCell[0];
        int col = emptyCell[1];

        for (char num = '1'; num <= '9'; num++) {
            if (isSafe(board, row, col, num)) {
                board[row][col] = num;
                if (solve(board)) {
                    return true;
                } else {
                    board[row][col] = '.'; // Backtrack
                }
            }
        }

        return false; // Trigger backtracking
    }

    private int[] findEmptyCell(char[][] board) {
        int n = board.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == '.') {
                    return new int[]{i, j};
                }
            }
        }
        return null; // No empty cells found
    }

    private boolean isSafe(char[][] board, int row, int col, char num) {
        // Check row
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == num) {
                return false;
            }
        }

        // Check column
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == num) {
                return false;
            }
        }

        // Check 3x3 subgrid
        int sqrt = (int) Math.sqrt(board.length);
        int rowStart = row - row % sqrt;
        int colStart = col - col % sqrt;

        for (int i = rowStart; i < rowStart + sqrt; i++) {
            for (int j = colStart; j < colStart + sqrt; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }

        return true;
    }
}

