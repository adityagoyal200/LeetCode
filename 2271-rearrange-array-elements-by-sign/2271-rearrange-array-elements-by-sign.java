class Solution {
    public int[] rearrangeArray(int[] nums) {
        if(nums == null || nums.length == 0){
            return nums;
        }
        int[] ans = new int[nums.length];
        int pos = 0;
        int neg = 1;
        for(int i = 0; i<nums.length; i++){
            if(nums[i] < 0){
                ans[neg] = nums[i];
                neg += 2;
            }else {
                ans[pos] = nums[i];
                pos += 2;
            }
        }

        return ans;
    }
}