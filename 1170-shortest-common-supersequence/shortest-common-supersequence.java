class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        int dp[][]= new int[n+1][m+1];

        for(int i = 1 ; i<=n ; i++){
            for(int j = 1 ; j<=m ; j++){
                if( str1.charAt(i-1) == str2.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else{
                    dp[i][j] = Math.max( dp[i-1][j] , dp[i][j-1]);
                }
            }
        }

       // Reconstruct LCS string from dp table
        StringBuilder lcs = new StringBuilder();
        int i = n, j = m;

        // Traverse dp table from bottom-right to top-left
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                // Characters match, add to result and move diagonally
                lcs.append(str1.charAt(i - 1));
                i--;
                j--;
            } // Move in the direction of larger value
            else if (dp[i - 1][j] > dp[i][j - 1]) {
                lcs.append(str1.charAt(i - 1));
                i--;
            } else {
                lcs.append(str2.charAt(j - 1));
                j--;
            }
        }
        
        // Append remaining characters from s1
        while (i > 0) {
            lcs.append(str1.charAt(i - 1));
            i--;
        }

        // Append remaining characters from s2
        while (j > 0) {
            lcs.append(str2.charAt(j - 1));
            j--;
        }

        // Reverse the result since it was built backwards
        return lcs.reverse().toString();

    }
}