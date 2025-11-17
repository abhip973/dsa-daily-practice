package dsadailypractice.BinaryTree;

public class LowestCommonAncestor {
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    TreeNode lca = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        traversal(root, p, q);
        return lca;
    }

    public int traversal(TreeNode node, TreeNode p, TreeNode q) {
            int count = 0;
            if (node == null) return 0;
            int leftSubTreeCount = traversal(node.left, p, q);
            int rightSubTreeCount = traversal(node.right, p, q);
            if (node.val == p.val || node.val == q.val)
                count++;
            count = leftSubTreeCount + rightSubTreeCount + count;
            if (count == 2 && lca == null)
                lca = node;
            return count;
    }
}
