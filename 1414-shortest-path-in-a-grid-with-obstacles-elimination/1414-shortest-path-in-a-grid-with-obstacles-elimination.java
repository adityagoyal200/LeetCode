class Solution {
    int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    
    public int shortestPath(int[][] grid, int k) {
        int m = grid.length, n = grid[0].length;

        // Early return if we can bypass all obstacles
        if (k >= m + n - 2) {
            return m + n - 2;
        }

        // 3D visited array (row, col, remaining obstacle eliminations)
        boolean[][][] visited = new boolean[m][n][k + 1];
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0, k, 0});
        visited[0][0][k] = true;
        
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0], c = cell[1], remainingK = cell[2], dist = cell[3];
            
            if (r == m - 1 && c == n - 1) {
                return dist;
            }
            
            for (int[] dir : directions) {
                int newR = r + dir[0];
                int newC = c + dir[1];
                
                if (newR >= 0 && newR < m && newC >= 0 && newC < n) {
                    int newK = remainingK;

                    if (grid[newR][newC] == 1) {
                        newK--;  
                    }

                    // If we can still eliminate obstacles and haven't visited this state
                    if (newK >= 0 && !visited[newR][newC][newK]) {
                        visited[newR][newC][newK] = true;
                        queue.offer(new int[] {newR, newC, newK, dist + 1});
                    }
                }
            }
        }
        
        return -1;
    }
}
