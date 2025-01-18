class Solution {
    
    private static final int[][] DIRECTIONS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    
    public int minCost(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] costs = new int[m][n];
        for (int[] c : costs) Arrays.fill(c, Integer.MAX_VALUE);
        costs[0][0] = 0;

        PriorityQueue<int[]> heap = new PriorityQueue<>((a, b) -> a[2] - b[2]);
        heap.offer(new int[]{0, 0, 0});

        while (!heap.isEmpty()) {
            int[] curr = heap.poll();
            int x = curr[0], y = curr[1], cost = curr[2];
            if (x == m - 1 && y == n - 1) return cost;

            for (int i = 0; i < 4; i++) {
                int[] dir = DIRECTIONS[i];
                int newX = x + dir[0], newY = y + dir[1];
                if (newX < 0 || newY < 0 || newX >= m || newY >= n) continue;

                int newCost = cost + (i + 1 == grid[x][y] ? 0 : 1); 
                if (costs[newX][newY] > newCost) {
                    costs[newX][newY] = newCost;
                    heap.offer(new int[]{newX, newY, newCost});
                }
            }
        }

        return -1;
    }
}
