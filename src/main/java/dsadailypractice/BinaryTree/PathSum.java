package dsadailypractice.BinaryTree;

public class PathSum {
    int sum;
    boolean res = false;

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

    public boolean hasPathSumTopDownApproach(TreeNode root, int targetSum) {
        if (root == null) return false;
        sum = targetSum;
        PathSum pathSum = new PathSum();
        pathSum.traverse(root, 0);
        return res;
    }

    public void traverse(TreeNode node, int prevSum) {
        int currLevelSum = prevSum + node.val;
        if (node.left == null && node.right == null) {
            if (currLevelSum == sum) {
                res = true;
            }
        }
        if (node.left != null) traverse(node.left, currLevelSum);
        if (node.right != null) traverse(node.right, currLevelSum);
    }

    public boolean hasPathSumBottomUpApproach(TreeNode root, int targetSum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) {
            if (root.val == targetSum) {
                return true;
            }
        }
        boolean left = hasPathSumBottomUpApproach(root.left, targetSum - root.val);
        boolean right = hasPathSumBottomUpApproach(root.right, targetSum - root.val);

        return left || right;
    }
}
