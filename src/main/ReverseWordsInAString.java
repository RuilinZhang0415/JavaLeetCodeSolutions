package main;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ReverseWordsInAString {
//    public String reverseWords(String s) {
//        s = s.trim();
//        int len = s.length();
//
//        StringBuilder result = new StringBuilder();
//        int curr = len - 1;
//        while (curr >= 0) {
//            while (s.charAt(curr) == ' ') curr--;
//
//            int start = curr;
//            while (start >= 0 && s.charAt(start) != ' ') start--;
//            if (result.length() != 0) result.append(" ");
//            result.append(s.substring(start + 1, curr + 1));
//            curr = start;
//        }
//
//        return result.toString();
//    }

    public String reverseWords(String s) {
        List<String> words = Arrays.asList(s.trim().split(" "));
        Collections.reverse(words);
        return String.join(" ", words);
    }

    public static void main(String[] args) {
        String s = "  hello   world!  ";
        String[] words = s.trim().split(" ");

        for (String word: words) System.out.println("word: " + word);
    }
}
