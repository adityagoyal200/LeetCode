class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;

        if(ratings == null || n == 0){
            return 0;
        }

        int[] candies = new int[n];
        candies[0] = 1;

        for(int i = 1; i < n; i++){
            candies[i] = (ratings[i] > ratings[i-1]) ? candies[i-1]+1 : 1;
        }

        for(int i = n-2; i >= 0; i--){
            candies[i] = (ratings[i] > ratings[i+1]) ? 
            Math.max(candies[i],candies[i+1]+1) : Math.max(1,candies[i]);
        }

        int total = 0;
        for(int cndy: candies){
            total += cndy;
        }

        return total;
    }
}