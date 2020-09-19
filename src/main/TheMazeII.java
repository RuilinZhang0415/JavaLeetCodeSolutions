package main;

import java.awt.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class TheMazeII {
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        int height = maze.length, width = maze[0].length;
        int[][] dirs={{0, 1} ,{0, -1}, {-1, 0}, {1, 0}};

        int[][] distance = new int[height][width];
        for (int[] row: distance) Arrays.fill(row, Integer.MAX_VALUE);
        distance[start[0]][start[1]] = 0;

        Deque<int[]> queue = new ArrayDeque<>();
        queue.add(start);

        while (!queue.isEmpty()) {
            int[] point = queue.remove();

            for (int[] dir : dirs) {
                int x = point[0], y = point[1], currDistance = distance[x][y];
                x += dir[0];
                y += dir[1];

                while (x >= 0 && y >= 0 && x < maze.length && y < maze[0].length && maze[x][y] == 0) {
                    x += dir[0];
                    y += dir[1];
                    currDistance++;
                }

                x -= dir[0];
                y -= dir[1];
                if (distance[x][y] > currDistance) {
                    distance[x][y] = currDistance;
                    queue.add(new int[] {x, y});
                }
            }
        }

        int currDistance = distance[destination[0]][destination[1]];
        if (currDistance < Integer.MAX_VALUE) return currDistance;
        else return -1;
    }
}
