class Solution {
    private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        if (heights == null || heights.length == 0) {
            return new ArrayList<>();
        }

        int m = heights.length;
        int n = heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            dfs(heights, pacific, i, 0); 
            dfs(heights, atlantic, i, n - 1); 
        }
        for (int j = 0; j < n; j++) {
            dfs(heights, pacific, 0, j); 
            dfs(heights, atlantic, m - 1, j); 
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i, j));
                }
            }
        }

        return result;
    }

    private void dfs(int[][] heights, boolean[][] ocean, int row, int col) {
        ocean[row][col] = true;

        for (int[] dir : DIRECTIONS) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];
            if (newRow >= 0 && newRow < heights.length &&
                newCol >= 0 && newCol < heights[0].length &&
                !ocean[newRow][newCol] && heights[newRow][newCol] >= heights[row][col]) {
                dfs(heights, ocean, newRow, newCol);
            }
        }
    }
}

