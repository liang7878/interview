package leetcode.question897;

import leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public static void main(String[] args){
        Solution solution = new Solution();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);

        StringBuilder sb = new StringBuilder();

//        System.out.println(sb.);

        TreeNode test = solution.increasingBST(root);
    }

    public TreeNode increasingBST(TreeNode root) {
        if(root == null) return null;
        List<Integer> list = new ArrayList<>();

        if(root.left == null && root.right == null) return root;

        Stack<TreeNode> stack = new Stack<>();
        stack.clear();
        TreeNode cur = root;
        TreeNode res = null;
        TreeNode ind = null;

        while(cur!= null || stack.size() != 0) {
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();

            if(res == null) {
                res = cur;
                ind = res;
                res.left = null;
            } else {
                ind.right =cur;
                ind.left = null;
                ind = ind.right;
            }
            cur = cur.right;
        }

        return res;
    }

}
