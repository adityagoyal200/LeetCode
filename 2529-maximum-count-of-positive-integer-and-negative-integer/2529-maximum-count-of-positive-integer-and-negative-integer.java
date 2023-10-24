class Solution {
    public int maximumCount(int[] nums) {
        if (nums[0] > 0 || nums[nums.length - 1] < 0) {
            return nums.length;
        }
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < 0) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        int negativeCount = left;
        left = 0;
        right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > 0) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        int positiveCount = nums.length - left;
        return Math.max(negativeCount, positiveCount);
    }
}



 