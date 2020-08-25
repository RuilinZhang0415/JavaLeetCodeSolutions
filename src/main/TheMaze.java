package main;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;

public class TheMaze {
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int height = maze.length, width = maze[0].length;
        int[][] directions = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

        Deque<int[]> queue = new ArrayDeque<>();
        queue.addFirst(start);
        maze[start[0]][start[1]] = -1;

        while (!queue.isEmpty()) {
            int[] point = queue.remove();

            for (int[] dir: directions) {
                int x = point[0] + dir[0];
                int y = point[1] + dir[1];
                while (x >= 0 && y >= 0 && x < height && y < width && maze[x][y] <= 0) {
                    x += dir[0];
                    y += dir[1];
                }
                if (maze[x - dir[0]][y - dir[1]] == 0) {
                    queue.add(new int[]{x - dir[0], y - dir[1]});
                    maze[x - dir[0]][y - dir[1]] = -1;
                }
            }

            if (maze[destination[0]][destination[1]] == -1) return true;
        }

        return false;
    }

//            int x = point[0], y = point[1];
//            while (x > 0 && maze[x - 1][y] <= 0) x--;
//            if (maze[x][y] == 0) {
//                maze[x][y] = -1;
//                queue.addFirst(new int[] {x, y});
//            }
//
//            x = point[0]; y = point[1];
//            while (x < height - 1 && maze[x + 1][y] <= 0) x++;
//            if (maze[x][y] == 0) {
//                maze[x][y] = -1;
//                queue.addFirst(new int[] {x, y});
//            }
//
//            x = point[0]; y = point[1];
//            while (y > 0 && maze[x][y - 1] <= 0) y--;
//            if (maze[x][y] == 0) {
//                maze[x][y] = -1;
//                queue.addFirst(new int[] {x, y});
//            }
//
//            x = point[0]; y = point[1];
//            while (y < width - 1 && maze[x][y + 1] <= 0) y++;
//            if (maze[x][y] == 0) {
//                maze[x][y] = -1;
//                queue.addFirst(new int[] {x, y});
//            }

    /******************* Note: Using a map is redundant. *******************/
//    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
//        int height = maze.length, width = maze[0].length;
//
//        HashMap<Integer, int[]> visited = new HashMap<>();
//        visited.put(start[0], new int[width + 1]);
//        Deque<int[]> queue = new ArrayDeque<>();
//        queue.addFirst(start);
//
//        while (!queue.isEmpty()) {
//            int[] point = queue.remove();
//            int x = point[0], y = point[1];
//
//            while (x > 0 && maze[x - 1][y] == 0) x--;
//            if (x != point[0]) addIfAbsent(visited, queue, x, y, width);
//
//            x = point[0]; y = point[1];
//            while (x < height - 1 && maze[x + 1][y] == 0) x++;
//            if (x != point[0]) addIfAbsent(visited, queue, x, y, width);
//
//            x = point[0]; y = point[1];
//            while (y > 0 && maze[x][y - 1] == 0) y--;
//            if (y != point[1]) addIfAbsent(visited, queue, x, y, width);
//
//            x = point[0]; y = point[1];
//            while (y < width - 1 && maze[x][y + 1] == 0) y++;
//            if (y != point[1]) addIfAbsent(visited, queue, x, y, width);
//        }
//
//        int x = destination[0], y = destination[1];
//        if (visited.containsKey(x) && visited.get(x)[y] == 1) return true;
//        else return false;
//    }

//    public boolean destinationReachable(int[][] maze, int[] destination) {
//        int h = maze.length - 1, w = maze[0].length - 1, x = destination[0], y = destination[1];
//
//        if (maze[x][y] == 1) {
//            return false;
//        } else if ((x == h || maze[x + 1][y] == 1) && (x == 0 || maze[x - 1][y] == 1) && (y > 0 && maze[x][y - 1] == 0) && (y < w && maze[x][y + 1] == 0)) {
//            return false;
//        } else if ((x < h && maze[x + 1][y] == 0) && (x > 0 && maze[x - 1][y] == 0) && (y == 0 || maze[x][y - 1] == 1) && (y == w || maze[x][y + 1] == 1)) {
//            return false;
//        } else if ((x == h || maze[x + 1][y] == 1) && (x == 0 || maze[x - 1][y] == 1) && (y == 0 || maze[x][y - 1] == 1) && (y == w || maze[x][y + 1] == 1)) {
//            return false;
//        } else if ((x < h && maze[x + 1][y] == 0) && (x > 0 && maze[x - 1][y] == 0) && (y > 0 && maze[x][y - 1] == 0) && (y < w && maze[x][y + 1] == 0)) {
//            return false;
//        }
//
//        return true;
//    }

    private void addIfAbsent(HashMap<Integer, int[]> visited, Deque<int[]> queue, int x, int y, int width) {
        if (!visited.containsKey(x) || visited.get(x)[y] == 0) {
            if (!visited.containsKey(x)) visited.put(x, new int[width + 1]);
            visited.get(x)[y] = 1;
            queue.addFirst(new int[] {x, y});
        }
    }
}
