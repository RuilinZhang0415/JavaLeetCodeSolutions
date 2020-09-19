package main;

import java.util.ArrayList;
import java.util.HashMap;

public class LFUCache {
    class Node {
        int key, value, idx;
        Node prev, next;
        Node () { this.key = 0; this.value = 0; }
        Node (int key, int value) { this.key = key; this.value = value; }
    }

    private void addFrequencyEntry() {
        Node head = new Node();
        Node tail = new Node();
        head.next = tail;
        tail.prev = head;
        frequency.add(new Node[] {head, tail});
    }

    private void addNode(Node node) {
        if (node.idx == frequency.size()) addFrequencyEntry();

        Node head = frequency.get(node.idx)[0];
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;

        if (node.idx < minFrequency) minFrequency = node.idx;
    }

    private int removeNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        prev.next = next;
        next.prev = prev;
        return node.key;
    }

    private int moveToNext(Node node) {
        if (node == null) return -1;

        removeNode(node);
        node.idx++;
        addNode(node);

        Node pair[] = frequency.get(node.idx - 1);
        if (node.idx - 1 == minFrequency && pair[0].next == pair[1]) minFrequency++;

        return node.value;
    }

    private int popTail() {
        Node tail = frequency.get(minFrequency)[1];
        return removeNode(tail.prev);
    }

    private void update(Node node, int newValue) {
        node.value = newValue;
        moveToNext(node);
    }

    private HashMap<Integer, Node> cache = new HashMap<>();
    private ArrayList<Node[]> frequency = new ArrayList<>();
    private int size = 0, minFrequency = 0;
    private final int capacity;

    public LFUCache(int capacity) {
        this.capacity = capacity;
    }

    public int get(int key) {
        return moveToNext(cache.get(key));
    }

    public void put(int key, int value) {
        if (capacity == 0) return;

        if (cache.containsKey(key)) {
            update(cache.get(key), value);
        } else {
            if (size >= capacity) cache.remove(popTail());

            Node node = new Node(key, value);
            addNode(node);
            cache.put(key, node);
            minFrequency = 0;
            size++;
        }
    }

    public static void main(String[] args) {
        LFUCache test = new LFUCache(2);

        test.put(1, 11);
        test.get(1);
        test.put(1, 11);

        test.put(2, 22);
        test.get(2);
        test.put(2, 22);

        test.put(3, 33);

        test.get(2);
        test.get(2);

        System.out.println("capacity: " + test.capacity);

        System.out.println("size: " + test.size);
        System.out.println("minFreq: " + test.minFrequency);
        System.out.println("value: " + test.cache.get(3).value);
        System.out.println("freq size: " + test.frequency.size());
    }
}
