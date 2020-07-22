package main;

public class UniquePaths {
    private static long[][] grid = new long[100][100];
    private static boolean built = false;

    public UniquePaths() {
        if (!built) {
            for (int index = 0; index < 100; index++) {
                grid[index][0] = 1L;
                grid[0][index] = 1L;
            }

            for (int row = 1; row < 100; row++) {
                for (int col = 1; col < 100; col++) {
                    grid[row][col] = grid[row - 1][col] + grid[row][col - 1];
                }
            }
            built = true;
        }
    }

    public int uniquePaths(int m, int n) {
        return (int)grid[m - 1][n - 1];
    }

    public static void main(String[] args) {
        UniquePaths test = new UniquePaths();
        for (int i = 0; i < 100; i++) {
            for (int j = 0; j < 100; j++) {
                System.out.print(UniquePaths.grid[i][j] + " ");
            }
            System.out.println();
        }
    }
}
