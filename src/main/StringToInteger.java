package main;

import java.util.regex.*;
import java.lang.Math;

public class StringToInteger {
    public int myAtoi(String s) {
        if (s != null) {
            Pattern p = Pattern.compile("^\\s*([\\-|\\+]?\\d+).*$");
            Matcher m = p.matcher(s);
            if (m.matches()) {
                double re = Double.parseDouble(m.group(1));
                int lower_bound = (int)Math.pow(2, 31) * (-1);
                int upper_bound = (int)Math.pow(2, 31) - 1;
                if (re < lower_bound) {
                    return lower_bound - 1;
                } else if (re > upper_bound) {
                    return upper_bound + 1;
                } else {
                    return (int)re;
                }
            }
        }

        return 0;
    }

    public static void main(String[] args) {
        String s = "91283472339";
        StringToInteger test = new StringToInteger();
        System.out.println(test.myAtoi(s));
    }
}