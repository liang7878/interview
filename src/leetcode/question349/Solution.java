package leetcode.question349;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1); Arrays.sort(nums2);

        ArrayList<Integer> list = new ArrayList<>();

        int index1 = 0, index2 = 0;

        while(index1 < nums1.length && index2 < nums2.length) {
            if(nums1[index1] > nums2[index2]) {
                index2++;
            } else if(nums1[index1] < nums2[index2]) {
                index1++;
            } else {
                list.add(nums1[index1]);
                index1++; index2++;
            }

        }

        int [] result = new int[list.size()];
        int index = 0;

        for(int num: list) {
            result[index] = num;
            index++;
        }

        return result;
    }
}