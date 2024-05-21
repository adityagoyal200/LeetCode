class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int count = 0;
        int maxCnt = Integer.MIN_VALUE;

        for(int i = 0 ; i < nums.length; i++){
            if(nums[i] == 1){
                count++;
            }
            if(nums[i] == 0){
                maxCnt =  Math.max(count,maxCnt);
                count = 0;
            }
        }
        
        maxCnt = Math.max(count, maxCnt);
        return maxCnt == Integer.MIN_VALUE ? 0: maxCnt;
    }
}