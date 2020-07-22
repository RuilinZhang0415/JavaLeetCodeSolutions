package main;

public class PathWithMaximumGold {
    public int getMaximumGold(int[][] grid) {
        row_size = grid.length;
        col_size = grid[0].length;

        int[][] maximum_grid = new int[grid.length][grid[0].length];
        int max_gold = 0;

        for (int row = 0; row < row_size; row++) {
            for (int col = 0; col < col_size; col++) {
                if (grid[row][col] != 0) max_gold = Math.max(max_gold, getMaximumGoldStartingFrom(grid, row, col));
            }
        }

        return max_gold;
    }

    private static int[] move = new int[] {0,-1,0,1,0};
    private int row_size = 0, col_size = 0;

    private int getMaximumGoldStartingFrom(int[][] grid, int row, int col) {
        if (row < 0 || row >= row_size || col < 0 || col >= col_size || grid[row][col] <= 0) return 0;

        int curr_val = grid[row][col], max_sum = 0;
        grid[row][col] = -1; // Mark as visited
        for (int i = 0; i < 4; i++) {
            max_sum = Math.max(max_sum, getMaximumGoldStartingFrom(grid, row + move[i], col + move[i + 1]));
        }
        grid[row][col] = curr_val;

        return max_sum + curr_val;
    }

    public static void main(String[] args) {
        //{{0,6,0},{5,8,7},{0,9,0}}
        //{1,0,7,0,0,0},{2,0,6,0,1,0},{3,5,6,7,4,2},{4,3,1,0,2,0},{3,0,5,0,20,0}
        int[][] grid = new int[][] {{0,0,0,0,0,0,32,0,0,20},{0,0,2,0,0,0,0,40,0,32},{13,20,36,0,0,0,20,0,0,0},{0,31,27,0,19,0,0,25,18,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,18,0,6},{0,0,0,25,0,0,0,0,0,0},{0,0,0,21,0,30,0,0,0,0},{19,10,0,0,34,0,2,0,0,27},{0,0,0,0,0,34,0,0,0,0}};
        PathWithMaximumGold test = new PathWithMaximumGold();

        System.out.print(test.getMaximumGold(grid));

//        System.out.println(test.getMaximumGold(grid));

//        List<int[]> path = new LinkedList<>();
//        System.out.println(test.getMaximumGoldStartingFrom(grid, 0,0, path));

//        for (int row = 0; row < grid.length; row++) {
//            for (int col = 0; col < grid[0].length; col++) {
//                System.out.print(grid[row][col] + " ");
//            }
//            System.out.println();
//        }
//
//        System.out.println();
//
//        List<int[]> path = new LinkedList<>();
//        System.out.println(test.getMaximumGoldStartingFrom(grid, 0, 1, path));
//
//        System.out.println();
//
//        for (int row = 0; row < grid.length; row++) {
//            for (int col = 0; col < grid[0].length; col++) {
//                System.out.print(grid[row][col] + " ");
//            }
//            System.out.println();
//        }
//
//        System.out.println();
//
//        for (int[] coord: path) {
//            System.out.println("(" + coord[0] + " " + coord[1] + ")");
//        }
    }
}
