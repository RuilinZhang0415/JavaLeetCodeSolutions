package main;


import javax.lang.model.util.Elements;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FindAllTheLonelyNodes {
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

    /******************** Iterative DFS ********************/
//    public List<Integer> getLonelyNodes(TreeNode root) {
//        LinkedList<Integer> result = new LinkedList<>();
//
//        if (root == null) return result;
//
//        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
//        stack.addFirst(root);
//
//        while (!stack.isEmpty()) {
//            TreeNode curr = stack.removeFirst();
//            if (curr.left != null && curr.right != null) {
//                stack.addFirst(curr.right);
//                stack.addFirst(curr.left);
//            } else if (curr.left != null && curr.right == null) {
//                stack.addFirst(curr.left);
//                result.add(curr.left.val);
//            } if (curr.left == null && curr.right != null) {
//                stack.addFirst(curr.right);
//                result.add(curr.right.val);
//            }
//        }
//
//        return result;
//    }


    /******************** Iterative BFS ********************/
//    public List<Integer> getLonelyNodes(TreeNode root) {
//        LinkedList<Integer> result = new LinkedList<>();
//
//        LinkedList<TreeNode> currLvl = new LinkedList<>();
//        currLvl.add(root);
//
//        while (!currLvl.isEmpty()) {
//            int len = currLvl.size();
//            for (int i = 0; i < len; i++) {
//                TreeNode temp = currLvl.pollFirst();
//                if (temp.left != null && temp.right != null) {
//                    currLvl.add(temp.left);
//                    currLvl.add(temp.right);
//                } else if (temp.left != null && temp.right == null) {
//                    currLvl.add(temp.left);
//                    result.add(temp.left.val);
//                } else if (temp.left == null && temp.right != null) {
//                    currLvl.add(temp.right);
//                    result.add(temp.right.val);
//                }
//            }
//        }
//
//        return result;
//    }

    /******************** Recursive PostOrder Traversal ********************/
    public List<Integer> getLonelyNodes(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        getLonelyNodesAux(root, result);

        return result;
    }

    private void getLonelyNodesAux(TreeNode root, List<Integer> result) {
        if (root == null) return;

        getLonelyNodesAux(root.left, result);
        getLonelyNodesAux(root.right, result);
        if (root.left == null && root.right != null) result.add(root.right.val);
        if (root.left != null && root.right == null) result.add(root.left.val);
    }
}
