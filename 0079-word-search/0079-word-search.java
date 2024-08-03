class Solution {
    int[][] dirs;
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        dirs = new int[][] {{1,0},{0,1},{-1,0},{0,-1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (backtrack(board, word, i, j, 0)){
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean backtrack(char[][] board, String word, int row, int col, int index) {
        int m = board.length;
        int n = board[0].length;

        // base
        if (index == word.length()) {
            return true;
        }

        if (row < 0 || row >= m || col < 0 || col >= n || board[row][col] != word.charAt(index)) {
            return false;
        }


        if(board[row][col] == word.charAt(index)){
            char temp = board[row][col];
            board[row][col] = '#';
            for(int[] dir: dirs){
                int newR = row + dir[0];
                int newC =  col + dir[1];

                if(backtrack(board,word,newR,newC,index+1)){
                    board[row][col] = temp;
                    return true;
                }
            }
            board[row][col] = temp;
        }
        return false;
    }
}

