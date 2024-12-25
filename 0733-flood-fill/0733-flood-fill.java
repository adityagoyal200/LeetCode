class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image == null || image.length == 0){
            return image;
        }

        int original = image[sr][sc];
        helper(image,sr,sc,original,color);
        return image;
    }
    private void helper(int[][] grid,int row, int col,int original,int color){
        if(row < 0 || row >= grid.length || col < 0 
        || col >= grid[0].length || grid[row][col] != original || grid[row][col] == color){
            return;
        }
        
        
        grid[row][col] = color;
        helper(grid,row+1,col,original,color);
        helper(grid,row-1,col,original,color);
        helper(grid,row,col+1,original,color);
        helper(grid,row,col-1,original,color);
        
    }
}