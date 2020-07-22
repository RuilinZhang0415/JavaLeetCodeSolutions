package main;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class CountSubmatricesWithAllOnes {
    public int numSubmat(int[][] mat) {
        int height = mat.length, width = mat[0].length;

        int curr_level[] = new int[width], result = 0;
        for (int row = 0; row < height; row++) {
            for (int col = 0; col < width; col++) {
                curr_level[col] = mat[row][col] == 0 ? 0 : curr_level[col] + 1;
            }
            result += computeRowSum(curr_level);
        }

        return result;
    }

    public int computeRowSum(int curr_level[]) {
        int addends[] = new int[curr_level.length], result = 0;
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < curr_level.length; i++) {
            while (!stack.isEmpty() && curr_level[stack.peekFirst()] >= curr_level[i]) stack.removeFirst();

            if (!stack.isEmpty()) {
                int preIndex = stack.peekFirst();
                addends[i] = addends[preIndex] + curr_level[i] * (i - preIndex);
            } else {
                addends[i] = curr_level[i] * (i + 1);
            }
            stack.addFirst(i);
            result += addends[i];
        }

        return result;
    }

    /******************** O(N) space, does not modify input ********************/
//    public int numSubmat(int[][] mat) {
//        int M = mat.length, N = mat[0].length;
//
//        int res = 0;
//        for (int up = 0; up < M; ++up) {
//            int[] h = new int[N];
//            Arrays.fill(h, 1);
//            for (int down = up; down < M; ++down) {
//                for (int k = 0; k < N; ++k) h[k] &= mat[down][k];
//                res += countOneRow(h);
//            }
//        }
//
//        return res;
//    }
//
//    private int countOneRow(int[] A) {
//        int res = 0, length = 0;
//        for (int i = 0; i < A.length; ++i) {
//            length = (A[i] == 0 ? 0 : length + 1);
//            res += length;
//        }
//        return res;
//    }

    /******************** In-place, modifies input ********************/
//    public int numSubmat(int[][] mat) {
//        int height = mat.length, width = mat[0].length;
//        for (int i = 0; i < height; i++) {
//            for (int j = 1; j < width; j++) {
//                if (mat[i][j] != 0) mat[i][j] += mat[i][j - 1];
//            }
//        }
//
//        int result = 0;
//        for (int i = 0; i < height; i++) {
//            for (int j = 0; j < width; j++) {
//                if (mat[i][j] == 0) continue;
//
//                int min = mat[i][j];
//                result += min;
//                for (int k = i + 1; k < mat.length; k++) {
//                    if (mat[k][j] == 0) break;
//
//                    min = Math.min(min, mat[k][j]);
//                    result += min;
//                }
//            }
//        }
//
//        return result;
//    }

    /******************** Brute Force ********************/
//    public int numSubmat(int[][] mat) {
//        int result = 0, h = mat.length, w = mat[0].length;
//
//        for (int row = 0; row < h; row++) {
//            for (int col = 0; col < w; col++) {
//                if (mat[row][col] == 0) continue;
//
//                int max_col = w;
//                for (int i = row; i < h; i++) {
//
//                    if (mat[i][col] == 0) break;
//
//                    for (int j = col; j < max_col; j++) {
//                        if (j >= max_col) break;
//
//                        if (mat[i][j] == 1) result++;
//                        else {
//                            max_col = j;
//                            break;
//                        }
//                    }
//
//                }
//
//            }
//        }
//
//        return result;
//    }

//    public int numSubmat(int[][] mat) {
//        int result = 0;
//        for (int i = 0; i < mat.length; i++) {
//            for (int j = 0; j < mat[i].length; j++) {
//
//                for (int row = 0; row + i < mat.length; row++) {
//                    for (int col = 0; col + j < mat[row].length; col++) {
//                        boolean found = true;
//                        for (int temp_i = row; temp_i <= row + i; temp_i++) {
//                            for (int temp_j = col; temp_j <= col + j; temp_j++) {
//                                if (mat[temp_i][temp_j] == 0) found = false;
//                            }
//                        }
//                        if (found) result++;
//                        System.out.println("found: " + result + ", i: " + row + ", j: " + col);
//                    }
//                }
//                System.out.println("result: " + result + ", i: " + i + ", j: " + j);
//            }
//        }
//
//        return result;
//    }

    public static void main(String[] args) {
    }
}
