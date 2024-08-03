class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0){
            return 0;
        }
        
        int miniCost = prices[0];
        int maxProfit = 0;

        for(int i = 1; i < prices.length; i++){
            int cost = prices[i] - miniCost;
            maxProfit = Math.max(maxProfit,cost);
            miniCost =  Math.min(miniCost,prices[i]);
        }

        return maxProfit;
    }
}