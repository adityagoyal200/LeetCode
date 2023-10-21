import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    List<int[]> result; 
    int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};

    public int[][] findFarmland(int[][] land) {
        int m = land.length;
        int n = land[0].length;

        result = new ArrayList<>();
        if (m == 0 || land == null) {
            return new int[0][0];
        }

        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (land[i][j] == 1 && !visited[i][j]) {
                    List<Integer> ans = new ArrayList<>();
                    ans.add(i);
                    ans.add(j);
                    bfs(land, visited, ans, i, j);
                }
            }
        }

        int[][] resultArray = new int[result.size()][4];
        for (int i = 0; i < result.size(); i++) {
            int[] farmland = result.get(i);
            for (int j = 0; j < 4; j++) {
                resultArray[i][j] = farmland[j];
            }
        }

        return resultArray;
    }

    private void bfs(int[][] land, boolean[][] visited, List<Integer> ans, int row, int col) {
        int m = land.length;
        int n = land[0].length;

        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{row, col});
        visited[row][col] = true;
        int[] last = new int[2];

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cell = q.poll();
                if (i == size - 1) {
                    last[0] = cell[0];
                    last[1] = cell[1];
                }
                for (int[] dir : dirs) {
                    int newR = cell[0] + dir[0];
                    int newC = cell[1] + dir[1];

                    if (newR < 0 || newR >= m || newC < 0 || newC >= n || visited[newR][newC] || land[newR][newC] != 1) {
                        continue;
                    }
                    q.offer(new int[]{newR, newC});
                    visited[newR][newC] = true;
                }
            }
        }

        ans.add(last[0]);
        ans.add(last[1]);
        int[] farmland = new int[4];
        for (int i = 0; i < 4; i++) {
            farmland[i] = ans.get(i);
        }
        result.add(farmland);
    }
}
