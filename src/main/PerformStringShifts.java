package main;

public class PerformStringShifts {
    public String stringShift(String s, int[][] shift) {
        if (s == null || s.length() <= 1 || shift == null || shift.length == 0) return s;

        int totalShift= 0;
        for (int[] entry: shift) {
            totalShift += entry[1] * (entry[0] == 1 ? 1 : -1);
        }

        int len = s.length();
        totalShift = totalShift % len;
        if (totalShift == 0) return s;
        if (totalShift < 0) totalShift += len;

        return s.substring(len - totalShift) + s.substring(0, len - totalShift);
    }
}
