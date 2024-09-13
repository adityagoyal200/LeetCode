class Solution {
    public int getMaximumGold(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int count = gridWithNoZeroes(grid);
        if(count != -1){
            return count;
        }

        int m = grid.length;
        int n = grid[0].length;
        int maxGold = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    maxGold = Math.max(maxGold, collectGold(grid, i, j));
                }
            }
        }

        return maxGold;
    }

    public int gridWithNoZeroes(int[][] grid){
        int count=0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == 0){
                    return -1;
                }
                else{
                    count += grid[i][j];
                }
            }
        }

        return count;
    }

    private int collectGold(int[][] grid, int row, int col) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] == 0 || grid[row][col] == -1) {
            return 0;
        }

        int gold = grid[row][col];
        int temp = gold;
        grid[row][col] = -1; 

        int maxGold = 0;
        maxGold = Math.max(maxGold, collectGold(grid, row + 1, col));
        maxGold = Math.max(maxGold, collectGold(grid, row - 1, col));
        maxGold = Math.max(maxGold, collectGold(grid, row, col + 1));
        maxGold = Math.max(maxGold, collectGold(grid, row, col - 1));

        grid[row][col] = temp;

        return gold + maxGold;
    }
}
