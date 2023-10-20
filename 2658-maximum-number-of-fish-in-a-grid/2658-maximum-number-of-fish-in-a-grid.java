class Solution {
    public int findMaxFish(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int max = 0;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0 && !visited[i][j]) {
                    max = Math.max(max, dfs(grid, i, j, visited, 0));
                }
            }
        }

        return max;
    }

    public int dfs(int[][] grid, int row, int col, boolean[][] visited, int fish) {
        int m = grid.length;
        int n = grid[0].length;

        if (row < 0 || row >= m || col < 0 || col >= n || visited[row][col] || grid[row][col] == 0) {
            return 0;
        }

        visited[row][col] = true;
        fish = fish + grid[row][col] + dfs(grid, row + 1, col, visited, fish) + dfs(grid, row - 1, col, visited, fish) + dfs(grid, row, col + 1, visited, fish) + dfs(grid, row, col - 1, visited, fish);

        return fish;
    }
}


