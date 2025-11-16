package dsadailypractice.BinaryTree;

public class SubTreeOfAnotherTree {
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

    String root = "";
    String subRoot = "";

    public boolean isSubTree(TreeNode root, TreeNode subRoot) {
        this.root = serialize(root, this.root);
        this.subRoot = serialize(subRoot, this.subRoot);
        return this.root.contains(this.subRoot);
    }

    public String serialize(TreeNode node, String str) {
        if (node == null) {
            str += "-#";
            return str;
        }
        str += "-" + node.val;
        str = serialize(node.left, str);
        str = serialize(node.right, str);
        return str;
    }
}
