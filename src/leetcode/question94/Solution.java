package leetcode.question94;

import leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Solution {
    public static void main(String[] args){
        Solution solution = new Solution();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(1);
        root.left.right = new TreeNode(2);

        List<Integer> result = solution.inorderTraversal(root);

        System.out.println("test");

    }

    public List<Integer> inorderTraversal(TreeNode root) {
        if(root == null) return new ArrayList<>();

        List<Integer> result = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        stack.push(root);

        while(!stack.isEmpty()) {
            TreeNode node = stack.pop();

            if(node.left == null && node.right==null){
                result.add(node.val);
                if(!stack.isEmpty()) stack.peek().left = null;
                continue;
            }

            while(node!=null) {
                stack.push(node);
                node = node.left;
            }

            while (!stack.isEmpty()) {
                TreeNode current = stack.pop();
                result.add(current.val);
                if(!stack.isEmpty()) stack.peek().left = null;
                if(current.right != null) {
                    stack.push(current.right);
                    break;
                }
            }

//            if(!stack.isEmpty()) {
//                TreeNode leftnode = stack.pop();
//                result.add(leftnode.val);
//                if(leftnode.right != null) {
//                    stack.push(leftnode.right);
//                } else {
//                    while(!stack.isEmpty() && stack.peek().right == null) {
//                        result.add(stack.pop().val);
//                    }
//                }
//            }

        }

        return result;

    }
}
