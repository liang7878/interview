package leetcode.question665;

public class Solution {
    public boolean checkPossibility(int[] nums) {
        if(nums.length<2) return true;

        int cnt = 0;
        int [] mark = new int[nums.length];

        for (int i = 1; i < nums.length; i++) {
            if(nums[i] < nums[i-1]) {
                cnt++;
                if(mark[i-1] > nums[i-1]) {
                    return false;
                } else {
                    mark[i] = nums[i-1];
                }
            }

        }

        if(cnt>1) return false;

        return true;
    }
}
