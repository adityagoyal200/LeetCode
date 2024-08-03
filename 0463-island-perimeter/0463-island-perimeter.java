import java.util.LinkedList;
import java.util.Queue;

class Solution {
    int peri;

    public int islandPerimeter(int[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        peri = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    bfs(grid, i, j, visited);
                }
            }
        }

        return peri;
    }

    private void bfs(int[][] grid, int row, int col, boolean[][] visited) {
        int m = grid.length;
        int n = grid[0].length;
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{row, col});
        visited[row][col] = true;

        int[][] directions = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cell = q.poll();
                peri += sides(grid, cell[0], cell[1]);
                for (int[] dir : directions) {
                    int newR = cell[0] + dir[0];
                    int newC = cell[1] + dir[1];

                    if (newR < 0 || newR >= m || newC < 0 || newC >= n || visited[newR][newC] || grid[newR][newC] == 0) {
                        continue;
                    }
                    q.offer(new int[]{newR, newC});
                    visited[newR][newC] = true;
                }
            }
        }
    }

    private int sides(int[][] grid, int row, int col) {
        int left = 0;
        int right = 0;
        int down = 0;
        int up = 0;

        if (row - 1 < 0 || grid[row - 1][col] == 0) {
            up = 1;
        }
        if (row + 1 >= grid.length || grid[row + 1][col] == 0) {
            down = 1;
        }
        if (col - 1 < 0 || grid[row][col - 1] == 0) {
            left = 1;
        }
        if (col + 1 >= grid[0].length || grid[row][col + 1] == 0) {
            right = 1;
        }

        return up + down + left + right;
    }
}
