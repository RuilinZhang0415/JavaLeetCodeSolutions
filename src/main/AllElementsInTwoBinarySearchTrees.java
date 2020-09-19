package main;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class AllElementsInTwoBinarySearchTrees {
    public class TreeNode {
        int val;
        TreeNode left, right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public class Iterator {
        TreeNode curr, pred;

        public Iterator(TreeNode n) {
            curr = n;
            pred = null;
        }

        public boolean hasNext() {
            return curr != null;
        }

        public int next() {
            while (curr != null) {
                if (curr.left == null) {
                    int re = curr.val;
                    curr = curr.right;
                    return re;
                } else {
                    pred = curr.left;

                    while (pred.right != null && pred.right != curr) pred = pred.right;

                    if (pred.right == null) {
                        pred.right = curr;
                        curr = curr.left;
                    } else {
                        pred.right = null;
                        int re = curr.val;
                        curr = curr.right;
                        return re;
                    }
                }
            }

            return Integer.MAX_VALUE;
        }
    }

    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> result = new LinkedList<>();

        Iterator iter1 = new Iterator(root1);
        Iterator iter2 = new Iterator(root2);

        int i = 0, i1 = 0, i2 = 0, count = 1;
        while (iter1.hasNext() || iter2.hasNext()) {
            if (i == 0) {
                i1 = iter1.next();
                i2 = iter2.next();
            } else if (i == 1) {
                if (iter1.hasNext()) i1 = iter1.next();
                else i1 = Integer.MAX_VALUE;
            } else {
                if (iter2.hasNext()) i2 = iter2.next();
                else i2 = Integer.MAX_VALUE;
            }

            if (i1 <= i2) {
                result.add(i1);
                i = 1;
            } else {
                result.add(i2);
                i = 2;
            }
        }

        if (i == 1 && i2 != Integer.MAX_VALUE) result.add(i2);
        else if (i == 2 && i1 != Integer.MAX_VALUE) result.add(i1);

        return result;
    }
}
