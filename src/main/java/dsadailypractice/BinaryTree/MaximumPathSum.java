package dsadailypractice.BinaryTree;

public class MaximumPathSum {
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

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        traverse(root);
        return maxSum;
    }

    public int traverse(TreeNode root) {
        if (root == null) return 0;
        int maxLeft = Math.max(0, traverse(root.left));
        int maxRight = Math.max(0, traverse(root.right));
        int localMax = maxLeft + maxRight + root.val;
        maxSum = Math.max(localMax, maxSum);
        return root.val + Math.max(maxLeft, maxRight);
    }
}
