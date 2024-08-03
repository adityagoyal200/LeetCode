import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int[][] findFarmland(int[][] land) {
        int m = land.length;
        int n = land[0].length;

        List<int[]> result = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] == 1) {
                    int[] farmland = bfs(land, i, j);
                    result.add(farmland);
                }
            }
        }

        return result.toArray(new int[0][0]);
    }

    private int[] bfs(int[][] land, int row, int col) {
        int m = land.length;
        int n = land[0].length;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{row, col});
        land[row][col] = -1; // Mark as visited

        int[] farmland = new int[]{row, col, row, col};

        while (!q.isEmpty()) {
            int[] cell = q.poll();

            for (int[] dir : dirs) {
                int newR = cell[0] + dir[0];
                int newC = cell[1] + dir[1];

                if (newR >= 0 && newR < m && newC >= 0 && newC < n && land[newR][newC] == 1) {
                    q.offer(new int[]{newR, newC});
                    land[newR][newC] = -1; // Mark as visited
                    farmland[2] = Math.max(farmland[2], newR);
                    farmland[3] = Math.max(farmland[3], newC);
                }
            }
        }

        return farmland;
    }
}

