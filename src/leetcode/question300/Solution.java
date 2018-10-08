package leetcode.question300;

public class Solution {
    public static void main(String[] args){
        Solution solution = new Solution();
        int [] nums = new int[]{2};

        System.out.println(solution.lengthOfLIS(nums));
    }

    public int lengthOfLIS(int[] nums) {
        int [] dp = new int[nums.length];

        dp[0] = 1;

        int MAX = Integer.MIN_VALUE;

        for (int i = 1; i < nums.length; i++) {
            int index = i-1;
            int maxIndex = i;
            while(index>=0) {
                if(nums[index] < nums[i] && dp[index] > dp[maxIndex]) {
                    maxIndex = index;
                }
                index--;
            }
            if(maxIndex != i) {
                dp[i] = dp[maxIndex]+1;


            } else {
                dp[i] = 1;
            }
            if(dp[i] >= MAX) MAX = dp[i];
        }

        return MAX;
    }
}
