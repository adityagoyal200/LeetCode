class Solution {
    public int maxWidthRamp(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        int n = nums.length, top = 0, ans = 0;
        int[] stack = new int[n];

        for (int i = 1; i < n; i++) {
            if (nums[i] < nums[stack[top]]) {
                stack[++top] = i;
            }
        }

        for (int i = n - 1; i > ans; i--) {
            while (top >= 0 && nums[i] >= nums[stack[top]]) {
                top--;
            }
            ans = Math.max(ans, i - stack[top + 1]);
        }

        return ans;
    }
}