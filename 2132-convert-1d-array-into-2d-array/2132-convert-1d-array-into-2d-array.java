class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        if (original == null || original.length != m * n) {
            return new int[][]{};
        }
        
        int[][] arr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = original[i * n + j];
            }
        }

        return arr;
    }
}
