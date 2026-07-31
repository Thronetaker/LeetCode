class Solution {
    public int uniquePaths(int m, int n) {
        int dp[][] =new int[m][n];

        for(int i = 0 ;i<m ;i++){
            for(int j = 0 ; j<n ; j++){
                int u =0,v=0;
                //BAse condn of recursion
                if( i==0 && j ==0 ) dp[i][j] = 1;
                else{
                    //check idx existence
                    if(i>0)  u = dp[i-1][j];
                    if(j>0)  v = dp[i][j-1];
                    dp[i][j] = u+v;
                }
            }
        }

        return dp[m-1][n-1];
        
    }
}