package main;

public class WordPattern {
    public boolean wordPattern(String pattern, String str) {
        String[] map = new String[26];

        int curr = 0;
        for (int i = 0; i < pattern.length(); i++) {
            int idx = pattern.charAt(i) - 'a';

            while (curr < str.length() && str.charAt(curr) == ' ') curr++;
            String currWord = getNextWord(str, curr);
            curr += currWord.length();

            if (map[idx] != null && map[idx].equals(currWord)) continue;

            // Check if current char map to current word
            if (currWord.isEmpty() || (map[idx] != null && !map[idx].equals(currWord))) return false;
            // Check if current word haven't been used
            for (String word: map) if (word != null && word.equals(currWord)) return false;

            if (map[idx] == null) map[idx] = currWord;
        }

        if (!getNextWord(str, curr).isEmpty()) return false;

        return true;
    }

    public String getNextWord(String s, int startIdx) {
        int low = startIdx, high = startIdx, len = s.length();

        while (low < len && s.charAt(low) == ' ') {
            low++;
            high++;
        }

        while (high < len && s.charAt(high) != ' ') high++;

        return s.substring(low, high);
    }
}
