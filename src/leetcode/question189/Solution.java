package leetcode.question189;

public class Solution {
    public static void main(String[] args){
        Solution solution = new Solution();
        int [] nums = new int[]{1,2};

        solution.rotate(nums, 3);

        System.out.println("test");
    }


    public void rotate(int[] nums, int k) {
        if(nums.length<2) return;
        k = k%nums.length;

        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
    }

    private void reverse(int[] nums, int start, int end) {
        if(start < 0 || nums.length == 1 || end >= nums.length || start == end) return;

        while (start < end){
            nums[start] = nums[start] + nums[end];
            nums[end] = nums[start] - nums[end];
            nums[start] = nums[start] - nums[end];
            start++;
            end--;
        }
    }
}
