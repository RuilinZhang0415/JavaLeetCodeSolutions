package test;

import main.PancakeSorting;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class PancakeSortingTest {
    @Test
    public void test() {
        PancakeSorting test = new PancakeSorting();

        int[] arr = {3, 2, 1, 4};
        List<Integer> l = test.pancakeSort(arr);
        for (int i: arr) System.out.print(i + ", ");
        System.out.println();
        for (int i: l) System.out.print(i + ", ");
    }
}
