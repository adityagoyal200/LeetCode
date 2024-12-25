class Solution {
    public int numEnclaves(int[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;

        for(int i = 0; i < m; i++){
            if(grid[i][0] == 1){
                helper(grid,i,0);
            }
            if(grid[i][n-1] == 1){
                helper(grid,i,n-1);
            }
        }
        for(int j = 0; j < n; j++){
            if(grid[0][j] == 1){
                helper(grid,0,j);
            }
            if(grid[m-1][j] == 1){
                helper(grid,m-1,j);
            }
        }

        int cnt = 0;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(grid[i][j] == 1){
                    cnt++;
                }
            }
        }

        return cnt;
    }
    private void helper(int[][] grid, int row, int col){
        if(row < 0 || row >= grid.length || col < 0 ||
         col >= grid[0].length || grid[row][col] == -1 || grid[row][col] == 0){
            return;
        }

        grid[row][col] = -1;
        helper(grid,row+1,col);
        helper(grid,row-1,col);
        helper(grid,row,col+1);
        helper(grid,row,col-1);
    }
}