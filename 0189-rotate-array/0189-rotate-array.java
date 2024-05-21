class Solution {
    public void rotate(int[] nums, int k) {
        int n = nums.length;

        if(k > n){
            k = k % n;
        }

        reverse(nums,0,n-k-1);
        reverse(nums,n-k,n-1);
        reverse(nums,0,n-1);
    }
    private void reverse(int[] nums, int start, int end){
        for(int i = start; i <= end; i++){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }
}