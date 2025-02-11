class Solution(object):
    def countSubIslands(self, grid1, grid2):
        """
        :type grid1: List[List[int]]
        :type grid2: List[List[int]]
        :rtype: int
        """
        if not grid1 or not grid2:
            return 0

        m, n = len(grid2), len(grid2[0])
        visited = [[False] * n for _ in range(m)]
        count = 0

        def bfs(row, col):
            queue = deque([(row, col)])
            visited[row][col] = True
            is_sub_island = True
            directions = [(1, 0), (0, 1), (-1, 0), (0, -1)]

            while queue:
                r, c = queue.popleft()
                
                for dr, dc in directions:
                    new_r, new_c = r + dr, c + dc

                    if 0 <= new_r < m and 0 <= new_c < n and grid2[new_r][new_c] == 1 and not visited[new_r][new_c]:
                        if grid1[new_r][new_c] != 1:
                            is_sub_island = False
                        queue.append((new_r, new_c))
                        visited[new_r][new_c] = True
            
            return 1 if is_sub_island else 0

        for i in range(m):
            for j in range(n):
                if grid2[i][j] == 1 and grid1[i][j] == 1 and not visited[i][j]:
                    count += bfs(i, j)

        return count
