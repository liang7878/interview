package leetcode.question98;

import leetcode.util.TreeNode;

import java.util.*;

public class Solution {
    public boolean isValidBST(TreeNode root) {
        if(root==null) return false;
//        List<TreeNode> list = new ArrayList<>();
//
        Stack<TreeNode> stack = new Stack<>();
//        stack.push(root);
        Queue<Integer> res = new LinkedList<>();

        TreeNode cur = root;

        while(cur!=null || !stack.isEmpty()) {
            while(cur!=null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if(!res.isEmpty() && ((LinkedList<Integer>) res).getLast() > cur.val) return false;
            ((LinkedList<Integer>) res).add(cur.val);
            cur=cur.right;

        }
        return true;
    }
}
