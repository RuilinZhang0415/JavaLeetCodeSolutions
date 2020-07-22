package main;

import java.util.LinkedList;
import java.util.List;

public class SpiralMatrixII {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        int start_row = 0, start_col = 0, end_row = n - 1, end_col = n - 1;
        int count = 1;
        while (true) {
            for (int col = start_col; col <= end_col; col++) matrix[start_row][col] = count++;
            start_row += 1;
            if (start_row > end_row) break;
            for (int row = start_row; row <= end_row; row++) matrix[row][end_col] = count++;
            end_col -= 1;
            if (start_col > end_col) break;
            for (int col = end_col; col >= start_col; col--) matrix[end_row][col] = count++;
            end_row -= 1;
            if (start_row > end_row) break;
            for (int row = end_row; row >= start_row; row--) matrix[row][start_col] = count++;
            start_col += 1;
            if (start_col > end_col) break;
        }

        return matrix;
    }
}
