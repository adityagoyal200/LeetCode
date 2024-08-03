class Solution {
    Queue<int[]> q = new LinkedList<>();

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int fresh = 0;
        int time = -1;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[]{i, j});
                }
                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        if (fresh == 0 && q.isEmpty()) {
            return 0;
        }

        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cell = q.poll();
                int r = cell[0];
                int c = cell[1];
                for (int[] dir : directions) {
                    int newR = r + dir[0];
                    int newC = c + dir[1];

                    if (newR >= 0 && newR < m && newC >= 0 && newC < n && grid[newR][newC] == 1) {
                        q.offer(new int[]{newR, newC});
                        grid[newR][newC] = 2;
                        fresh--;
                    }
                }
            }
            time++;
        }

        return (fresh == 0) ? time : -1;
    }
}

