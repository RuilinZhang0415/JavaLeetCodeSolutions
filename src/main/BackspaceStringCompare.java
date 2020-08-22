package main;

public class BackspaceStringCompare {
    private static final char back_space = '#';

    public boolean backspaceCompare(String S, String T) {
        char[] s_arr = S.toCharArray(), t_arr = T.toCharArray();
        int s = prevCharIndex(s_arr, s_arr.length), t = prevCharIndex(t_arr, t_arr.length);

        while (s >= 0 && t >= 0) {
            if (s_arr[s] != t_arr[t]) return false;

            s = prevCharIndex(s_arr, s);
            t = prevCharIndex(t_arr, t);
        }

        return s == t;
    }

    public int prevCharIndex(char[] arr, int curr) {
        if (curr <= 0) return -1;

        curr -= 1;
        int back = 0;
        while (curr >= 0 && (back > 0 || arr[curr] == back_space)) {
            back += arr[curr] == back_space ? 1 : -1;
            curr--;
            // System.out.println("count: " + count + ", curr: " + curr);
        }

        return curr;
    }
}
