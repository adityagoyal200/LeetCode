class Solution {
    int[][] directions = {{1,0},{-1,0},{0,1},{0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        if(heights == null || heights.length == 0){
            return new ArrayList<>();
        }

        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i < m; i++){
            dfs(heights,pacific,i,0);
            dfs(heights,atlantic,i,n-1);
        }

        for(int i = 0; i < n; i++){
            dfs(heights,pacific,0,i);
            dfs(heights,atlantic,m-1,i);
        }

        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(pacific[i][j] && atlantic[i][j]){
                    result.add(Arrays.asList(i,j));
                }
            }
        }

        return result;
    }
    private void dfs(int[][] grid,boolean[][] ocean, int row, int col){
        ocean[row][col] = true;
        
        for(int[] dir: directions){
            int newR = dir[0] + row;
            int newC = dir[1] + col;
            if(newR >= 0 && newR < grid.length && newC >= 0 && newC < grid[0].length &&
            !ocean[newR][newC] && grid[newR][newC] >= grid[row][col]){
                dfs(grid,ocean,newR,newC);
            }
        }
    }
}