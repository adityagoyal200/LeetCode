class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0 || word == null || word.length() == 0) {
            return false;
        }

        int rows = board.length;
        int cols = board[0].length;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (board[i][j] == word.charAt(0)) {
                    boolean[][] visited = new boolean[rows][cols];
                    if (helper(board, i, j, 0, word, visited)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean helper(char[][] board, int row, int col, int index, String word, boolean[][] visited) {
        // Base cases
        if (index == word.length()) {
            return true;
        }

        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != word.charAt(index) || visited[row][col]) {
            return false;
        }

        // Mark the cell as visited
        visited[row][col] = true;

        // Explore all four directions
        boolean found = helper(board, row + 1, col, index + 1, word, visited)
                     || helper(board, row - 1, col, index + 1, word, visited)
                     || helper(board, row, col + 1, index + 1, word, visited)
                     || helper(board, row, col - 1, index + 1, word, visited);

        // Unmark the cell (backtrack)
        visited[row][col] = false;

        return found;
    }
}
