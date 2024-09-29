class Solution {
    public long maximumTotalSum(int[] maximumHeight) {
        Arrays.sort(maximumHeight);

        long sum = 0;
        int lastHeight = Integer.MAX_VALUE;

        for (int i = maximumHeight.length - 1; i >= 0; i--) {
            lastHeight = Math.min(maximumHeight[i], lastHeight - 1);
            if (lastHeight < 1) {
                return -1;
            }
            sum += lastHeight;
        }

        return sum;
    }
}
