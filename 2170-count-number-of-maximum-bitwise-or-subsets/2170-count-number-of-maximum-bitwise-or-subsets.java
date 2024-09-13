class Solution {
    public int countMaxOrSubsets(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        int maxOr = 0;
        for(int num: nums){
            maxOr |= num;
        }

        int count = 0 ;
        count = helper(nums,maxOr,0,0);

        return count;
    }
    private int helper(int[] nums,int target, int index, int currOr){
        if(index == nums.length){
           return currOr == target ? 1 : 0; 
        }

        int include = helper(nums,target,index+1,currOr | nums[index]);
        int exclude = helper(nums,target,index+1,currOr);

        return include + exclude;
    }
}