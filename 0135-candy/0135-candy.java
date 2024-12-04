class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;

        if(ratings == null || n == 0){
            return 0;
        }

        int[] candies = new int[n];
        int last = ratings[0];
        int cdy = 1;
        candies[0] = 1;

        for(int i = 1; i < n; i++){
            if(ratings[i] > last){
                candies[i] = ++cdy;
            } else {
                candies[i] = 1;
                cdy = 1;
            }

            last = ratings[i];
        }

        cdy = 1;
        last = ratings[n-1];
        for(int i = n-2; i >= 0; i--){
            if(ratings[i] > last){
                cdy++;
                candies[i] = Math.max(cdy,candies[i]);
            } else {
                cdy = 1;
                candies[i] = Math.max(cdy,candies[i]);
            }
            last = ratings[i];
        }

        int total = 0;
        for(int cndy: candies){
            total += cndy;
        }

        return total;
    }
}