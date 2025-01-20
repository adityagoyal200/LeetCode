class Solution {
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length, n = mat[0].length;
        Map<Integer, Integer> pos = new HashMap<>();
        
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                pos.put(mat[i][j], i * n + j);

                
        int[] row = new int[m], col = new int[n];
        for (int i = 0; i < arr.length; i++) {
            int index = pos.get(arr[i]);
            int r = index / n, c = index % n;
            if (++row[r] == n || ++col[c] == m) return i;
        }

        return -1;
    }
}
