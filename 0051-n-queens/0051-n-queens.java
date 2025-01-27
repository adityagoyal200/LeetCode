class Solution {
    List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {
        if(n <= 0 || n == 2 || n == 3){
            return new ArrayList<>();
        }

        result = new ArrayList<>();
        int[][] board = new int[n][n];
        helper(board,0,n);

        return result;
    }
    private void helper(int[][] board,int row,int n){
        if(row == n){
            List<String> temp = new ArrayList<>();
            for(int i = 0; i <n; i++){
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j< n; j++){
                    if(board[i][j] == 1){
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                temp.add(sb.toString());
            }
            result.add(temp);
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
    private boolean isSafe(int[][] board,int row, int col, int n){ 
        for(int i = row; i >= 0; i--){
            if(board[i][col] == 1) return false;
        }

        int i = row; int  j = col;
        while(i >= 0 && j >= 0){
            if(board[i][j] == 1) return false;
            i--;j--;
        }

        i = row;
        j = col;

        while(i >= 0 && j < n){
            if(board[i][j] == 1) return false;
            i--;j++;
        }

        return true;
    }
}