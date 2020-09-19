package main;

import java.util.HashSet;

public class WordPatternII {
    public boolean wordPatternMatch(String pattern, String str) {
        String[] map = new String[26];
        HashSet<String> set = new HashSet<>();

        return aux(pattern, 0, pattern.length() - 1, str, 0, str.length() - 1, map, set);
    }

    private boolean aux(String p, int pStart, int pEnd, String s, int sStart, int sEnd, String[] map, HashSet<String> set) {
        if (pStart > pEnd && sStart > sEnd) return true;
        if ((pStart > pEnd && sStart <= sEnd) || (pStart <= pEnd && sStart > sEnd)) return false;


        int idx = p.charAt(pStart) - 'a';
        if (map[idx] != null) { // Current pattern has been matched with a word
            String word = map[idx];
            int len = word.length();

            if (sStart + len - 1 > sEnd) return false;
            if (!word.equals(s.substring(sStart, sStart + len))) return false;
            return aux(p, pStart + 1, pEnd, s, sStart + len, sEnd, map, set);
        } else { // Current pattern has not been matched
            int reservedSpace = 0;
            for (int i = pStart + 1; i <= pEnd; i++) {
                reservedSpace += map[p.charAt(i) - 'a'] == null ? 1 : map[p.charAt(i) - 'a'].length();
            }

            for (int i = sStart; i <= sEnd - reservedSpace; i++) {
                String currWord = s.substring(sStart, i + 1);
                if (set.contains(currWord)) continue;

                map[idx] = currWord;
                set.add(currWord);

                if (aux(p, pStart + 1, pEnd, s, sStart + currWord.length(), sEnd, map, set)) {
                    return true;
                } else {
                    map[idx] = null;
                    set.remove(currWord);
                }
            }
        }
        return false;
    }
}
