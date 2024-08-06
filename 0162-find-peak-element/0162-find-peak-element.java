class Solution {
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }

        int low = 0;
        int high = nums.length - 1;

        if(nums.length == 1) {
            return 0;
        }
        if(nums[0] > nums[1]) {
            return 0;
        }
        if(nums[high] > nums[high-1]) {
            return high;
        }

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(mid > 0 && mid < nums.length - 1) {
                if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]){
                    return mid;
                } else if(nums[mid-1] > nums[mid]){
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
        }

        return -1;
    }
}
