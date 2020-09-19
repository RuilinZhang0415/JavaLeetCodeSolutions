package main;

import java.util.ArrayList;

public class LRUCache {
    int capacity = 0;
    ArrayList<int[]> keys = new ArrayList<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        int idx = 0, pair[] = null;
        for (idx = 0; idx < keys.size(); idx++) {
            pair = keys.get(idx);
            if (pair[0] == key) break;
        }

        if (idx < keys.size()) {
            keys.remove(idx);
            keys.add(0, pair);
            return pair[1];
        }

        return -1;
    }

    public void put(int key, int value) {
        if (get(key) != -1) {
            keys.get(0)[1] = value;
        } else {
            if (keys.size() < capacity) {
                keys.add(0, new int[] {key, value});
            } else {
                keys.add(0, new int[] {key, value});
                keys.remove(capacity);
            }
        }
    }

    public static void main(String[] args) {
        LRUCache test = new LRUCache(2);
        test.put(1, 11);
        test.put(2, 22);System.out.println(test.keys.get(0)[0] + ", " + test.keys.get(0)[1]);
        test.put(3, 33);

        System.out.println(test.get(3));
    }
}
