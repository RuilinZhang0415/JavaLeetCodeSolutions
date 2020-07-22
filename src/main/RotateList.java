package main;

public class RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null || head.next == null) return head;

        int size = 1;
        ListNode curr = head;
        while (curr.next != null) {
            curr = curr.next;
            size++;
        }
        curr.next = head;
        curr = curr.next;

        k = size - (k % size) - 1;
        ListNode newHead = null;
        while (k > 0) {
            curr = curr.next;
            k--;
        }
        newHead = curr.next;
        curr.next = null;

        return newHead;
    }

//    public ListNode rotateRight(ListNode head, int k) {
//        if (k == 0 || head == null || head.next == null) return head;
//
//        int size = 0;
//        ListNode tail = head, newTail = null;
//
//        while (tail.next != null) {
//            if (newTail != null) newTail = newTail.next;
//            tail = tail.next;
//            size++;
//            if (size == k) newTail = head;
//        }
//
//        if (newTail != null) {
//            ListNode newHead = newTail.next;
//            newTail.next = null;
//            tail.next = head;
//            return newHead;
//        } else {
//            return rotateRight(head, k % (size + 1));
//        }
//    }

    public static void main(String[] args) {
        RotateList test = new RotateList();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        ListNode curr = head;
        while (curr != null) {
            System.out.println(curr.val);
            curr = curr.next;
        }

        curr = test.rotateRight(head, 2);
        while (curr != null) {
            System.out.println(curr.val);
            curr = curr.next;
        }
    }
}
