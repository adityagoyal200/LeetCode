class Solution {
    public static boolean canSortArray(int[] nums) {
        int prevMax = 0, currMin = 0, currMax = 0;
        byte prevCount = 0;

        for (int num : nums) {
            byte currCount = (byte) Integer.bitCount(num);

            if (prevCount == currCount) {
                currMin = Math.min(currMin, num);
                currMax = Math.max(currMax, num);
            } else {
                if (currMin < prevMax) {
                    return false;
                }
                prevMax = currMax;
                currMin = currMax = num;
                prevCount = currCount;
            }
        }
        
        return currMin >= prevMax;
    }
}
