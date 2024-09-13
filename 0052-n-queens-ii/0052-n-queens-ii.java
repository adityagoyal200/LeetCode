class Solution {
    int count = 0;
    public int totalNQueens(int n) {
        if(n <= 0 || n == 2 ||n == 3){
            return 0;
        }

        if(n == 1){
            return 1;
        }

        int[][] board = new int[n][n];

        helper(board,0,n);

        return count;
    }
    private void helper(int[][] board, int row, int n){
        //base
        if(row == n){
            count++;
            return;
        }

        //logic
        for(int col = 0; col < n; col++){
            if(isSafe(board,row,col,n)){
                board[row][col] = 1;
                helper(board,row+1,n);
                board[row][col] = 0;
            }
        }
    }
    private boolean isSafe(int[][] board,int row, int col, int n){
        for(int i = row; i >= 0; i--){
            if(board[i][col] == 1){
                return false;
            }
        }

        int i = row;
        int j = col; 

        //upper left
        while(i >= 0 && j >= 0){
            if(board[i][j] == 1){
                return false;
            }

            i--;
            j--;
        }

        i = row;
        j = col; 

        //upper right daignol
        while(i >= 0 && j < n){
            if(board[i][j] == 1 ){
                return false;
            }

            i--;
            j++;
        }

        return true;
    }
}