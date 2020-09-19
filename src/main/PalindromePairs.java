package main;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class PalindromePairs {
    public List<List<Integer>> palindromePairs(String[] words) {
        List<List<Integer>> result = new LinkedList<>();

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) map.put(words[i], i);

        for (String s: map.keySet()) {
            String reversed = new StringBuilder(s).reverse().toString();
            List<List<Integer>> indexes = validPrefixAndSuffix(reversed);

            if (!s.equals(reversed) && map.containsKey(reversed)) result.add(Arrays.asList(map.get(s), map.get(reversed)));

            for (int idx: indexes.get(0)) {
                String word = reversed.substring(idx + 1);
                if (map.containsKey(word)) result.add(Arrays.asList(map.get(s), map.get(word)));
            }

            for (int idx: indexes.get(1)) {
                String word = reversed.substring(0, idx);
                if (map.containsKey(word)) result.add(Arrays.asList(map.get(word), map.get(s)));
            }
        }

        return result;
    }

    private List<List<Integer>> validPrefixAndSuffix(String s) {
        List<List<Integer>> result = new LinkedList<>();
        result.add(new LinkedList<>());
        result.add(new LinkedList<>());
        int len = s.length();
        for (int i = 0; i < len; i++) {
            if (isPalindrome(s, 0, i)) result.get(0).add(i);
            if (isPalindrome(s, i, len - 1)) result.get(1).add(i);
        }

        return result;
    }

    private boolean isPalindrome(String s, int l, int h) {
        while (l < h) if (s.charAt(l++) != s.charAt(h--)) return false;
        return true;
    }


    // Brute force
//    public List<List<Integer>> palindromePairs(String[] words) {
//        List<List<Integer>> result = new LinkedList<>();
//
//        for (int i = 0; i < words.length; i++) {
//            for (int j = 0; j < words.length; j++) {
//                if (i == j) continue;
//                if (isPalindromePair(words[i], words[j])) result.add(new LinkedList<>(Arrays.asList(i, j)));
//            }
//        }
//
//        return result;
//    }
//
//    public boolean isPalindromePair(String s1, String s2) {
//        int l1 = s1.length(), l2 = s2.length();
//        if (s1.length() > s2.length()) {
//            for (int i = 0; i < l2; i++) if (s1.charAt(i) != s2.charAt(l2 - i - 1)) return false;
//            int l = l2, h = l1 - 1;
//            while (l < h) if (s1.charAt(l++) != s1.charAt(h--)) return false;
//        } else {
//            for (int i = 0; i < l1; i++) if (s1.charAt(i) != s2.charAt(l2 - i - 1)) return false;
//            int l = 0, h = l2 - l1 - 1;
//            while (l < h) if (s2.charAt(l++) != s2.charAt(h--)) return false;
//        }
//
//        return true;
//    }

    public static void main(String[] args) {
        PalindromePairs test = new PalindromePairs();
        List<List<Integer>> result = test.validPrefixAndSuffix("a");
        for (int i: result.get(1)) System.out.println(i);
        System.out.println(result.get(1).get(0) != 0);
    }
}
