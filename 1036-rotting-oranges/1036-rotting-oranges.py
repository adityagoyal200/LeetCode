class Solution:
    def orangesRotting(self, grid):
        if not grid:
            return -1

        q = deque()
        for i in range(len(grid)):
            for j in range(len(grid[0])):
                if grid[i][j] == 2:
                    q.append((i, j))

        cnt = self.countRotten(grid, q)

        for row in grid:
            if 1 in row:
                return -1

        return 0 if cnt == 0 else cnt - 1

    def countRotten(self, grid, q):
        m, n = len(grid), len(grid[0])
        directions = [(1, 0), (-1, 0), (0, 1), (0, -1)]
        cnt = 0

        while q:
            for _ in range(len(q)):
                r, c = q.popleft()
                for dr, dc in directions:
                    new_r, new_c = r + dr, c + dc

                    if 0 <= new_r < m and 0 <= new_c < n and grid[new_r][new_c] == 1:
                        grid[new_r][new_c] = 2
                        q.append((new_r, new_c))

            cnt += 1

        return cnt
