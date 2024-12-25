class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }

        int cntIslands = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for(int i = 0; i < grid.length;i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1' && !visited[i][j]){
                    cntIslands++;
                    dfs(grid,i,j,visited);
                }
            }
        }

        return cntIslands;
    }
    private void dfs(char[][] grid, int row, int col, boolean[][] visited){
        if(row < 0 || row >= grid.length || col < 0 || 
            col >= grid[0].length || visited[row][col] || grid[row][col] != '1'){
            return;
        }

        visited[row][col] = true;
        dfs(grid,row+1,col,visited);
        dfs(grid,row-1,col,visited);
        dfs(grid,row,col+1,visited);
        dfs(grid,row,col-1,visited);
    }
}