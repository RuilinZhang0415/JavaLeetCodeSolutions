package test;

import main.TheMazeII;
import org.junit.Test;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.junit.Assert.*;

public class TheMazeIITest {
    @Test
    public void test() {
        TheMazeII test = new TheMazeII();

        int[][] maze = {{0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}};
        int[] start = {0, 4}, end = {4, 4};

        System.out.println(test.shortestDistance(maze, start, end));
    }
}
