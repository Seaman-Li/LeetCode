package LinkedList;

import static LinkedList.ListNode.printList;
//Given the head of a linked list, rotate the list to the right by k places.
//Input: head = [1,2,3,4,5], k = 2
//Output: [4,5,1,2,3]
//Input: head = [0,1,2], k = 4
//Output: [2,0,1]
public class LC0061_RotateList {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head; // Edge cases
        int length = linkedListLength(head);

        k = k % length; // Handle k > length case

        if (k == 0) return head; // If k is a multiple of length, no rotation needed

        // Find the new tail (at position `length - k - 1`)
        ListNode temp = head;
        for (int i = 0; i < length - k - 1; i++) {
            temp = temp.next;
        }

        // `newHead` is the node after new tail
        ListNode newHead = temp.next;
        ListNode tempTail = newHead;

        // Break the list
        temp.next = null;

        // Move tempTail to the last node
        while (tempTail.next != null) {
            tempTail = tempTail.next;
        }

        // Connect old tail to old head
        tempTail.next = head;

        return newHead;
    }

    public static int linkedListLength(ListNode head) {
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1 ,new ListNode(2 ,new ListNode(3 ,new ListNode(4 ,new ListNode(5)))));
        LC0061_RotateList sol = new LC0061_RotateList();
        ListNode newhead = sol.rotateRight(head, 2);
        printList(newhead);
    }

}
