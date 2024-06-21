class Solution {
    public int shipWithinDays(int[] weights, int days) {
        if(weights == null || weights.length == 0 || days == 0){
            return -1;
        }

        long low = 0;
        long high = 0;

        for(int weight: weights){
            low = Math.max(low, weight);
            high += weight;
        }

        while(low <= high){
            long mid = low + (high - low)/2;

            if(isPossible(weights,mid,days)){
                high = mid-1;
            } else {
                low = mid+1;
            }
        }

        return (int)low;
    }
    private boolean isPossible(int[] arr, long cap, long maxDays){
        long day = 1;
        long curr = 0;

        for(int wei: arr){
            curr += wei;

            if(curr > cap){
                day++;
                curr = wei;
            }
        }     

        return day <= maxDays;
    }
}