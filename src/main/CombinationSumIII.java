package main;

import java.util.LinkedList;
import java.util.List;

public class CombinationSumIII {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> re = new LinkedList<>();
        if (k > 9) return re;
        this.backtrack(n, k, 1, new LinkedList<>(), re);

        return re;
    }

    private void backtrack(int n, int k, int low, LinkedList<Integer> curr, List<List<Integer>> results) {
        int size = curr.size();

        if (n == 0 && size == k) {
            results.add(new LinkedList<>(curr));
            return;
        } else if (n < 0 || size == k) {
            return;
        }
        
        for (int i = low; i <= 10 - (k - size); i++) {
            curr.add(i);
            this.backtrack(n - i, k, i + 1, curr, results);
            curr.removeLast();
        }
    }

    public static void main(String[] args) {
        CombinationSumIII test = new CombinationSumIII();
        List<List<Integer>> result = test.combinationSum3(3, 9);

        for (List<Integer> l: result) {
            for (int i: l) {
                System.out.print(i + ", ");
            }
            System.out.println();
        }
    }
}
