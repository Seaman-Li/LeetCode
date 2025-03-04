package LinkedList;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static LinkedList.ListNode.*;

public class LC0148_SortList {
    public ListNode sortList2(ListNode head) {
        if (head == null || head.next == null) return head;

        List<ListNode> list = new ArrayList<>();
        ListNode curr = head;

        // Convert Linked List to ArrayList
        while (curr != null) {
            list.add(curr);
            curr = curr.next;
        }

        // Sort ArrayList based on values
        Collections.sort(list, Comparator.comparingInt(a -> a.val));

        // Reconstruct the sorted linked list
        for (int i = 0; i < list.size() - 1; i++) {
            list.get(i).next = list.get(i + 1);
        }
        list.get(list.size() - 1).next = null; // Last node points to null

        return list.get(0);

    }

//  mergeSort of LinkedList
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;
// Step 1: Find the middle of the linked list
        ListNode mid = getMiddle(head);
        ListNode nextOfMid = mid.next;
        mid.next = null;
// Step 2: Recursively sort both halves
        ListNode left = sortList(head);
        ListNode right = sortList(nextOfMid);
// Step 3: Merge two sorted halves
        return merge(left, right);
    }

    // Function to find the middle using Slow and Fast pointer
    public ListNode getMiddle(ListNode head) {
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    // Merge two sorted linked lists (like in Merge Sort)
    private ListNode merge(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            }else{
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }

        tail.next = l1 == null ? l2 : l1;
        return dummy.next;
    }



    public static void main(String[] args) {
        LC0148_SortList sol = new LC0148_SortList();
        ListNode head = new ListNode(4);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(3);

        System.out.println("Before Sorting:");
        printList(head);

        head = sol.sortList(head);

        System.out.println("After Sorting:");
        printList(head);

    }
}
