package leetcode.question215;

import java.util.Arrays;

public class Solution {
    public static void main(String[] args){
        Solution solution = new Solution();
        int [] arr = new int[]{3,2,1,5,6,4};

        System.out.println(solution.findKthLargest(arr, 2));
    }

    public int findKthLargest(int[] nums, int k) {
        int result = -1;

        Arrays.sort(nums);


        for (int pos = nums.length-1; pos >= 0 ; pos--) {
            if(k != 1) {k--; continue;}
            result = nums[pos];
            break;
        }

        return result;
    }
}
