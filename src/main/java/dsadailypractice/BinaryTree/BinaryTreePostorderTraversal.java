package dsadailypractice.BinaryTree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreePostorderTraversal {
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

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        traversal(root, list);
        return list;
    }

    public static void traversal(TreeNode root, List<Integer> list) {
        if (root == null) return;
        traversal(root.left, list);
        traversal(root.right, list);
        list.add(root.val);
    }

    public List<Integer> postorderTraversalUsingDualStackIterativeApproach(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        s1.push(root);
        while (!s1.isEmpty()) {
            TreeNode curr = s1.pop();
            s2.push(curr);
            if (curr.left != null) s1.push(curr.left);
            if (curr.right != null) s1.push(curr.right);
        }
        while (!s2.isEmpty()) {
            list.add(s2.pop().val);
        }
        return list;
    }

    public List<Integer> postorderTraversalUsingSingleStackIterativeApproach(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        TreeNode curr = root;
        TreeNode lv = null;
        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            TreeNode top = stack.peek();
            if (top.right != null && top.right != lv) {
                curr = top.right;
            } else {
                list.add(stack.pop().val);
                lv = top;
            }
        }
        return list;
    }
}
