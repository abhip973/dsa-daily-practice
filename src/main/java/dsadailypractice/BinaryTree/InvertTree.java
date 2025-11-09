package dsadailypractice.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class InvertTree {
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

    public TreeNode invertTreeRecursiveApproach(TreeNode root) {
        if (root == null) return root;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertTreeRecursiveApproach(root.left);
        invertTreeRecursiveApproach(root.right);
        return root;
    }

    public TreeNode invertTreeIterativeApproach(TreeNode root) {
        if (root == null) return root;
        Queue<TreeNode> q1 = new LinkedList<>();
        q1.offer(root);
        while (!q1.isEmpty()) {
            TreeNode curr = q1.poll();
            TreeNode temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;
            if (curr.left != null) q1.offer(curr.left);
            if (curr.right != null) q1.offer(curr.right);
        }
        return root;
    }
}
