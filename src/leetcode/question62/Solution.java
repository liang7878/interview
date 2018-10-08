package leetcode.question62;

public class Solution {
    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.uniquePaths(7,3));
    }

    public int uniquePaths(int m, int n) {
        int [][] dp = new int[m+1][n+1];

        for (int i = 0; i < m+1; i++) {
            dp[i][1] = 1;
        }

        for (int i = 0; i < n+1; i++) {
            dp[1][i] = 1;
        }

        for (int i = 2; i < m+1; i++) {
            for (int j = 2; j < n+1; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m][n];
    }
}
