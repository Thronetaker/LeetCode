class Solution {
    public int minimumCost(int n, List<Integer> cuts) {
        // Add the two ends of the stick to the cuts list
        cuts.add(n);
        cuts.add(0);
        Collections.sort(cuts);

        int c = cuts.size() - 2; // number of cuts excluding ends

        // Create DP table initialized with 0
        int[][] dp = new int[c + 2][c + 2];

        // Fill DP table for all segments
        for (int i = c; i >= 1; i--) {
            for (int j = i; j <= c; j++) {
                int mini = Integer.MAX_VALUE;

                // Try making a cut at every position between i and j
                for (int ind = i; ind <= j; ind++) {
                    // Cost of current cut plus left and right subproblems
                    int ans = cuts.get(j + 1) - cuts.get(i - 1) + dp[i][ind - 1] + dp[ind + 1][j];

                    // Update minimum cost
                    mini = Math.min(mini, ans);
                }

                // Store minimum cost in DP table
                dp[i][j] = mini;
            }
        }

        // Return minimum cost to cut between indices 1 and c
        return dp[1][c];
    }
    public int minCost(int n, int[] cuts) {
        List<Integer> cutsL = new ArrayList<>();
        for (int cut : cuts) {
            cutsL.add(cut);
        }
        return minimumCost(n , new ArrayList<>(cutsL));
    }
}