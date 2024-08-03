class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        if(bloomDay == null || bloomDay.length == 0){
            return -1;
        }
        long len = bloomDay.length;

        if(len < (long)m*k){
            return -1;
        }
        
        long maxDays = 0;
        long minDays = 0;
        for(int day: bloomDay){
            maxDays = Math.max(day,maxDays);
            minDays = Math.min(day,minDays);
        }

        long low = minDays;
        long high = maxDays;
        long ans = -1;

        while(low <= high){
            long mid = low + (high - low)/2;
            long total = numberOfBoq(bloomDay,mid,k);

            if(total >= m){
                ans = mid;
                high = mid-1;
            } else {
                low = mid + 1;
            }
        }

        return (int)ans;
    }
    private long numberOfBoq(int[] bloomDay, long day, long flowers){
        long total = 0;
        long count = 0;
        for(int bloom: bloomDay){
            if(bloom <= day){
                count++;
            } else {
                total += count/flowers;
                count = 0;
            }      
        }

        total += count/flowers;

        return total;
    }
}