package main;

public class ImageOverlap {
    // Brute force
    public int largestOverlap(int[][] A, int[][] B) {
        int max = 0, m = A.length, n = A[0].length;

        for (int x = -m + 1; x < m; x++)
            for (int y = -n + 1; y < n; y++)
                max = Math.max(max, currOverlap(A, B, x, y));

        return max;
    }

    // Shift A and place A on B
    public int currOverlap(int[][] A, int[][] B, int xShift, int yShift) {
        int overlap = 0, m = A.length, n = A[0].length;

        for (int r = 0; r < m - Math.abs(xShift); r++) {
            for (int c = 0; c < n - Math.abs(yShift); c++) {
                int aRow = r, aCol = c, bRow = r, bCol = c;
                if (xShift >= 0) bRow = r + xShift;
                else aRow = r - xShift;

                if (yShift >= 0) bCol = c + yShift;
                else aCol = c - yShift;

                if (A[aRow][aCol] == 1 && B[bRow][bCol] == 1) overlap++;
            }
        }

        return overlap;
    }
}
