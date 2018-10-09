package leetcode.question136;

public class Solution {
    public static void main(String[] args){
        Solution solution = new Solution();
        int [] nums = new int[]{2,2,1};

        System.out.println(solution.singleNumber(nums));
    }

    public int singleNumber(int[] nums) {
        if(nums.length == 1) return nums[0];

        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            result = result^nums[i];
        }

        return result;
    }
}
