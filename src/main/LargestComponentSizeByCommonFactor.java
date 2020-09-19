package main;

import java.util.*;



public class LargestComponentSizeByCommonFactor {
    public int[] parent;
    public int[] size;

    public int largestComponentSize(int[] A) {
        int maxVal = Arrays.stream(A).reduce(A[0], (x, y) -> x > y ? x : y), len = A.length;

        parent = new int[maxVal + 1];
        size = new int[maxVal + 1];
        for (int i = 0; i < maxVal + 1; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        int[] factor = new int[len];

        for (int i = 0; i < len; i++) {
            if (A[i] <= 1) continue;

            Iterator<Integer> iter = primeDecompose(A[i]).iterator();
            int prev, curr = iter.next();
            factor[i] = curr;
            while (iter.hasNext()) {
                prev = curr;
                curr = iter.next();
                union(prev, curr);
            }
        }

        int maxCount = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int key = find(factor[i]);
            int count = map.getOrDefault(key, 0);
            map.put(key, count + 1);
            maxCount = Math.max(maxCount, count + 1);
        }

        return maxCount;
    }

    public int find(int x) {
        if (parent[x] != x) parent[x] = find(parent[x]);
        return parent[x];
    }

    public void union(int x, int y) {
        x = find(x);
        y = find(y);

        if (x == y) return;

        parent[y] = x;
        size[x] += size[y];
    }

    public LinkedList<Integer> primeDecompose(int num) {
        LinkedList<Integer> factors = new LinkedList<>();

        int factor = 2;
        while (num >= factor * factor) {
            if (num % factor == 0) {
                factors.add(factor);
                while (num % factor == 0) num /= factor;
            } else {
                factor++;
            }
        }
        if (num != 1) factors.add(num);

        return factors;
    }
}
