package main;

import java.util.*;

public class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        ArrayList<Integer> result = new ArrayList<>();

        LinkedHashMap<Character, int[]> map = new LinkedHashMap<>();

        for (int i = 0; i < S.length(); i++) {
            if (map.containsKey(S.charAt(i))) map.get(S.charAt(i))[1] = i;
            else map.put(S.charAt(i), new int[] {i, i});
        }

        map.put('\0', new int[] {Integer.MAX_VALUE, Integer.MAX_VALUE});

        int start = 0, end = 0;
        for (char c: map.keySet()) {
            int[] range = map.get(c);

            if (range[0] <= end) {
                if (range[1] > end) end = range[1];
            } else {
                result.add(end - start + 1);
                start = range[0];
                end = range[1];
            }
        }

        return result;
    }
}
