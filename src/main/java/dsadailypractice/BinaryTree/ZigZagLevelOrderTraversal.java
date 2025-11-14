package dsadailypractice.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigZagLevelOrderTraversal {
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

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root == null) return list;
        Queue<TreeNode> q1 = new LinkedList<>();
        q1.offer(root);
        int level = 0;
        while (!q1.isEmpty()) {
            int size = q1.size();
            list.add(new ArrayList<>());
            for (int i = 0; i < size; i++) {
                TreeNode curr = q1.poll();
                if (level % 2 == 0)
                    list.get(level).add(curr.val);
                else
                    list.get(level).add(0, curr.val);
                if (curr.left != null) q1.offer(curr.left);
                if (curr.right != null) q1.offer(curr.right);
            }
            level++;
        }
        return list;
    }
}
