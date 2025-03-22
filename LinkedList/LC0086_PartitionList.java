package LinkedList;

import static LinkedList.ListNode.printList;

//Given the head of a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
//You should preserve the original relative order of the nodes in each of the two partitions.
//Input: head = [1,4,3,2,5,2], x = 3
//Output: [1,2,2,4,3,5]
public class LC0086_PartitionList {

//    We create two dummy lists:
//    One for nodes < x
//    One for nodes ≥ x
//    Then we merge them at the end.
    public ListNode partition(ListNode head, int x) {
        ListNode beforeX = new ListNode(0);
        ListNode afterX = new ListNode(0);

        ListNode before = beforeX;
        ListNode after = afterX;

        while (head != null) {
            if (head.val < x) {
                before.next = head;
                before = before.next;
            }else{
                after.next = head;
                after = after.next;
            }
            head = head.next;
        }

        after.next = null;
        before.next = afterX.next;

        return beforeX.next;

    }

    public static void main(String[] args) {
        LC0086_PartitionList sol = new LC0086_PartitionList();
        ListNode head = new ListNode(1, new ListNode(4, new ListNode(3, new ListNode(2, new ListNode(5, new ListNode(2))))));
        ListNode res = sol.partition(head, 3);
        printList(res);
    }

}
