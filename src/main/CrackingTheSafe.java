package main;

import java.util.HashSet;
import java.util.Set;

public class CrackingTheSafe {
    /******************** Euler Path ********************/
    Set<String> visited;
    StringBuilder result;

    public String crackSafe(int n, int k) {
        if (n == 1 && k == 1) return "0";
        visited = new HashSet();
        result = new StringBuilder();

        String start_node = new String();
        for (int i = 0; i < n - 1; i++) start_node += 0;

        dfs(new String(start_node), k);
        result.insert(0, start_node);

        return new String(result);
    }

    public void dfs(String str, int k) {
        for (int i = 0; i < k; i++) {
            String temp = str + i;
            if (!visited.contains(temp)) {
                visited.add(temp);
                dfs(temp.substring(1), k);
                result.insert(0, i);
                // The output is the reverse order in which the nodes were traversed
//                System.out.println(result + " " + temp.substring(1));
            }
        }
    }

    /******************** inverse Burrows—Wheeler transform ********************/
//    private static final int VISITED = -1;
//
//    public String crackSafe(int n, int k) {
//        if (k == 1) {
//            char[] result = new char[n];
//            for (int i = 0; i < n; i++) result[i] = '0';
//            return new String(result);
//        }
//
//        // Inverse Burrows—Wheeler transform
//        int size = (int)Math.pow(k, n);
//        // Build w (no need to)
//
//        // Build w'
//        int[] w_p = new int[size];
//        int pattern_size = size / k;
//        for (int index = 0; index < size; index++) {
//            w_p[index] = k * (index % pattern_size) + (index / pattern_size);
//        }
//        // Build the Standard Permutation notation cycles
//        char[] result = new char[size];
//
//        int curr = 0, i = 0;
//        while (curr < size) {
//            if (w_p[curr] == VISITED) {
//                curr++;
//            } else {
//                result[i++] = (char)('0' + curr / pattern_size);
//                int temp = curr;
//                curr = w_p[curr];
//                w_p[temp] = VISITED;
//            }
//        }
//
//        String res = new String(result);
//        if (size > 2 && n > 1) res += res.substring(0, n - 1);
//
//        return res;
//    }

    public static void main(String[] args) {
        CrackingTheSafe test = new CrackingTheSafe();

        int n = 3, k = 2;
        System.out.print(test.crackSafe(n, k));
    }
}
