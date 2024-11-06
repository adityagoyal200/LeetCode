class Solution {
    public static boolean canSortArray(final int[] nums) {
        short prevMax = 0, currMin = 0, currMax = 0;
        byte prevCount = 0;

        for (final int num : nums) {
            final byte currCount = (byte) Integer.bitCount(num);

            if (prevCount == currCount) {
                currMin = (short) Math.min(currMin, num);
                currMax = (short) Math.max(currMax, num);
            } else {
                if (currMin < prevMax) {
                    return false;
                }

                prevMax = currMax;
                currMin = currMax = (short) num;
                prevCount = currCount;
            }
        }

        return currMin >= prevMax;
    }
}
