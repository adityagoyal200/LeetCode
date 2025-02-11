class Solution(object):
    def closedIsland(self, grid):
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        if not grid:
            return 0

        m, n = len(grid), len(grid[0])
        directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]

        def dfs(row, col):
            if row < 0 or row >= m or col < 0 or col >= n:
                return False

            if grid[row][col] == 1:
                return True

            grid[row][col] = 1
            is_closed = True

            for dr, dc in directions:
                if not dfs(row + dr, col + dc):
                    is_closed = False

            return is_closed

        count = 0
        for i in range(m):
            for j in range(n):
                if grid[i][j] == 0:
                    count += dfs(i, j)

        return count

