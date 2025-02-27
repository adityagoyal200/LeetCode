class Solution {
    public int lenLongestFibSubseq(int[] arr) {
        if (arr == null || arr.length < 3) {
            return 0;
        }

        Map<Integer, Integer> indexMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            indexMap.put(arr[i], i);
        }

        int maxLen = 0;
        int[][] dp = new int[arr.length][arr.length];

        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                // Look for arr[k] such that arr[k] + arr[j] = arr[i], i.e., arr[k] = arr[i] - arr[j]
                int diff = arr[i] - arr[j];
                if (diff < arr[j] && indexMap.containsKey(diff)) {
                    int k = indexMap.get(diff);
                    dp[j][i] = dp[k][j] + 1;
                    maxLen = Math.max(maxLen, dp[j][i]);
                } else {
                    dp[j][i] = 2; // Start a new Fibonacci sequence with arr[j] and arr[i]
                }
            }
        }

        return maxLen >= 3 ? maxLen : 0;
    }
}
