package test;

import main.PartitionLabels;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PartitionLablesTest {
    @Test
    public void test() {
        PartitionLabels test = new PartitionLabels();

        String s = "ababcbacadefegdehijhklij";
        List<Integer> list = test.partitionLabels(s);
        for (int i : list) System.out.println(i);
    }
}
