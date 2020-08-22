package test;

import main.BestTimeToBuyAndSellStockIII;
import org.junit.Test;
import static org.junit.Assert.*;

public class BestTimeToBuyAndSellStockIIITest {
    @Test
    public void testMaxProfit() {
        BestTimeToBuyAndSellStockIII test = new BestTimeToBuyAndSellStockIII();

        int arr[] = {10, 20, 30, 40, 50};
        assertEquals(40, test.maxProfit(arr));
        System.out.println();
        arr = new int[] {40, 30, 20, 10, 0};
        assertEquals(0, test.maxProfit(arr));
        System.out.println();
        arr = new int[] {50, 90, 60, 100};
        assertEquals(80, test.maxProfit(arr));
        System.out.println();
        arr = new int[] {100, 50 ,80, 30, 80, 0, 80};
        assertEquals(130, test.maxProfit(arr));
    }
}