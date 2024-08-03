class Solution {
    public int missingNumber(int[] nums) {
        int n=nums.length;
        int totalSum = n * (n+1) /2;
        int arraySum = 0;

         for(int i = 0;i < n;i++){
             arraySum += nums[i];
         }

         return totalSum-arraySum;
    }
}