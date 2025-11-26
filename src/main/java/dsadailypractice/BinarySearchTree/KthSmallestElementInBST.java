package dsadailypractice.BinarySearchTree;

public class KthSmallestElementInBST {
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

    int count, ans;

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        traverse(root);
        return ans;
    }

    public void traverse(TreeNode root) {
        if (root == null || count == 0) return;
        traverse(root.left);
        count--;
        if (count == 0)
            ans = root.val;
        traverse(root.right);
    }
}
