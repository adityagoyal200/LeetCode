class Solution {
    public boolean search(int[] nums, int target) {
        if(nums == null || nums.length == 0){
            return false;
        }
        int low  = 0;
        int high  = nums.length - 1;

        while(low <= high){
            int mid = low  + (high - low) /2;

            if(nums[mid] ==  target){
                return true;
            }
            //duplicates;
            if(nums[low] == nums[mid] && nums[mid] == nums[high]){
                low++;
                high--;
                continue;
            }
            //find sorted half
            if(nums[low] <= nums[mid]){
                if(nums[low] <= target && target <= nums[mid]){
                    high = mid -1;
                } else {
                    low = mid +1;
                }

            } else {
                if(nums[mid] <= target && target <= nums[high]){
                    low = mid + 1;
                } else {
                    high = mid -1;
                }
            }
        }

        return false;
    }
}