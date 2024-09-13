class Solution {
    public List<List<String>> solveNQueens(int n) {
        
        List<List<String>> result = new ArrayList<>();

        if(n <= 0 || n == 2 || n == 3){
            return result;
        }

        int[][] board = new int[n][n];
        helper(board,result,0,n);

        return result;

    }
    private void helper(int[][] board,List<List<String>> result,int row,int n){
        //base
        if(row == n){
            List<String> temp = new ArrayList<>();
            for(int i = 0; i < n; i++){
               StringBuilder sb = new StringBuilder();
                for(int j = 0; j < n; j++){
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

        //logic
        for(int col = 0; col <  n; col++){
            if(isSafe(board,row,col,n)){
                board[row][col] = 1;
                helper(board,result,row+1,n);
                board[row][col] = 0;
            }
        }
    }
    private boolean isSafe(int[][] board,int row,int col,int n){
        for(int i = row; i >= 0; i--){
            if(board[i][col] == 1){
                return false;
            }
        }

        int i = row,j=col;
        while(i >=0 && j >=0){

            if(board[i][j] == 1){
                return false;
            }

            i--;
            j--;
        }

        i = row; j= col;
        while(i >= 0 && j < n){

            if(board[i][j] == 1){
                return false;
            }

            i--;
            j++;
        }

        return true;
    }
}