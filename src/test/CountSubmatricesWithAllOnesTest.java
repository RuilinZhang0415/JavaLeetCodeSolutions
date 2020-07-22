package test;

import main.CountSubmatricesWithAllOnes;
import org.junit.Test;

import static org.junit.Assert.*;

public class CountSubmatricesWithAllOnesTest {
    CountSubmatricesWithAllOnes test = new CountSubmatricesWithAllOnes();
    @Test
    public void testComputeRowSum() {
        int row[] = new int[] {1,2,1};
        assertEquals(7, test.computeRowSum(row));
        row = new int[] {1,2,3,2,1,2,3};
        assertEquals(39, test.computeRowSum(row));
    }

    @Test
    public void test0() {
        CountSubmatricesWithAllOnes test = new CountSubmatricesWithAllOnes();
        int[][] mat = new int[][] {{0,0,0},{0,0,0},{0,0,0}};
        assertEquals(0, test.numSubmat(mat));
    }

    @Test
    public void test1() {
        CountSubmatricesWithAllOnes test = new CountSubmatricesWithAllOnes();
        int[][] mat = new int[][] {{1,1,1},{1,1,1},{1,1,1}};
        assertEquals(36, test.numSubmat(mat));
    }

    @Test
    public void test2() {
        CountSubmatricesWithAllOnes test = new CountSubmatricesWithAllOnes();
        int[][] mat = new int[][] {{0,0,1,0,0},{0,1,1,1,0},{1,1,1,1,1}};
        assertEquals(30, test.numSubmat(mat));
    }

    @Test
    public void test3() {
        CountSubmatricesWithAllOnes test = new CountSubmatricesWithAllOnes();
        int[][] mat = new int[][] {{1,1,0,1,1,1,1,0,1},
                                   {0,1,1,1,1,0,1,1,0},
                                   {1,0,0,0,0,1,1,1,1},
                                   {0,0,1,0,1,1,1,1,1},
                                   {0,0,0,1,0,1,1,1,1},
                                   {0,0,1,0,0,1,0,1,0}
        };
        assertEquals(122, test.numSubmat(mat));
    }
}
