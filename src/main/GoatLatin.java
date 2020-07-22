package main;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class GoatLatin {
    private static final Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    public String toGoatLatin(String S) {
        StringBuilder result = new StringBuilder(), toAppend = new StringBuilder("maa");
        for (String word: S.split(" ")) {
            if (result.length() != 0) result.append(" ");
            if (!vowels.contains(word.charAt(0))) {
                result.append(word.substring(1)).append(word.charAt(0));
            } else {
                result.append(word);
            }
            result.append(toAppend);
            toAppend.append('a');
        }

        return result.toString();
    }

    public static void main(String[] args) {
        GoatLatin test = new GoatLatin();
        System.out.println(test.toGoatLatin("I speak Goat Latin"));
//        String s = "Imaa speak Goat Latin";
//        StringBuilder sb = new StringBuilder(s);
//        System.out.println(sb.charAt(5));
    }
}
