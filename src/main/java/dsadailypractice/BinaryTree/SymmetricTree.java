package dsadailypractice.BinaryTree;

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
}
