class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        if(piles == null || piles.length == 0){
            return 0;
        }
        int max = 0;

        for(int num: piles){
            max = Math.max(num,max);
        }
        int low  = 1;
        int high = max;
        int ans = Integer.MAX_VALUE;

        while(low <=  high){
            int mid = low + (high - low)/2;

            if(totalTime(piles,mid) <= h){
                high = mid-1;
                ans = mid;
            } else {
                low = mid+1;
            }
        }

        return ans;
    }
    private int totalTime(int[] piles,int k){
        int time = 0;
        for(int num: piles){
            time += Math.ceil((double)num/(double)k);
        }
        
        return time;
    }
}