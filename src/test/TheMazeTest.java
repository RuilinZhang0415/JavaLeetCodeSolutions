package test;

import main.TheMaze;
import org.junit.Test;

import static org.junit.Assert.*;

public class TheMazeTest {
//    @Test
//    public void testDestinationReachable() {
//        TheMaze test = new TheMaze();
//
//        int[][] maze0 = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
//        assertFalse(test.destinationReachable(maze0, new int[] {1, 1}));
//
//        int[][] maze1 = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
//        assertFalse(test.destinationReachable(maze1, new int[] {1, 1}));
//
//        int[][] maze2 = {{0, 0, 0}, {1, 0, 1}, {0, 0, 0}};
//        assertFalse(test.destinationReachable(maze2, new int[] {1, 1}));
//
//        int[][] maze3 = {{0, 1, 0}, {0, 0, 0}, {0, 1, 0}};
//        assertFalse(test.destinationReachable(maze3, new int[] {1, 1}));
//
//        int[][] maze4 = {{0, 1, 0}, {1, 0, 1}, {0, 1, 0}};
//        assertFalse(test.destinationReachable(maze4, new int[] {1, 1}));
//
//        int[][] maze5 = {{0, 1, 0}, {1, 0, 1}, {0, 1, 0}};
//        assertFalse(test.destinationReachable(maze5, new int[] {0, 0}));
//        assertFalse(test.destinationReachable(maze5, new int[] {0, 2}));
//        assertFalse(test.destinationReachable(maze5, new int[] {2, 0}));
//        assertFalse(test.destinationReachable(maze5, new int[] {2, 2}));
//
//        assertTrue(test.destinationReachable(maze1, new int[] {0, 0}));
//        assertTrue(test.destinationReachable(maze1, new int[] {0, 2}));
//        assertTrue(test.destinationReachable(maze1, new int[] {2, 0}));
//        assertTrue(test.destinationReachable(maze1, new int[] {2, 2}));
//    }

    @Test
    public void test() {
        TheMaze test = new TheMaze();

        int[][] maze = {{0, 0, 1, 0, 0}, {0, 0, 0, 0, 0}, {0, 0, 0, 1, 0}, {1, 1, 0, 1, 1}, {0, 0, 0, 0, 0}};
        int[] start = {0, 4}, destination = {4, 4};

        assertTrue(test.hasPath(maze, start, destination));

        destination = new int[] {3, 2};
        assertFalse(test.hasPath(maze, start, destination));
    }
}
