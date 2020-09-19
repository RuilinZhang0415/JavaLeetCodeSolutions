package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SumOfRootToLeafBinaryNumbers {
    public class TreeNode {
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

    // O(h) space
    public int sumRootToLeaf(TreeNode root) {
        int[] sum = new int[] {0};
        aux(root, 0, sum);
        return sum[0];
    }

    private void aux(TreeNode n, int pref, int[] sum) {
        if (n.left == null && n.right == null) {
            sum[0] += (pref << 1) | n.val;
        } else {
            if (n.left != null) aux(n.left, (pref << 1) | n.val, sum);
            if (n.right != null) aux(n.right, (pref << 1) | n.val, sum);
        }
    }

    public static void main(String[] args) {
        System.out.println(3 << 1);
    }
}
