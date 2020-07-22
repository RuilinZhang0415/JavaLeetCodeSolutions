package main;

public class AddTwoNumbers {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode ptr1 = l1, ptr2 = l2, head = null, tail = null;
        int flag = 0;

        while (ptr1 != null || ptr2 != null) {
            int val1 = ptr1 == null ? 0 : ptr1.val;
            int val2 = ptr2 == null ? 0 : ptr2.val;
            int val3 = val1 + val2 + flag;
            flag = val3 >= 10 ? 1 : 0;

            if (head == null) {
                head = new ListNode(val3 % 10);
                tail = head;
            } else {
                tail.next = new ListNode(val3 % 10);
                tail = tail.next;
            }

            ptr1 = ptr1 == null ? null : ptr1.next;
            ptr2 = ptr2 == null ? null : ptr2.next;
        }

        if (flag == 1) {
            tail.next = new ListNode(1);
            tail = tail.next;
        }

        return head;
    }

    public int toInteger(ListNode head) {
        int result = 0, position = 0;
        ListNode curr = head;

        while (curr != null) {
            result += curr.val * Math.pow(10, position++);
            curr = curr.next;
        }

        return result;
    }

    public static void main(String[] args) {
        ListNode head1 = new ListNode(2);
        head1.next = new ListNode(4);
        head1.next.next = new ListNode(3);

        ListNode head2 = new ListNode(5);
        head2.next = new ListNode(6);
        head2.next.next = new ListNode(4);

        AddTwoNumbers myObj = new AddTwoNumbers();

        ListNode result = myObj.addTwoNumbers(head1, head2);

        System.out.println(myObj.toInteger(head1));
        System.out.println(myObj.toInteger(head2));
        System.out.println(myObj.toInteger(result));
    }
}


