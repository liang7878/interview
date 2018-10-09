package leetcode.question322;

public class Solution {
    public static void main(String[] args){
        Solution solution = new Solution();

        int [] coins = new int[]{1,2,5};
        System.out.println(solution.coinChange(coins, 11));
    }


    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return -1;

        int [] dp = new int[amount + 1];

        for (int i = 0; i < coins.length; i++) {
            dp[coins[i]] = 1;
        }

        for (int i = 1; i < dp.length; i++) {
            int min = Integer.MAX_VALUE;

            for (int j = 0; j < coins.length; j++) {
                if(i-coins[j] >=0 && dp[i-coins[j]] != -1) min = Math.min(min, dp[i-coins[j]]);
            }

            if(min == Integer.MAX_VALUE) dp[i] = -1;
            else dp[i] = min + 1;
        }

        return dp[amount];
    }
}
