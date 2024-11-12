public class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        if (items == null || items.length == 0) {
            return new int[] {};
        }

        Arrays.sort(items, (a, b) -> Integer.compare(a[0], b[0]));

        int n = items.length;
        int[] maxBeautyAtPrice = new int[n];
        maxBeautyAtPrice[0] = items[0][1];  

        for (int i = 1; i < n; i++) {
            maxBeautyAtPrice[i] = Math.max(maxBeautyAtPrice[i - 1], items[i][1]);
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int x = queries[i];
            int left = 0, right = n - 1, bestB = 0;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (items[mid][0] <= x) {
                    bestB = maxBeautyAtPrice[mid];
                    left = mid + 1; 
                } else {
                    right = mid - 1; 
                }
            }

            ans[i] = bestB;
        }

        return ans;
    }
}
