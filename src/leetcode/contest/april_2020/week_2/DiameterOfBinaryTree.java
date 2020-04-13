package leetcode.contest.april_2020.week_2;

public class DiameterOfBinaryTree {

    public static void main(String[] args) {
        /*
                    1
                   / \
                  2   3
                 / \
                4   5
         */
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        System.out.println(diameterOfBinaryTree(root)); // 3



    }

    public static int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        int rootDiameter = height(root.left) + height(root.right);
        int childDiameter = Math.max(diameterOfBinaryTree(root.left), diameterOfBinaryTree(root.right));

        return Math.max(rootDiameter, childDiameter);
    }

    private static int height(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    private static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
