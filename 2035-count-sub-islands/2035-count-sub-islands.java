import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        boolean[][] islands = new boolean[grid1.length][grid1[0].length];

        // Mark islands in grid1
        for (int i = 0; i < grid1.length; i++) {
            for (int j = 0; j < grid1[0].length; j++) {
                if (grid1[i][j] == 1 && !islands[i][j]) {
                    helper(grid1, i, j, islands);
                }
            }
        }

        // Traverse grid2 and count sub-islands
        boolean[][] visited = new boolean[grid2.length][grid2[0].length];
        int count = 0;
        for (int i = 0; i < grid2.length; i++) {
            for (int j = 0; j < grid2[0].length; j++) {
                if (grid2[i][j] == 1 && !visited[i][j] && islands[i][j]) {
                    count += helper2(grid2, i, j, islands, visited);
                }
            }
        }

        return count;
    }

    private void helper(int[][] grid, int row, int col, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        q.offer(new int[] { row, col });
        visited[row][col] = true;

        while (!q.isEmpty()) {
            int[] cell = q.poll();
            for (int[] dir : dirs) {
                int newR = cell[0] + dir[0];
                int newC = cell[1] + dir[1];

                if (newR >= 0 && newR < grid.length && newC >= 0 &&
                        newC < grid[0].length && grid[newR][newC] == 1 && !visited[newR][newC]) {
                    q.offer(new int[] { newR, newC });
                    visited[newR][newC] = true;
                }
            }
        }
    }

    private int helper2(int[][] grid, int row, int col, boolean[][] islands, boolean[][] visited) {
        Queue<int[]> q = new LinkedList<>();
        int[][] dirs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        q.offer(new int[] { row, col });
        visited[row][col] = true;
        boolean isSubIsland = true;

        while (!q.isEmpty()) {
            int[] cell = q.poll();
            for (int[] dir : dirs) {
                int newR = cell[0] + dir[0];
                int newC = cell[1] + dir[1];

                if (newR >= 0 && newR < grid.length && newC >= 0 &&
                        newC < grid[0].length && grid[newR][newC] == 1) {

                    if (!visited[newR][newC]) {
                        if (!islands[newR][newC]) {
                            isSubIsland = false;
                        }
                        q.offer(new int[] { newR, newC });
                        visited[newR][newC] = true;
                    }
                }
            }
        }

        return isSubIsland ? 1 : 0;
    }
}
