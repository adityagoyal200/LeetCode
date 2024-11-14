class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        if (n == 0 || quantities.length == 0) {
            return 0;
        }

        int low = 1; 
        int high = -1;
        for (int quant : quantities) {
            high = Math.max(quant,high);
        }

        while (low < high) {
            int mid = low + (high - low) / 2; 
            if (isPossible(n, mid, quantities)) {
                high = mid;
            } else {
                low = mid + 1; 
            }
        }

        return high;
    }

    private boolean isPossible(int n, int max, int[] quantities) {
        for (int quant : quantities) {
            n -= (int) Math.ceil((double) quant / max);
            if (n < 0) return false; 
        }
        return true;
    }
}
