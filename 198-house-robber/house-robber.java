class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
          if (n == 1) return nums[0];
        int dp[] = new int[n];
        //base case if one ele
        dp[0] = nums[0];
        //base case if 2 ele 
        dp[1] = Math.max(nums[0],nums[1]);
        //
        for( int i = 2; i<n ; i++){
            //( curr included, curr NOT included)
            // a b c     c + a   , b
            int rob = Math.max( nums[i] + dp[i-2], dp[i-1]);
            dp[i] = rob;
        }
        return dp[n-1];
    }
}