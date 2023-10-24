class Solution {
    private static final int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int shortestBridge(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        if(n == 0 || grid == null){
            return -1;
        }
        
        Queue<int[]> queue = new LinkedList<>();
        boolean foundFirstIsland = false;

        // Step 1: Find the first island and mark it
        for (int i = 0; i < n; i++) {
            if (foundFirstIsland) {
                break;
            }
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    dfs(grid, i, j, queue);
                    foundFirstIsland = true;
                    break;
                }
            }
        }

        // Step 2: Expand the first island and flip its values to -1
        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                for (int[] dir : directions) {
                    int newRow = cell[0] + dir[0];
                    int newCol = cell[1] + dir[1];
                    if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m) {
                        if (grid[newRow][newCol] == 0) {
                            grid[newRow][newCol] = -1;
                            queue.offer(new int[]{newRow, newCol});
                        } else if (grid[newRow][newCol] == 1) {
                            return steps;
                        }
                    }
                }
            }
            steps++;
        }

        // Step 3: Expand the second island
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                for (int[] dir : directions) {
                    int newRow = cell[0] + dir[0];
                    int newCol = cell[1] + dir[1];
                    if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m) {
                        if (grid[newRow][newCol] == 0) {
                            grid[newRow][newCol] = -1;
                            queue.offer(new int[]{newRow, newCol});
                        }
                    }
                }
            }
            steps++;
        }

        return -1;
    }

    private void dfs(int[][] grid, int row, int col, Queue<int[]> queue) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length || grid[row][col] != 1) {
            return;
        }

        grid[row][col] = -1; 
        queue.offer(new int[]{row, col}); 

        for (int[] dir : directions) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            dfs(grid, newRow, newCol, queue);
        }
    }
}


