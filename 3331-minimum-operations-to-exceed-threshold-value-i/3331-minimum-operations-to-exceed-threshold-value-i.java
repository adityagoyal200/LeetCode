class Solution {
    public int minOperations(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        int count = 0 ;

        for(int num: nums){
            count += (num < k) ? 1 : 0;
        }

        return count;
    }
}