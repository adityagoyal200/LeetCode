class Solution {
    int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    
    public int shortestPath(int[][] grid, int k) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        
        int m = grid.length;
        int n = grid[0].length;
        
        // If we can eliminate enough obstacles, the direct shortest path is the answer
        if (k >= m + n - 2) {
            return m + n - 2;
        }

        int[][][] visited = new int[m][n][k + 1];
        for (int[][] rows : visited) {
            for (int[] row : rows) {
                Arrays.fill(row, Integer.MAX_VALUE);
            }
        }
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0, k, 0});
        visited[0][0][k] = 0;
        
        while (!queue.isEmpty()) {
            int[] cell = queue.poll();
            int r = cell[0];
            int c = cell[1];
            int power = cell[2];
            int dist = cell[3];
            
            if (r == m - 1 && c == n - 1) {
                return dist;
            }
            
            for (int[] dir : directions) {
                int newR = r + dir[0];
                int newC = c + dir[1];
                
                // Check if new position is within grid bounds
                if (newR >= 0 && newR < m && newC >= 0 && newC < n) {
                    int newPower = power;

                    if (grid[newR][newC] == 1) {
                        newPower--; 
                    }
                    
                    if (newPower >= 0 && dist + 1 < visited[newR][newC][newPower]) {
                        visited[newR][newC][newPower] = dist + 1;
                        queue.offer(new int[] {newR, newC, newPower, dist + 1});
                    }
                }
            }
        }
        
        return -1;
    }
}
