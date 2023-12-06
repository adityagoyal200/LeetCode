class Solution {
    public int coinChange(int[] coins, int amount) {
        if (coins == null || coins.length == 0) {
            return -1;
        }

        int[][] dp = new int[coins.length + 1][amount + 1]; // dp array

        // Initialize the table
        for (int i = 0; i <= coins.length; i++) {
            dp[i][0] = 0;
        }

        for (int i = 1; i <= amount; i++) {
            dp[0][i] = amount + 1; // Set to a value greater than any possible solution
        }

        // Fill the table using bottom-up DP
        for (int i = 1; i <= coins.length; i++) {
            for (int j = 1; j <= amount; j++) {
                if (j < coins[i - 1]) {
                    dp[i][j] = dp[i - 1][j]; // Don't include the coin
                } else {
                    dp[i][j] = Math.min(dp[i - 1][j], 1 + dp[i][j - coins[i - 1]]); // Choose the minimum of not including the coin and including the coin
                }
            }
        }

        return dp[coins.length][amount] > amount ? -1 : dp[coins.length][amount];
    }
}
