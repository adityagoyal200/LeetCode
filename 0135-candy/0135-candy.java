class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;

        if(ratings == null || n == 0){
            return 0;
        }

        int total  = 1;
        int i = 1;

        while(i < n){
            if(ratings[i] ==  ratings[i-1]){
                total++;
                i++;
                continue;
            }
            int peak = 1;
            while(i < n && ratings[i] > ratings[i-1]){
                total += ++peak;
                i++;
            }
            int down = 1;
            while(i < n && ratings[i] < ratings[i-1]){
                total += down++;
                i++;
            }

            if(peak < down){
                total += down - peak;
            }
        }


        return total;
    }
}