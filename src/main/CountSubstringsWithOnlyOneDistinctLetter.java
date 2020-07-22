package main;

public class CountSubstringsWithOnlyOneDistinctLetter {
    public int countLetters(String S) {
        if (S == null || S.isEmpty()) return 0;

        int curr = 0, result = 0, len = S.length();
        while (curr < len) {
            int count = 1;
            char c = S.charAt(curr++);
            while (curr < len && S.charAt(curr) == c) {
                count++;
                curr++;
            }
            result += (1 + count) * count / 2;
        }

        return result;
    }

    public static void main(String[] args) {
        CountSubstringsWithOnlyOneDistinctLetter test = new CountSubstringsWithOnlyOneDistinctLetter();
        System.out.println(test.countLetters("aaaba"));
    }
}
