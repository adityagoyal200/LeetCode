class Solution {
    public int splitArray(int[] nums, int k) {
        if(nums == null || nums.length < k || nums.length == 0){
            return -1;
        }

        int low = 0;
        int high = 0;

        for(int num: nums){
            low = Math.max(num, low);
            high += num;
        }

        while(low <= high){
            int mid = low + (high - low)/2;
            int subArrays = isPossible(nums,mid);
            if(subArrays > k){
                low = mid+1;
            } else{
                high = mid-1;
            }
        }

        return low;
    }
    public int isPossible(int[] arr, int sum){
        int currArr = 1;
        int currSum = 0;
        
        for(int i = 0 ; i < arr.length; i++){
            if(currSum + arr[i] <= sum){
                currSum += arr[i];
            } else {
                currArr++;
                currSum = arr[i];
            }
        }

        return currArr;
    }
}