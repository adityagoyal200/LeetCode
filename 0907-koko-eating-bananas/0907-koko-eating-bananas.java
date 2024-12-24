class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        if(piles == null || piles.length == 0){
            return 0;
        }

        int low = 1;
        int high = 0;
        for(int num: piles){
            high = Math.max(num,high);
        }

        int ans = 0;
        while(low <= high){
            int mid = low + (high-low)/2;
            if(canEat(piles,mid) <= h){
                ans = mid;
                high = mid-1;
            } else {
                low = mid+1;
            }
        }

        return ans;
    }
    private int canEat(int[] piles, int speed){
        int time  = 0;
        for(int num: piles){
            time += Math.ceil((double)num/(double)speed);
        }

        return time;
    }
}