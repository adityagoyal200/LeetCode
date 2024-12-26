class Solution {
    int cnt;
    public int findTargetSumWays(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return 0;
        }

        cnt  = 0;
        helper(nums,0,0,target);

        return cnt;
    }
    private void helper(int[] nums, int index, int sum,int target){
        if(index == nums.length){
            if(sum == target){
                cnt++;
            }
            return;
        }

        sum += nums[index];
        helper(nums,index+1,sum,target);
        sum -= nums[index];
        sum -= nums[index];
        helper(nums,index+1,sum,target);
        sum += nums[index];
    }
}