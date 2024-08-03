class Solution {
    public int maxSubArray(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int sum  = 0;
        int max = Integer.MIN_VALUE;
        // int ansStart = -1;
        // int ansEnd = -1;
        for(int i = 0 ;i < nums.length; i++){
            sum += nums[i];
            if(sum > max){
                max = sum;
                // ansEnd = i;
            }
            if(sum < 0){
                sum = 0;
                // ansStart = i;
            }
        }

        return max;
    }
}