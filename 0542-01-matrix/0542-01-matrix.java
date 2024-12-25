class Solution {
    public int[][] updateMatrix(int[][] mat) {
        if (mat == null || mat.length == 0) {
            return mat;
        }
        
        int m = mat.length, n = mat[0].length;
        Queue<int[]> queue = initializeQueue(mat, m, n);
        bfsUpdate(mat, queue, m, n);

        return mat;
    }

    private Queue<int[]> initializeQueue(int[][] mat, int m, int n) {
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    queue.offer(new int[] { i, j });
                } else {
                    mat[i][j] = -1;
                }
            }
        }
        return queue;
    }

    private void bfsUpdate(int[][] mat, Queue<int[]> queue, int m, int n) {
        int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        int dist = 1;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cell = queue.poll();
                for (int[] dir : directions) {
                    int row = cell[0] + dir[0];
                    int col = cell[1] + dir[1];
                    if (isValid(row, col, mat, m, n)) {
                        mat[row][col] = dist;
                        queue.offer(new int[] { row, col });
                    }
                }
            }
            dist++;
        }
    }

    private boolean isValid(int row, int col, int[][] mat, int m, int n) {
        return (row >= 0 && row < m && col >= 0 && col < n && mat[row][col] == -1);
    }
}
