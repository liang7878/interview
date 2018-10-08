package leetcode.question279;

public class Solution {
    public static void main(String[] args){
        Solution solution = new Solution();
        System.out.println(solution.numSquares(12));
    }


    public int numSquares(int n) {
        if(n<=0) return 0;
        int [] dp = new int[n+1];

        dp[0] = 0;

        for (int i = 1; i < n+1; i++) {
            int min = i;

            for (int j = 1; j*j <= i; j++) {
                min = Math.min(min, dp[i-j*j] + 1);
            }

            dp[i] = min;
        }

        return dp[n];
    }
}
