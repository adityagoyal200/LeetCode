class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        int originalColor = image[sr][sc];

        if (m == 0 || originalColor == color) {
            return image;
        }

        if (originalColor != color) {
            bfs(image, sr, sc, originalColor, color);
        }

        return image;
    }

    private void bfs(int[][] image, int sr, int sc, int originalColor, int color) {
        int m = image.length;
        int n = image[0].length;

        int[][] directions = {{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{sr, sc});
        image[sr][sc] = color;

        while (!q.isEmpty()) {
            int[] cell = q.poll();
            for (int[] dir : directions) {
                int newR = cell[0] + dir[0];
                int newC = cell[1] + dir[1];

                if (newR < 0 || newR > m - 1 || newC < 0 || newC > n - 1 || image[newR][newC] != originalColor) {
                    continue;
                }

                image[newR][newC] = color;
                q.offer(new int[]{newR, newC});
            }
        }
    }
}
