package main;

import java.util.ArrayDeque;
import java.util.Queue;

public class ReorderRoutesToMakeAllPathsLeadToTheCityZero {
    public int minReorder(int n, int[][] connections) {
        int len = connections.length, modified = 0, curr = 0;

        boolean[] canVisitZero = new boolean[len + 1];
        canVisitZero[0] = true;

        Queue<int[]> unvisited = new ArrayDeque<>();
        unvisited.add(connections[0]);

        while (!unvisited.isEmpty()) {
            if (curr < len - 1) unvisited.add(connections[++curr]);
            int[] path = unvisited.poll();
            if (canVisitZero[path[0]]) {
                modified++;
                canVisitZero[path[1]] = true;
            } else if (canVisitZero[path[1]]) {
                canVisitZero[path[0]] = true;
            } else {
                unvisited.add(path);
            }
        }

        return modified;
    }

    /******************** this method build the correct connections as well ********************/
//    public int minReorder(int n, int[][] connections) {
//        int len = connections.length, modified = 0;
//
//        Set<Integer> canVisitZero = new HashSet<>();
//        canVisitZero.add(0);
//
//        Set<Integer> unvisitedRow = new HashSet<>();
//        for (int i = 0; i < len; i++) unvisitedRow.add(i);
//
//        while (!unvisitedRow.isEmpty()) {
//            Set<Integer> visited = new HashSet<>();
//            for (int curr: unvisitedRow) {
//                // ZERO can visit this city, reverse road, increase count, and then add to can visit
//                if (canVisitZero.contains(connections[curr][0])) {
//                    int temp = connections[curr][0];
//                    connections[curr][0] = connections[curr][1];
//                    connections[curr][1] = temp;
//
//                    modified++;
//
//                    canVisitZero.add(connections[curr][0]);
//
//                    visited.add(curr);
//
//                } else if (canVisitZero.contains(connections[curr][1])) { // This city can visit Zero, add to can visit
//                    canVisitZero.add(connections[curr][0]);
//
//                    visited.add(curr);
//                }
//            }
//            unvisitedRow.removeAll(visited);
//        }
//
//        return modified;
//    }

    public static void main(String[] args) {
        ReorderRoutesToMakeAllPathsLeadToTheCityZero test = new ReorderRoutesToMakeAllPathsLeadToTheCityZero();
        int n = 5;
        int[][] connections = new int[][] {
                {1,0},
                {1,2},
                {3,2},
                {3,4}
        };
        System.out.println(test.minReorder(n, connections));

        for (int i = 0; i < connections.length; i++) {
            System.out.println(connections[i][0] + " " + connections[i][1]);
        }
    }
}
