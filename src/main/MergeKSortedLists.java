package main;

public class MergeKSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }

        // final single sorted list
        ListNode newHead = null;
        // tail node
        ListNode newTail = null;
        // Keeps track of the number of non-null entries in lists
        int count = 0;
        int curr = 0;

        // Compute the number of non-empty lists
        while (curr < lists.length) {
            if (lists[curr] != null) {
                if (curr > count) {
                    lists[count] = lists[curr];
                    lists[curr] = null;
                }
                curr++;
                count++;
            } else {
                curr++;
            }
        }

        // Sort
        quickSortListNode(lists, 0, count-1);

        // Build final single sorted list without sorting
//        while (lists[0] != null) {
//            int index = findIndexOfMin(lists, count);
//
//            if (newHead == null) {
//                newHead = lists[index];
//                newTail = newHead;
//                lists[index] = lists[index].next;
//            } else {
//                newTail.next = lists[index];
//                newTail = newTail.next;
//                lists[index] = lists[index].next;
//            }
//
//            if (lists[index] == null) {
//                lists[index] = lists[--count];
//                lists[count] =  null;
//            }
//        }

        // Build final single sorted list with sorting
        while (lists[0] != null) {
            if (newHead == null) {
                newHead = lists[count-1];
                newTail = newHead;
                lists[count-1] = lists[count-1].next;
            } else {
                newTail.next = lists[count-1];
                newTail = newTail.next;
                lists[count-1] = lists[count-1].next;
            }

            if (lists[count-1] == null) {
                count--;
            } else {
                for (int i = count - 2; i >= 0; i--) {
                    if (lists[i].val < lists[i+1].val) {
                        swap(lists, i, i+1);
                    } else {
                        break;
                    }
                }
            }
        }

        return newHead;
    }

    private void quickSortListNode(ListNode[] lists, int low, int high) {
        if (high > low) {
            int pivotIndex = partition(lists, low, high);
            quickSortListNode(lists, low, pivotIndex - 1);
            quickSortListNode(lists, pivotIndex + 1, high);
        }
    }

    private int partition(ListNode[] lists, int low, int high) {
        int pivot = lists[high].val;
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (lists[j].val > pivot) {
                i++;
                swap(lists, i, j);
            }
        }
        swap(lists, i+1, high);

        return i+1;
    }

    private void swap(ListNode[] lists, int a, int b) {
        ListNode temp = lists[a];
        lists[a] = lists[b];
        lists[b] = temp;
    }

    private int findIndexOfMin(ListNode[] lists, int size) {
        int min = Integer.MAX_VALUE;
        int indexOfMin = -1;

        for (int i = 0; i < size; i++) {
            if (lists[i].val < min) {
                min = lists[i].val;
                indexOfMin = i;
            }
        }

        return indexOfMin;
    }

    public static void main(String[] args) {
        ListNode[] lists = new ListNode[5];
        lists[0] = new ListNode(60);
        lists[1] = new ListNode(50);
//        lists[2] = new main.ListNode(50);
        lists[3] = new ListNode(30);
        lists[4] = new ListNode(70);

        MergeKSortedLists test = new MergeKSortedLists();

        ListNode head = test.mergeKLists(lists);
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
