class Solution {
    int steps;
    Queue<int[]> q;
    boolean[][] visited;
    int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}}; // Define the four possible directions to move.

    public int nearestExit(char[][] maze, int[] entrance) {
        int m = maze.length;
        int n = maze[0].length;

        if (m == 0 || maze == null) {
            return -1;
        }

        visited = new boolean[m][n];
        q = new LinkedList<>();
        steps = 0; // Initialize steps to 0.
        q.offer(new int[]{entrance[0], entrance[1]});
        visited[entrance[0]][entrance[1]] = true;

        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] cell = q.poll();
                if ((cell[0] != entrance[0] || cell[1] != entrance[1]) &&
                 (cell[0] == 0 || cell[1] == 0 || cell[0] == m - 1 || cell[1] == n - 1)) {
                    return steps; 
                }
                for (int[] dir : directions) {
                    int newR = dir[0] + cell[0];
                    int newC = dir[1] + cell[1];
                    if (newR >= 0 && newR < m && newC >= 0 && newC < n && maze[newR][newC] == '.' && !visited[newR][newC]) {
                        q.offer(new int[]{newR, newC});
                        visited[newR][newC] = true;
                    }
                }
            }
            steps++; 
        }

        return -1; 
    }
}

