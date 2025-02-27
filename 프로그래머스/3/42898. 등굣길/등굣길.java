class Solution {
    public int solution(int m, int n, int[][] puddles) {
        final int MOD = 1000000007;
        int[][] dp = new int[n][m];
        boolean[][] isPuddle = new boolean[n][m];
        
        for(int[] puddle : puddles) {
            isPuddle[puddle[1] - 1][puddle[0] - 1] = true;
        }
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                dp[i][j] = 0;
            }
        }
        
        dp[0][0] = 1;
        
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(isPuddle[i][j]) continue;
                if(i > 0) dp[i][j] += dp[i - 1][j];
                if(j > 0) dp[i][j] += dp[i][j - 1];
                dp[i][j] %= MOD;
            }
        }
        
        return dp[n - 1][m - 1];
    }
}