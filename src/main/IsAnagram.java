package main;

import java.util.Arrays;

public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] count = new int[26];

        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }
        for (int i: count) if (i != 0) return false;
        return true;
    }

//    public boolean isAnagram(String s, String t) {
//        if (s.length() != t.length()) return false;
//
//        char[] s_arr = s.toCharArray();
//        char[] t_arr = t.toCharArray();
//        Arrays.sort(s_arr);
//        Arrays.sort(t_arr);
//        for (int i = 0; i < s.length(); i++) if (s_arr[i] != t_arr[i]) return false;
//        return true;
//    }
}
