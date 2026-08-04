class Solution {
    public int change(int amount, int[] coins) {
        int n =  coins.length;

        int dp[][] = new int[n][amount + 1];

        for(int tar = 0; tar<= amount ; tar++){
            dp[0][tar] = tar % coins[0] == 0 ? 1 :0;
        }

        for(int i = 1 ; i< n ; i++){
            for( int target = 0 ; target <= amount ; target++){
                int nottaken = dp[i-1][target];
                int taken = 0 ;

                if( coins[i] <= target) taken = dp[i][ target - coins[i]];

                dp[i][target] = taken + nottaken;
            }
        }

        return dp[n-1][amount];
    }
}