class Solution {
    // Track numbers in rows, columns, and subgrids
    private boolean[][] rows = new boolean[9][9];
    private boolean[][] cols = new boolean[9][9];
    private boolean[][] subgrids = new boolean[9][9];

    public void solveSudoku(char[][] board) {
        // Initialize tracking arrays based on the current state of the board
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    int num = board[i][j] - '1';
                    int subgridIndex = (i / 3) * 3 + j / 3;
                    rows[i][num] = true;
                    cols[j][num] = true;
                    subgrids[subgridIndex][num] = true;
                }
            }
        }
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    // Try placing digits 1-9
                    for (char num = '1'; num <= '9'; num++) {
                        int digit = num - '1';
                        int subgridIndex = (i / 3) * 3 + j / 3;

                        if (!rows[i][digit] && !cols[j][digit] && !subgrids[subgridIndex][digit]) {
                            // Place the number and mark it
                            board[i][j] = num;
                            rows[i][digit] = true;
                            cols[j][digit] = true;
                            subgrids[subgridIndex][digit] = true;

                            // Recur with this choice
                            if (solve(board)) {
                                return true;
                            } else {
                                // Backtrack
                                board[i][j] = '.';
                                rows[i][digit] = false;
                                cols[j][digit] = false;
                                subgrids[subgridIndex][digit] = false;
                            }
                        }
                    }
                    return false;  // If no number fits, trigger backtracking
                }
            }
        }
        return true;  // Solution found
    }
}

