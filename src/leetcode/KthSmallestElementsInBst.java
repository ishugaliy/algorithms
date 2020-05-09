package leetcode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/kth-smallest-element-in-a-bst/
public class KthSmallestElementsInBst {

    private static List<Integer> seq = new ArrayList<>();

    public static void main(String[] args) {
        // CASE: #1: [1]
        TreeNode root = new TreeNode(3);
        root.right = new TreeNode(4);
        root.left = new TreeNode(1, null, new TreeNode(2));
        System.out.println(kthSmallest(root, 1));

        // CASE: #2: [3]
        root = new TreeNode(5);
        root.right = new TreeNode(6);
        TreeNode n3 = new TreeNode(3);
        root.left = n3;
        n3.right = new TreeNode(4);
        n3.left = new TreeNode(2, new TreeNode(1), null);
        System.out.println(kthSmallest(root, 3));
    }

    public static int kthSmallest(TreeNode root, int k) {
        traversal(root, k);
        return seq.get(k - 1);
    }

    private static void traversal(TreeNode root, int k) {
        if (root == null || seq.size() > k) return;
        traversal(root.left, k);
        seq.add(root.val);
        traversal(root.right, k);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
