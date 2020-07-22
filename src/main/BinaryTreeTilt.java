package main;

public class BinaryTreeTilt {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public int findTilt(TreeNode root) {
        return findTiltAux(root)[0];
    }

    private int[] findTiltAux(TreeNode root) {
        if (root == null) return new int[2];

        int[] left = findTiltAux(root.left);
        int[] right = findTiltAux(root.right);

        return new int[] {
                Math.abs(left[1] - right[1]) + left[0] + right[0],
                root.val + left[1] + right[1]
        };
    }

    public static void main(String[] args) {
        BinaryTreeTilt test = new BinaryTreeTilt();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(5);
        System.out.println(test.findTilt(root));
    }
}
