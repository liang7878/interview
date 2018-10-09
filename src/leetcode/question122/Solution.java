package leetcode.question122;

public class Solution {
    public static void main(String[] args){
        Solution solution = new Solution();
        int [] test = new int[]{1,2,3,4,5};
        int [] test1 = new int[]{7,1,5,3,6,4};

        System.out.println(solution.maxProfit(test));
    }

    public int maxProfit(int[] prices) {
        if(prices.length < 2) return 0;

        int profit = 0;

        for (int i = 0; i < prices.length-1; i++) {
            if(prices[i+1] > prices[i]) profit += (prices[i+1]-prices[i]);
        }

        return profit;
    }
}

//public class Solution {
//    public static void main(String[] args) {
//        Solution solution = new Solution();
//
//        int [] test = new int[]{2,3,1,1,4};
//
//        System.out.println(solution.canJump(test));
//    }
//
//    public boolean canJump(int[] nums) {
//        int lastIndex= nums.length-1;
//
//        for (int i = nums.length-1; i >=0 ; i--) {
//            if(i+nums[i] >= lastIndex) {
//                lastIndex = i;
//            }
//        }
//
//        return lastIndex==0;
//    }
//}
