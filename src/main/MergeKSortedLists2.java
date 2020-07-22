package main;

public class MergeKSortedLists2 {
    public ListNode mergeKLists(ListNode[] lists) {
        return divideAndCombine(lists, 0, lists.length - 1);
    }

    private ListNode divideAndCombine(ListNode[] lists, int low, int high) {
        if (low == high) {
            return lists[low];
        }
        int mean = (low + high) / 2;
        ListNode left = divideAndCombine(lists, low, mean);
        ListNode right = divideAndCombine(lists, mean + 1, high);

        return merge(left, right);
    }

    private ListNode merge(ListNode left, ListNode right) {
        if (left == null) {
            return right;
        } else if (right == null) {
            return left;
        }

        ListNode head, tail;
        if (left.val < right.val) {
            head = left;
            left = left.next;
        } else {
            head = right;
            right = right.next;
        }
        tail = head;

        while (left != null || right != null) {
            if (left == null) {
                tail.next = right;
                right = null;
            } else if (right == null) {
                tail.next = left;
                left = null;
            } else if (left.val < right.val) {
                tail.next = left;
                tail = tail.next;
                left = left.next;
            } else {
                tail.next = right;
                tail = tail.next;
                right = right.next;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        ListNode[] lists = new ListNode[5];
        lists[0] = new ListNode(20);
        lists[0].next = new ListNode(40);
        lists[0].next.next = new ListNode(60);
        lists[1] = new ListNode(10);
        lists[1].next = new ListNode(30);
        lists[1].next.next = new ListNode(50);

        MergeKSortedLists2 test = new MergeKSortedLists2();

        ListNode head = test.merge(lists[0], lists[1]);
        ListNode curr = head;

        while (curr != null) {
            System.out.print(curr.val + " ");
            curr = curr.next;
        }

//        for (int i = 0; i < lists.length; i++) {
//            System.out.print(lists[i].val + " ");
//        }
//        test.quickSortListNode(lists, 0, lists.length-1);
//        for (int i = 0; i < lists.length; i++) {
//            System.out.print(lists[i].val + " ");
//        }
    }
}
