class Solution {
    List<List<String>> result;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();

        if(n <= 0) return result;

        int[][] board = new int[n][n];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n;j++){
                board[i][j] = 0;
            }
        }

        solve(board,0);

        return result;
    }
    private void solve(int[][] board,int row){
        if(row == board.length){
            List<String> temp = new ArrayList<>();
            for(int i = 0; i < board.length; i++){
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < board[0].length; j++){
                    if(board[i][j] == 1){
                        sb.append("Q");
                    } else {
                        sb.append(".");
                    }
                }
                temp.add(sb.toString());
            }
            result.add(temp);
        }


        for(int col = 0; col < board.length; col++){
            if(isSafe(board,row,col)){
                board[row][col] = 1;
                solve(board,row+1);
                board[row][col] = 0;
            } 
        }
    }

    private boolean isSafe(int[][] board,int row, int col){
        for(int i = 0; i < board.length; i++){
            if(board[i][col] == 1){
                return false;
            }
        }

        int i = row;
        int j = col;

        while(i >= 0 && j >= 0){
            if(board[i][j] == 1){
                return false;
            }
            i--;
            j--;
        }

        i = row;
        j = col;

        while(i >= 0 && j < board.length){
            if(board[i][j] == 1){
                return false;
            }
            i--;
            j++;
        }

        return true;
    }
}