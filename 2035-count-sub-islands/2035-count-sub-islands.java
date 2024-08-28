class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        if(grid1.length == 0 || grid2.length == 0){
            return 0;
        }

        boolean[][] visited = new boolean[grid2.length][grid2[0].length];
        int count = 0;
        for (int i = 0; i < grid2.length; i++) {
            for (int j = 0; j < grid2[0].length; j++) {
                if(grid2[i][j] == 1 && grid1[i][j] == 1 && !visited[i][j]){
                    count += helper(grid1,grid2,i,j,visited);
                }
            }
        }

        return count;
    }

    private int helper(int[][] grid1, int[][] grid2, int row, int col,boolean[][] visited) {
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

                if (newR >= 0 && newR < grid2.length && newC >= 0 &&
                        newC < grid2[0].length && grid2[newR][newC] == 1) {

                    if (!visited[newR][newC]) {
                        if (newR > grid1.length || newC > grid1[0].length || 
                            grid1[newR][newC] != 1){
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
