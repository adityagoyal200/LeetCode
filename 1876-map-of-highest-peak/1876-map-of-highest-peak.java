class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int m = isWater.length, n = isWater[0].length;
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isWater[i][j] == 1) {
                    isWater[i][j] = 0;
                    q.offer(new int[]{i, j});
                } else {
                    isWater[i][j] = -1;
                }
            }
        }
        int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
        while (!q.isEmpty()) {
            int[] cell = q.poll();
            for (int[] dir : directions) {
                int r = cell[0] + dir[0], c = cell[1] + dir[1];
                if (r >= 0 && r < m && c >= 0 && c < n && isWater[r][c] == -1) {
                    isWater[r][c] = isWater[cell[0]][cell[1]] + 1;
                    q.offer(new int[]{r, c});
                }
            }
        }
        
        return isWater;
    }
}
