class Solution {
    boolean[][] visited;
    public int maxAreaOfIsland(int[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }

        int maxArea = 0;
        visited = new boolean[grid.length][grid[0].length];
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] != 0 && !visited[i][j]){
                    maxArea = Math.max(maxArea,helper(grid,i,j,0));
                }
            }
        }

        return maxArea;
    }
    private int helper(int[][] grid,int row,int col,int cnt){
        //base
        if(row < 0 || row >= grid.length || col < 0 || col >= grid[0].length
            || visited[row][col] || grid[row][col] == 0){
            return 0;
        }

        visited[row][col] = true;
        cnt = 1;

        cnt += helper(grid,row+1,col,0);
        cnt += helper(grid,row-1,col,0);
        cnt += helper(grid,row,col+1,0);
        cnt += helper(grid,row,col-1,0);

        return cnt;
    }
}