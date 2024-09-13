class Solution {
    public int[] xorQueries(int[] arr, int[][] queries) {
        if (arr == null || arr.length == 0) {
            return new int[]{};
        }

        int n = arr.length;
        int[] prefixXor = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefixXor[i + 1] = prefixXor[i] ^ arr[i];
        }

        int[] result = new int[queries.length];
        
        for (int i = 0; i < queries.length; i++) {
            int left = queries[i][0];
            int right = queries[i][1];

            result[i] = prefixXor[right + 1] ^ prefixXor[left];
        }

        return result;
    }
}
