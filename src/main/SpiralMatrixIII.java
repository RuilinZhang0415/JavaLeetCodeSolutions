package main;

public class SpiralMatrixIII {
    public int[][] spiralMatrixIII(int R, int C, int r0, int c0) {
        int[][] result = new int[R * C][2];

        int n = 0, dx = 0, dy = 1, temp;
        for (int row = 0; row < R * C; n++) {
            for (int i = 0; i < n / 2 + 1; i++) { // Move
                if (r0 >= 0 && r0 < R && c0 >= 0 && c0 < C) {
                    result[row++] = new int[] {r0, c0};
                }
                r0 += dx;
                c0 += dy;
            }
            // Turn right
            temp = dx;
            dx = dy;
            dy = -temp;
        }

        return result;
    }

    public static void main(String[] args) {
        SpiralMatrixIII test = new SpiralMatrixIII();
        int[][] matrix = test.spiralMatrixIII(5, 6, 1, 4);
        for (int i = 0; i < matrix.length; i++) {
            System.out.println("row " + i + ": " + matrix[i][0] + ", " + matrix[i][1]);
        }
    }
}
