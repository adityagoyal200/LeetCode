class Solution {
    public int search(int[] nums, int target) {
        int low = 0 ;
        int high = nums.length-1;

        while(low <= high){
            int mid = low + (high - low)/2;
            if(nums[mid] == target){
                return mid;
            } 
// searching in sorted half only
            if(nums[low] <= nums[mid]){  // left half sorted
                if(nums[low] <= target && target <= nums[mid]){  //check if target lies in this half
                    high = mid-1;
                } else {
                    low = mid+1;
                }

            } else {   // right half sorted

                if(nums[mid] <= target && target <= nums[high]){
                    low = mid+1;
                } else {
                    high = mid-1;
                }
            }
        }

        return -1;
    }
}