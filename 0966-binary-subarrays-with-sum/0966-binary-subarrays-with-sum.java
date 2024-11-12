class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        return countSub(nums,goal) - countSub(nums,goal-1);
    }
    private int countSub(int[] nums,int goal){
        if(nums == null || nums.length == 0 || goal < 0){
            return 0;
        }
        int left = 0;
        int right = 0;
        int cnt = 0;
        int sum = 0;
        while(right < nums.length){
            sum += nums[right];

            if(sum <= goal){
                cnt+= (right-left+1);
            } else {
                while(sum > goal){
                    sum -= nums[left++];
                }
                cnt+= (right-left+1) ;
            }

            right++;
        }
        
        return cnt;
    }
}