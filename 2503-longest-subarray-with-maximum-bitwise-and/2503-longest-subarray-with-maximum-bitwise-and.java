class Solution {
    public int longestSubarray(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        int max = Integer.MIN_VALUE;
        for (int num : nums) {
            max = Math.max(max, num);  
        }

        int len = 1;
        int length = 0;
        for (int num : nums) { 
            if (num == max) {
                length++;
            } else {
                len = Math.max(len, length);
                length = 0;
            }
        }

        len = Math.max(len, length);

        return len;
    }
}