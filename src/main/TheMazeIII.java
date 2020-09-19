package main;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.PriorityQueue;

public class TheMazeIII {
    class Point implements Comparable<Point> {
        int x, y, dis;
        String path;
        public Point(int _x, int _y) { x = _x; y = _y; dis = Integer.MAX_VALUE; path = ""; }
        public Point(int _x, int _y, int _dis, String _path) { x = _x; y = _y; dis = _dis; path = _path; }
        public int compareTo(Point p) { return dis == p.dis ? path.compareTo(p.path) : dis - p.dis; }
    }

    public String findShortestWay(int[][] maze, int[] start, int[] end) {
        int height = maze.length, width = maze[0].length;
        int[][] dirs = {{0, 1} ,{0, -1}, {-1, 0}, {1, 0}};
        String[] path = {"r", "l", "u", "d"};

        Point[][] points = new Point[height][width];
        for (int i = 0; i < height * width; i++) points[i / width][i % width] = new Point(i / width, i % width);

        PriorityQueue<Point> queue = new PriorityQueue<>(); // BFS
        queue.offer(new Point(start[0], start[1], 0, ""));

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            if (points[p.x][p.y].compareTo(p) > 0) {
                points[p.x][p.y] = p;

                for (int i = 0; i < 4; i++) {
                    int dx = dirs[i][0], dy = dirs[i][1];
                    int x = p.x, y = p.y, currDis = p.dis;
                    //     <------------------- Cells in range and empty --------------->     <--- Destination Reached --->
                    while (x >= 0 && y >= 0 && x < height && y < width && maze[x][y] == 0 && (x != end[0] || y != end[1])) {
                        x += dx; y += dy; currDis++;
                    }

                    if (x != end[0] || y != end[1]) { // Did not reach destination
                        x -= dx; y -= dy; currDis--;
                    }

                    queue.offer(new Point(x, y, currDis, p.path + path[i]));
                }
            }
        }

        Point endPoint = points[end[0]][end[1]];
        if (endPoint.dis < Integer.MAX_VALUE) return endPoint.path;
        else return "impossible";
    }
}
