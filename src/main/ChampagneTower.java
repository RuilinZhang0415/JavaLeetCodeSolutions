package main;

public class ChampagneTower {
    public double champagneTower(int poured, int query_row, int query_glass) {
        double[] each_row = new double[query_row + 1];
        each_row[0] = poured;

        for (int row = 1; row <= query_row; row++) {
            double prev_surplus = 0, curr_surplus = 0;
            for (int col = 0; col < row + 1; col++) {
                curr_surplus = Math.max(0, each_row[col] - 1) / 2;
                each_row[col] = prev_surplus + curr_surplus;
                prev_surplus = curr_surplus;
            }
        }

        return Math.min(1, each_row[query_glass]);
    }

/******************** Build Tree Solution ********************/
//    class ChampagneTowerNode {
//        int id;
//        double val = 0;
//        ChampagneTowerNode left, right, next;
//
//        ChampagneTowerNode(int id) {
//            this.id = id;
//        }
//    }
//
//    private ChampagneTowerNode root;
//    private double cupCapacity = 1.0;
//    int id = 0;
//
//    public main.ChampagneTower() {
//        root = new ChampagneTowerNode(id++);
//    }
//
//    public double champagneTower(int poured, int query_row, int query_glass) {
//        buildChampagneTower(query_row);
//        boolean hasFullCup = false;
//
//        root.val += poured;
//        if (root.val > cupCapacity) hasFullCup = true;
//
//        ChampagneTowerNode curr = root;
//        while (curr.left != null && hasFullCup) {
//            hasFullCup = false;
//
//            ChampagneTowerNode head = curr;
//            while (curr != null) {
//                if (curr.val > cupCapacity) {
//                    double surplus = curr.val - cupCapacity;
//                    curr.left.val += surplus / 2;
//                    curr.right.val += surplus / 2;
//
//                    hasFullCup = true;
//                }
//                curr = curr.next;
//            }
//            curr = head.left;
//        }
//        // Last row
//        while (curr != null) {
//            curr.val = curr.val > cupCapacity ? cupCapacity : curr.val;
//            curr = curr.next;
//        }
//
//        curr = findChampagneTowerNode(query_row, query_glass);
//
//        return curr.val;
//    }
//
//    private ChampagneTowerNode findChampagneTowerNode(int query_row, int query_glass) {
//        ChampagneTowerNode curr = root;
//        for (int i = 0; i < query_row - query_glass; i++) {
//            curr = curr.left;
//        }
//        for (int i = 0; i < query_glass; i++) {
//            curr = curr.right;
//        }
//        return curr;
//    }
//
//    private void buildChampagneTower(int size) {
//        root = new ChampagneTowerNode(id++);
//
//        ChampagneTowerNode curr = root;
//        for (int i = 0; i < size; i++) {
//            ChampagneTowerNode head = curr, prev = null;
//
//            while (curr != null) {
//                if (prev == null) {
//                    curr.left = new ChampagneTowerNode(id++);
//                    curr.right = new ChampagneTowerNode(id++);
//                    curr.left.next = curr.right;
//                } else {
//                    curr.left = prev.right;
//                    curr.right = new ChampagneTowerNode(id++);
//                    curr.left.next = curr.right;
//                }
//
//                prev = curr;
//                curr = curr.next;
//            }
//
//            curr = head.left;
//        }
//    }
//
//
//    public void printChampagneTower() {
//        ChampagneTowerNode curr = root;
//
//        while (curr != null) {
//            ChampagneTowerNode head = curr;
//            while (curr != null) {
//                System.out.print(curr.id + " ");
//                curr = curr.next;
//            }
//            System.out.println();
//            curr = head.left;
//        }
//    }

    public static void main(String[] args) {
        ChampagneTower test = new ChampagneTower();
        System.out.println(test.champagneTower(9, 4, 1));
//        ChampagneTowerNode curr = test.root;
//        test.buildChampagneTower(5);
//        test.printChampagneTower();
//        System.out.println(test.champagneTower(2, 1, 1));
//        test.printChampagneTower();
    }
}
