package dsadailypractice.BinarySearchTree;

public class InsertIntoBinarySearchTree {
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

    public TreeNode insertIntoBSTTopDownApproach(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        TreeNode node = traverse(root, val);
        if (node.val < val) {
            node.right = new TreeNode(val);
        } else {
            node.left = new TreeNode(val);
        }
        return root;
    }

    public TreeNode traverse(TreeNode root, int val) {
        if (root.val < val) {
            if (root.right == null) return root;
            return traverse(root.right, val);
        } else {
            if (root.left == null) return root;
            return traverse(root.left, val);
        }
    }

    public TreeNode insertIntoBSTBottomUpApproach(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        if (root.val > val) {
            root.left = insertIntoBSTBottomUpApproach(root.left, val);
        } else {
            root.right = insertIntoBSTBottomUpApproach(root.right, val);
        }
        return root;
    }
}
