class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int totSum = 0 ,target = 0;
        for(int i = 0 ; i < n ; i++){
            totSum+= nums[i];
        }
        if(totSum%2 != 0) return false;

        target = totSum/2;

        boolean dp[][] = new boolean[n+1][target+1];
        for(int i =0 ;i< n+1 ;i++){
            dp[i][0] = true;
        }
        

        for(int i = 1 ;i < n+1 ;i++){
            for( int t = 1 ; t< target +1 ; t++ ){

                boolean notTaken = dp[i-1][t];
                boolean taken = false;
                if( nums[i-1] <= t) taken = dp[i-1][ t - nums[i-1]];

                dp[i][t] = taken || notTaken;

            }
        }

        return dp[n][target];

    }
}