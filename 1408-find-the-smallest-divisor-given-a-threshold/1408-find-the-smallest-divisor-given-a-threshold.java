class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
       if(nums == null || nums.length == 0){
        return -1;
       }
       
       long max = 0;
       long min  = 0;
       for(int num: nums){
            max = Math.max(num,max);
            min = Math.min(num,min);
       }

       long low = min;
       long high = max;

       while(low <= high){
            long mid = low + (high - low)/2;
            long thres = currThresh(nums,mid);

            if(thres <= threshold){
                high = mid-1;
            } else {
                low = mid+1;
            }
       }

        return (int)low;
    }
    private long currThresh(int[] nums, long mid){
        long total = 0;
        for(int num: nums){
            total += Math.ceil((double)num/(double)mid);
        }

        return total;
    }
}