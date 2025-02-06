class Solution(object):
    def pacificAtlantic(self, heights):
        """
        :type heights: List[List[int]]
        :rtype: List[List[int]]
        """
        if not heights or not heights[0]:
            return []

        m, n = len(heights), len(heights[0])

        pacific = [[False] * n for _ in range(m)]
        atlantic = [[False] * n for _ in range(m)]

        result = []
        
        directions = [(1, 0), (-1, 0), (0, 1), (0, -1)]

        def dfs(grid, ocean, row, col):
            ocean[row][col] = True
            for dir in directions:
                newR, newC = row + dir[0], col + dir[1]
                if 0 <= newR < m and 0 <= newC < n and not ocean[newR][newC] and grid[newR][newC] >= grid[row][col]:
                    dfs(grid, ocean, newR, newC)

        for i in range(m):
            dfs(heights, pacific, i, 0)
            dfs(heights, atlantic, i, n - 1)

        for i in range(n):
            dfs(heights, pacific, 0, i)
            dfs(heights, atlantic, m - 1, i)

        for i in range(m):
            for j in range(n):
                if pacific[i][j] and atlantic[i][j]:
                    result.append([i, j])

        return result
