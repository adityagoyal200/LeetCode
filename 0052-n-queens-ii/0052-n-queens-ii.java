class Solution {
    int count;
    public int totalNQueens(int n) {
        if(n <= 0 || n == 2 || n == 3){
            return 0;
        }
        
        if(n == 1){
            return 1;
        }

        count = 0;
        int[][] grid = new int[n][n];
        solve(grid,0,n);

        return count;
    }
    private void solve(int[][] grid,int row,int n){
        //base
        if(row == n){
            count++;
            return;
        }

        //logic
        for(int col = 0; col < n; col++){
            if(isSafe(grid,row,col)){
                grid[row][col] = 1; 
                solve(grid,row+1,n);
                grid[row][col] = 0;
            }
        }
    }
    private boolean isSafe(int[][] grid,int row,int col){
        //check row
        for(int i = row; i >= 0; i--){
            if(grid[i][col] == 1){
                return false;
            }
        }

        int i = row;
        int j = col;

        while(i >= 0 && j >= 0){
            if(grid[i][j] == 1){
                return false;
            }
            i--;
            j--;
        }

        i = row;
        j = col;
        while(i >= 0 && j < grid.length){
            if(grid[i][j] == 1){
                return false;
            }
            i--;
            j++;
        }

        return true;
    }
}