class Solution {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        if(nums == null || len == 0){
            return;
        }
        int index = -1;
        for(int i = len-2; i>=0; i--){
            if(nums[i] < nums[i+1]){
                index = i;
                break;
            }
        }
        if(index == -1){
            reverse(nums,0 ,len-1);
            return;
        }
        /* find the greater closest element*/
        for(int i = len-1; i > index; i--){
            if(nums[i]> nums[index]){
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
                break;
            }
        }
        /* now just reverse the index+1 numsay to get the next permutation */
        reverse(nums,index+1,len-1);
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