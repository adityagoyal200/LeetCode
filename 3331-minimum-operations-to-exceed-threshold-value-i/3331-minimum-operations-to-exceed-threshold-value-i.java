class Solution {
    public int minOperations(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        
        int n = nums.length;
        int count = 0 ;

        for(int i=0; i<n; i++){
            if(nums[i]< k){
               count++;
            }
        }

        return count;
    }
}