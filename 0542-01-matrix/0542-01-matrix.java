class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length, n = mat[0].length;
        int[][] result = new int[m][n];
        int maxDist = m + n; 

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    result[i][j] = 0;
                } else {
                    result[i][j] = maxDist;
                }
            }
        }

        // First pass: Check top and left neighbors
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] != 0) {
                    if (i > 0) {
                        result[i][j] = Math.min(result[i][j], result[i - 1][j] + 1);
                    }
                    if (j > 0) {
                        result[i][j] = Math.min(result[i][j], result[i][j - 1] + 1);
                    }
                }
            }
        }

        // Second pass: Check bottom and right neighbors
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (mat[i][j] != 0) {
                    if (i < m - 1) {
                        result[i][j] = Math.min(result[i][j], result[i + 1][j] + 1);
                    }
                    if (j < n - 1) {
                        result[i][j] = Math.min(result[i][j], result[i][j + 1] + 1);
                    }
                }
            }
        }

        return result;
    }
}
