class Solution {
    public int[][] restoreMatrix(int[] row, int[] col) {
        int R = row.length;
        int C = col.length;
        int[][] matrix = new int[R][C];

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                int min = 0;
                if (row[r] < col[c]) {
                    min = row[r];
                    row[r] = row[r] - min;
                    col[c] = col[c] - min;
                } else {
                    min = col[c];
                    col[c] = col[c] - min;
                    row[r] = row[r] - min;
                }
                matrix[r][c] = min;

            }
        }
        return matrix;
    }
}