class Solution {
    public int maximumEnergy(int[] energy, int k) {
        if(energy == null || energy.length == 0) return 0;

        int max = Integer.MIN_VALUE;
        int[] dp = new int[energy.length];

        for(int i = energy.length-1; i >= 0; i--){
            dp[i] = (i+k >= energy.length) ? energy[i] : energy[i] + dp[i+k];
            max =  Math.max(dp[i],max);
        }

        return max;
    }
}