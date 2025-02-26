class Solution {
    public int longestMonotonicSubarray(int[] nums) {
        int maxLength = 1, inc = 1, dec = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > nums[i - 1]) inc = inc + 1; else inc = 1;
            if (nums[i] < nums[i - 1]) dec = dec + 1; else dec = 1;
            maxLength = Math.max(maxLength, Math.max(inc, dec));
        }
        return maxLength;
    }
}
