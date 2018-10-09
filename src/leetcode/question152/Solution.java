package leetcode.question152;

public class Solution {
    public static void main(String[] args){
        Solution solution = new Solution();
        int [] test = new int[]{2, -1, 1, 1};
        System.out.println(solution.maxProduct(test));
    }

    public int maxProduct(int[] nums) {
        if(nums.length == 1) return nums[0];

        int [] max = new int[nums.length];
        int [] min = new int[nums.length];

        int MAX = Integer.MIN_VALUE;

        for (int i = 0; i < nums.length; i++) {
            max[i] = nums[i];
            min[i] = nums[i];
        }

        MAX = Math.max(MAX, max[0]);

        for (int i = 1; i < nums.length; i++) {
            max[i] = Math.max(nums[i], Math.max(nums[i]*max[i-1], nums[i]*min[i-1]));
            min[i] = Math.min(nums[i], Math.min(nums[i]*max[i-1], nums[i]*min[i-1]));

            if(MAX < max[i]) MAX = max[i];
        }

        return MAX;
    }
}
