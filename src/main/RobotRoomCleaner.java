package main;


import java.util.Arrays;

// This is the robot's control interface.
// You should not implement it, or speculate about its implementation
interface Robot {
    // Returns true if the cell in front is open and robot moves into the cell.
    // Returns false if the cell in front is blocked and robot stays in the current cell.
    public boolean move();

    // Robot will stay in the same cell after calling turnLeft/turnRight.
    // Each turn will be 90 degrees.
    public void turnLeft();
    public void turnRight();

    // Clean the current cell.
    public void clean();
}

class RoomRobot implements Robot {
    public int room[][], x, y, dir[] = {-1, 0}, h, w;

    public RoomRobot() {
        room = new int[][] {{1}};
        h = 1;
        w = 1;
    }

    public RoomRobot(int[][] _room, int _x, int _y) {
        h = _room.length;
        w = _room[0].length;
        room = new int[h][w];
        for (int i = 0; i < h; i++) Arrays.copyOf(_room[i], w);
        x = _x;
        y = _y;
    }

    public boolean move() {
        int nextX = x + dir[0], nextY = y +dir[1];
        if (nextX >= 0 && nextX < h && nextY >= 0 && nextY < w && room[nextX][nextY] == 1) {
            x = nextX;
            y = nextY;
            return true;
        }

        return false;
    }

    public void turnLeft() {
        int temp = dir[0];
        dir[0] = -dir[1];
        dir[1] = temp;
    }

    public void turnRight() {

    }

    public void clean() {

    }
}

public class RobotRoomCleaner {
    public void cleanRoom(Robot robot) {

    }
}
