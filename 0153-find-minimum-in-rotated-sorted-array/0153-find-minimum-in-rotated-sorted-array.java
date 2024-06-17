class Solution {
    public int findMin(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        int low  = 0;
        int high  = nums.length -1;
        int mini = Integer.MAX_VALUE;

        while(low <= high){
            int mid = low  + (high - low)/2;

            //if search space is already sorted
            if(nums[low] <= nums[high]){
                mini = Math.min(mini,nums[low]);
                break;
            }

            if(nums[low] <= nums[mid]){
                mini = Math.min(nums[low], mini);
                low = mid+1; // eliminate the  left half as we have taken the minimum from it
            } else {
                mini = Math.min(nums[mid], mini);
                high = mid -1; // eliminate the right half as we have taken the minimum from it
            }
        }

        return mini;
    }
}