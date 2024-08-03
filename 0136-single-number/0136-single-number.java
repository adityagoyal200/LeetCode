class Solution {
    public int singleNumber(int[] nums) {
        
        if(nums == null || nums.length == 0){
            return 0;
        }

        int res = 0;
        for(int num: nums){
            res ^= num;
        }

        return res;
    }
}