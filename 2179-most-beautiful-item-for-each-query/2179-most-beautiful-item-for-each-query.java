public class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        int maxI = Integer.MAX_VALUE;
        List<int[]> res = new ArrayList<>();
        res.add(new int[] {0, 0, maxI});

        Arrays.sort(items, (a,b)-> a[0]-b[0]);

        for (int[] item : items) {
            int price = item[0];
            int beauty = item[1];
            int[] lastBracket = res.get(res.size() - 1);

            if (beauty > lastBracket[1]) {
                lastBracket[2] = price;
                res.add(new int[] {price, beauty, maxI});
            }
        }

        int[] ans = new int[queries.length];
        for (int j = 0; j < queries.length; j++) {
            int x = queries[j];
            int left = 0, right = res.size() - 1, bestBeauty = 0;
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (res.get(mid)[0] <= x) {
                    bestBeauty = Math.max(bestBeauty,res.get(mid)[1]);
                    left = mid + 1; 
                } else {
                    right = mid - 1; 
                }
            }
            
            ans[j] = bestBeauty;
        }

        return ans;
    }
}
