package dsadailypractice.BinaryTree;

public class MaxDepthOfBinaryTree {
    static int maxDepth;

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

    public int maxDepthUsingTopDownApproach(TreeNode root) {
        if (root == null) return 0;
        topDownTraversal(root, 1);
        return maxDepth;
    }

    public static void topDownTraversal(TreeNode node, int level) {
        if (node == null) return;
        maxDepth = Math.max(maxDepth, level);
        topDownTraversal(node.left, level + 1);
        topDownTraversal(node.right, level + 1);
    }

    public int maxDepthUsingBottomUpApproach(TreeNode root) {
        if (root == null) return 0;
        int leftTree = maxDepthUsingBottomUpApproach(root.left);
        int rightTree = maxDepthUsingBottomUpApproach(root.right);
        return 1 + Math.max(leftTree, rightTree);
    }
}
