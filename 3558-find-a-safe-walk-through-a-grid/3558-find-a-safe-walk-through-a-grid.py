class Solution(object):
    def findSafeWalk(self, grid, health):
        """
        :type grid: List[List[int]]
        :type health: int
        :rtype: bool
        """
        m, n = len(grid), len(grid[0])
        directions = [(0, 1), (1, 0), (0, -1), (-1, 0)]

        queue = deque()
        if grid[0][0] == 1:
            health -= 1
        if health < 1:
            return False

        queue.append((0, 0, health))
        visited = [[-1] * n for _ in range(m)]
        visited[0][0] = health

        while queue:
            x, y, current_health = queue.popleft()

            if x == m - 1 and y == n - 1:
                if grid[x][y] == 1:
                    health -= 1
                return health > 0

            for dx, dy in directions:
                new_x, new_y = x + dx, y + dy

                if 0 <= new_x < m and 0 <= new_y < n:
                    new_health = current_health - (1 if grid[new_x][new_y] == 1 else 0)

                    if new_health > 0 and new_health > visited[new_x][new_y]:
                        visited[new_x][new_y] = new_health
                        queue.append((new_x, new_y, new_health))

        return False
