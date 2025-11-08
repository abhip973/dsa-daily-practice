package dsadailypractice.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {
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

    public boolean isSymmetricRecursiveApproach(TreeNode root) {
        boolean res = isEqual(root.left, root.right);
        return res;
    }

    public static boolean isEqual(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        if (left == null || right == null) return false;
        return left.val == right.val && isEqual(left.left, right.right) && isEqual(left.right, right.left);
    }

    public boolean isSymmetricIterativeApproach(TreeNode root) {
        Queue<TreeNode> q1 = new LinkedList<>();
        q1.offer(root.left);
        q1.offer(root.right);
        while (!q1.isEmpty()) {
            TreeNode p1 = q1.poll();
            TreeNode p2 = q1.poll();
            if (p1 == null && p2 == null) continue;
            if (p1 == null || p2 == null) return false;
            if (p1.val != p2.val) return false;
            q1.offer(p1.left);
            q1.offer(p2.right);
            q1.offer(p1.right);
            q1.offer(p2.left);
        }
        return true;
    }
}
