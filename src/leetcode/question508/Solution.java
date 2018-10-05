package leetcode.question508;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public static HashMap<Integer, Integer> finalMap= new HashMap<Integer, Integer>();
    public static ArrayList<Integer> result;
    public static int maxCount = 0;

    public int[] findFrequentTreeSum(TreeNode root) {
        findFrequentResult(root);
        int[] finalResult = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            finalResult[i] = result.get(i);
        }

        return finalResult;
    }

    public Integer findFrequentResult(TreeNode root) {
        if(root == null) return 0;
        int freq = 1;
        int var = root.val + findFrequentResult(root.left) + findFrequentResult(root.right);

        if(finalMap.containsKey(var)) {
            freq = finalMap.get(var) + 1;
        }
        finalMap.put(var, freq);

        if(freq > maxCount) {
            maxCount = freq;
            result = new ArrayList();
            result.add(var);
        } else if (freq == maxCount) {
            result.add(var);
        }

        return var;
    }

}
