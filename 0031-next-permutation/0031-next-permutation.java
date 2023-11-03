class Solution {
    public void nextPermutation(int[] nums) {
        // find the break point where i+1 > i
        int len = nums.length;
        int point = -1;
        for(int i = len-2;i>=0;i--){
            if(nums[i]<nums[i+1]){
                point = i;
                break;
            }
        }
        if(point == -1){
            reverse(nums,0,len-1);
            return;
        }
        // find slightly greater and swap
        for(int i = len-1;i>=0;i--){
            if(nums[i]>nums[point]){
                int temp = nums[point];
                nums[point] = nums[i];
                nums[i] = temp;
                break;
            }
        }
        reverse(nums,point+1,len-1);      
    }
    public void reverse(int[] nums , int start , int end){
        while(start<end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}
