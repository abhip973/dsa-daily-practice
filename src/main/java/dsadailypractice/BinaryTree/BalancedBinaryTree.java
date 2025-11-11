package dsadailypractice.BinaryTree;

public class BalancedBinaryTree {
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

    static boolean ans = true;

    public boolean isBalanced(TreeNode root) {
        calculateHeight(root);
        return ans;
    }

    public static int calculateHeight(TreeNode node) {
        if (node == null) return 0;
        int left = calculateHeight(node.left);
        int right = calculateHeight(node.right);
        if (Math.abs(left - right) > 1) {
            ans = false;
        }
        return 1 + Math.max(left, right);
    }
}
