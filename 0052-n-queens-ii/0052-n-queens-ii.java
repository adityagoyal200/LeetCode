class Solution {
    int cnt;
    public int totalNQueens(int n) {
        if(n <= 0 || n == 2 || n == 3){
            return 0;
        }

        cnt = 0;
        int[][] board = new int[n][n];
        helper(board,0,n);

        return cnt;
        
    }
    private void helper(int[][] board, int row, int n){
        if(row == n){
            cnt++;
            return;
        }

        for(int col = 0; col < n; col++){
            if(isSafe(board,row,col,n)){
                board[row][col] = 1;
                helper(board,row+1,n);
                board[row][col] = 0;
            }
        }
    }
    private boolean isSafe(int[][] board, int row, int col, int n){
        for(int i = row; i >= 0; i--){
            if(board[i][col] == 1) return false;
        }

        int i = row; int j = col;

        while(i >= 0 && j >= 0){
            if(board[i][j] == 1) return false;
            i--;
            j--;
        }

        i = row; j = col;

        while(i >= 0 && j < n){
            if(board[i][j] == 1) return false;
            i--;
            j++;
        }

        return true;
    }
}