package main;

public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int height = obstacleGrid.length, width = obstacleGrid[0].length;

        obstacleGrid[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;

        for (int index = 1; index < height; index++) {
            obstacleGrid[index][0] = obstacleGrid[index][0] == 1 ? 0 : obstacleGrid[index - 1][0];
        }

        for (int index = 1; index < width; index++) {
            obstacleGrid[0][index] = obstacleGrid[0][index] == 1 ? 0 : obstacleGrid[0][index - 1];
        }

        for (int row = 1; row < height; row++) {
            for (int col = 1; col < width; col++) {
                obstacleGrid[row][col] =
                        obstacleGrid[row][col] == 1 ? 0 : obstacleGrid[row - 1][col] + obstacleGrid[row][col - 1];
            }
        }

        return obstacleGrid[height - 1][width - 1];
    }

    public static void main(String[] args) {
        UniquePathsII test = new UniquePathsII();
        int[][] arr = new int[][] {{0,0,0}, {0,1,0}, {0,0,0}, {0,0,0}};
        System.out.println(test.uniquePathsWithObstacles(arr));
    }
}
