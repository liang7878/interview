package leetcode.question104;

import leetcode.util.TreeNode;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;

        Queue<TreeNode> queue = new PriorityQueue<>();

        int depth = 0;

        queue.add(root);

        while(!queue.isEmpty()) {
            depth++;

            int count = queue.size();
            while(count !=0) {
                TreeNode node = queue.poll();

                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
                count--;
            }
        }

        return depth;
    }
}
