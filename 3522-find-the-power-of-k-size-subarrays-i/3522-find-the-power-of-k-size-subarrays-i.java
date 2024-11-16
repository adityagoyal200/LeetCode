class Solution {
    public int[] resultsArray(int[] nums, int k) {
        if (nums == null || nums.length < k || k <= 0) {
            return new int[0];
        }

        int n = nums.length;
        int[] result = new int[n - k + 1];
        
        for (int i = 0; i <= n - k; i++) {
            if (isConsecutive(nums, i, i + k - 1)) {
                result[i] = nums[i + k - 1];
            } else {
                result[i] = -1;
            }
        }
        
        return result;
    }

    private boolean isConsecutive(int[] nums, int start, int end) {
        for (int i = start; i < end; i++) {
            if (nums[i] + 1 != nums[i + 1]) {
                return false;
            }
        }
        
        return true;
    }
}
