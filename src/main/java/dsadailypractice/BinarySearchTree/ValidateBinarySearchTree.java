package dsadailypractice.BinarySearchTree;

public class ValidateBinarySearchTree {
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

    public boolean isValidBST(TreeNode root) {
        return traverse(root, null, null);
    }

    public boolean traverse(TreeNode root, Integer lower, Integer higher) {
        if (root == null) return true;
        if ((lower != null && root.val <= lower) || (higher != null && root.val >= higher)) {
            return false;
        }
        boolean isLeftBST = traverse(root.left, lower, root.val);
        boolean isRightBST = traverse(root.right, root.val, higher);
        return isLeftBST && isRightBST;
    }
}
