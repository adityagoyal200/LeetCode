class Solution {
    public int longestOnes(int[] nums, int k) {
        if(nums == null  || nums.length == 0){
            return 0;
        }

        int zeros = 0;
        int left = 0;
        int right  = 0;
        int max = 0;
        int currLen = 0;
        
        while(right < nums.length){
            if(nums[right] == 0) zeros++;
            
            if(zeros > k){
                if(nums[left] == 0) zeros--;
                left++;
            }

            if(zeros <= k){
                currLen = right - left +1;
                max = Math.max(currLen , max);
            }
            
            right++;
        }

        return max;
    }
}