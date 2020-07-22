package main;

import java.util.LinkedList;
import java.util.List;

public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) return new LinkedList<>();

        int start_row = 0, start_col = 0, end_row = matrix.length - 1, end_col = matrix[0].length - 1;
        List<Integer> result = new LinkedList<>();

        while (true) {
            for (int col = start_col; col <= end_col; col++) result.add(matrix[start_row][col]);
            start_row += 1;
            if (start_row > end_row) break;
            for (int row = start_row; row <= end_row; row++) result.add(matrix[row][end_col]);
            end_col -= 1;
            if (start_col > end_col) break;
            for (int col = end_col; col >= start_col; col--) result.add(matrix[end_row][col]);
            end_row -= 1;
            if (start_row > end_row) break;
            for (int row = end_row; row >= start_row; row--) result.add(matrix[row][start_col]);
            start_col += 1;
            if (start_col > end_col) break;
        }

        return result;
    }


    public static void main(String[] args) {
        int row = 3, col = 5;
        int[][] matrix = new int[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                matrix[i][j] = 1 + j + i * col;
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }

        SpiralMatrix test = new SpiralMatrix();
        System.out.println(test.spiralOrder(matrix));
    }
}
