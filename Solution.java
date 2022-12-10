class Solution {
    static int dfs(int[] wt, int[] val, int n, int W, int[][] dp) {
        if (dp[n][W] != 0) return dp[n][W];
        if (n == 0 || W == 0) return 0;
        int take = 0;
        if (W >= wt[n - 1])
            take = val[n - 1] + dfs(wt, val, n - 1, W - wt[n - 1], dp);
        int notTake = dfs(wt, val, n - 1, W, dp);
        dp[n][W] = Math.max(take, notTake);
        return dp[n][W];
    }
    static int knapSack(int W, int wt[], int val[], int n) {
        int[][] dp = new int[n + 1][W + 1];
        return dfs(wt, val, n, W, dp);
    }
}
// TC: O(n * W), SC: O(n * W)