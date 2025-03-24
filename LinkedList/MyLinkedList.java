package LinkedList;

public class MyLinkedList {

    private ListNode head;

    // Insert a new node at the head
    public void insert(int val){
        ListNode newNode = new ListNode(val);
        newNode.next = head;
        head = newNode;
    }

    // Delete the first node with the given value
    public void delete(int val){
        if(head == null){
            return;
        }
        if(head.val == val){
            head = head.next;
            return;
        }

        ListNode prev = head;
        ListNode curr = head.next;

        while(curr != null){
            if(curr.val == val){
                prev.next = curr.next;
                return;
            }
            prev = curr;
            curr = curr.next;
        }
    }

    // Search for a value in the list
    public boolean search(int val){
        ListNode curr = head;
        while(curr != null){
            if(curr.val == val){
                return true;
            }
            curr = curr.next;
        }
        return false;
    }

}
