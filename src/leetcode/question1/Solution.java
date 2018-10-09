package leetcode.question1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int [] result = new int[2];

        HashMap<Integer, Integer> set = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if(set.containsKey(target-nums[i])) {
                result[0] = i;
                result[1] = set.get(target-nums[i]);
                Arrays.sort(result);
                return result;
            }
            set.put(nums[i], i);
        }

        return result;
    }
}
