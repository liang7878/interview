package leetcode.question102;

import leetcode.util.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return new ArrayList<>();

        Queue<TreeNode> queue = new LinkedList<>();

        List<List<Integer>> res = new ArrayList<>();

        ((LinkedList<TreeNode>) queue).add(root);

        while(!queue.isEmpty()) {
            int cnt = queue.size();
            List<Integer> level = new ArrayList<>();

            while (cnt!=0) {
                TreeNode node = queue.poll();
                if(node.left != null) ((LinkedList<TreeNode>) queue).add(node.left);
                if(node.right != null) ((LinkedList<TreeNode>) queue).add(node.right);
                level.add(node.val);
                cnt--;
            }
            res.add(level);
        }

        return res;
    }
}
