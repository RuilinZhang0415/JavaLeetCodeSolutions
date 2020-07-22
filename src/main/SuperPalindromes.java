package main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SuperPalindromes {
    private static List<Long> all_super_palindromes = new ArrayList<Long>();
    static int len = 0;

    public int superpalindromesInRange(String L, String R) {
        long low = Long.parseLong(L);
        long high = Long.parseLong(R);

        addSuperPalindromes(high);

        int count = 0;
        for (long num: all_super_palindromes) {
            if (num >= low && num <= high) count++;
        }

        return count;
    }

    private void addSuperPalindromes(long high) {
        if (len > 5) return;

        int curr_len = String.valueOf(high).length();
        if (curr_len <= len) curr_len = len + 1;
        long start = (long)Math.pow(10, len);
        long end = (long)Math.pow(10, curr_len);
        len = curr_len;

        List<Long> all_palindromes = new ArrayList<Long>();
        for (long i = start; i < end; i++) {
            String str = Long.toString(i);
            StringBuilder str_builder = new StringBuilder();
            str_builder.append(str);
            str_builder.reverse();
            String str_reversed = str_builder.toString();
            all_palindromes.add(Long.parseLong(str + str_reversed));
            all_palindromes.add(Long.parseLong(str + str_reversed.substring(1)));
        }

        for (long x: all_palindromes) {
            long num = (long)Math.pow(x, 2);
            if (isPalindrome(num)) {
                all_super_palindromes.add(num);
            }
        }

        Collections.sort(all_super_palindromes);
    }

    private boolean isPalindrome(long x) {
        int len = String.valueOf(x).length();
        long[] digits = new long[len];
        for (int i = 0; i < len; i++) {
            digits[i] = (x % (long)Math.pow(10, i + 1)) / (long)Math.pow(10, i);
            if (i >= len / 2) {
                if (digits[i] != digits[len - i - 1]) {
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {
        long x = 321;
        int len = 9;

        SuperPalindromes test = new SuperPalindromes();
        test.superpalindromesInRange("10", "1000");
        System.out.print(SuperPalindromes.all_super_palindromes);
        test.superpalindromesInRange("10", "1000");
        System.out.print(SuperPalindromes.all_super_palindromes);
    }
}
