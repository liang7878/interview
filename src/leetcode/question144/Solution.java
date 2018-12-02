package leetcode.question144;

import leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
        if(root == null) return new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        List<Integer> res = new ArrayList<>();

        while(root != null) {
            res.add(root.val);
            if(root.right != null) stack.push(root.right);

            root = root.left;

            if(root == null && !stack.isEmpty()) {
                root = stack.pop();
            }
        }

        return res;
    }
}
