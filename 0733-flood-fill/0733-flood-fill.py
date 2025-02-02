class Solution(object):
    def floodFill(self, image, sr, sc, color):
        """
        :type image: List[List[int]]
        :type sr: int
        :type sc: int
        :type color: int
        :rtype: List[List[int]]
        """
        if image is None or len(image) == 0:
            return image
        
        original = image[sr][sc]
        self.dfs(image,sr,sc,original,color)

        return image
    
    def dfs(self,grid,row,col,original,color):
        if row < 0 or row >= len(grid) or col < 0 or col >= len(grid[0]) or grid[row][col] != original or grid[row][col] == color:
            return
        
        grid[row][col] = color
        self.dfs(grid,row+1,col,original,color)
        self.dfs(grid,row-1,col,original,color)
        self.dfs(grid,row,col+1,original,color)
        self.dfs(grid,row,col-1,original,color)