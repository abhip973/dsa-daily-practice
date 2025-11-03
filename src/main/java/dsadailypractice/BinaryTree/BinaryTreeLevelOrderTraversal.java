package dsadailypractice.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrderTraversal {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        Queue<TreeNode> q1 = new LinkedList<>();
        q1.offer(root);
        while (!q1.isEmpty()) {
            List<Integer> li = new ArrayList<>();
            int size = q1.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q1.poll();
                li.add(curr.val);
                if (curr.left != null) q1.offer(curr.left);
                if (curr.right != null) q1.offer(curr.right);
            }
            list.add(li);
        }
        return list;
    }
}
