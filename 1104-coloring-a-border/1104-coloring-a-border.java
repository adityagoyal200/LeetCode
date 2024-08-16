class Solution {
    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        if (grid == null || grid.length == 0) {
            return grid;
        }

        int originalColor = grid[row][col];

        Queue<int[]> q = new LinkedList<>();
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        q.offer(new int[]{row, col});
        visited[row][col] = true;

        int[][] dirs = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        LinkedList<int[]> borders = new LinkedList<>();

        while (!q.isEmpty()) {
            int[] cell = q.poll();
            int r = cell[0], c = cell[1];
            boolean isBorder = false;

            for (int[] dir : dirs) {
                int newR = r + dir[0];
                int newC = c + dir[1];

                if (newR < 0 || newR >= grid.length || newC < 0 || newC >= grid[0].length) {
                    isBorder = true; 
                } else if (grid[newR][newC] != originalColor) {
                    isBorder = true; 
                } else if (!visited[newR][newC]) {
                    q.offer(new int[]{newR, newC});
                    visited[newR][newC] = true;
                }
            }

            if (isBorder) {
                borders.add(new int[]{r, c});
            }
        }

        for (int[] border : borders) {
            grid[border[0]][border[1]] = color;
        }

        return grid;
    }
}
