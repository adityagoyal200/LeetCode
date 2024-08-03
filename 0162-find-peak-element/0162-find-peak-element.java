class Solution {
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0){
            return -1;
        }
        if(nums.length == 1){
            return 0;
        }

        if(nums[0] > nums[1]){
            return 0;
        }
        
        if(nums[nums.length-1] > nums[nums.length -2]){
            return nums.length-1;
        }

        int low = 1;
        int high = nums.length -2;

        while(low <= high){
            int mid = low + (high - low)/2;
            
            if(nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]){
                return mid;
            }else if(nums[mid] > nums[mid-1]){
                low = mid+1;
            } else if(nums[mid] > nums[mid+1]){
                high = mid-1;
            } else {
                low = mid+1;
            }
        }
        
        return -1;
    }
}