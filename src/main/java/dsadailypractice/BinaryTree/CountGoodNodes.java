package dsadailypractice.BinaryTree;

public class CountGoodNodes {
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

    int count = 0;

    public int goodNodes(TreeNode root) {
        traverse(root, Integer.MIN_VALUE);
        return count;
    }

    public void traverse(TreeNode node, Integer maxSoFar) {
        if (node == null) return;
        if (node.val >= maxSoFar) {
            count++;
            maxSoFar = node.val;
        }
        traverse(node.left, maxSoFar);
        traverse(node.right, maxSoFar);
    }
}
