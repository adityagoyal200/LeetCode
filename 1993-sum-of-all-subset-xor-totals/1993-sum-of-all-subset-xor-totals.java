class Solution {
    public int subsetXORSum(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        int count = 0;
        count = helper(nums,0,0);

        return count;
    }
    private int helper(int[] nums,int index, int xor){
        if(index == nums.length){
            return xor;
        }

        int include =  helper(nums,index+1,xor ^ nums[index]);
        int exclude = helper(nums,index+1,xor);

        return include + exclude;
    }
}