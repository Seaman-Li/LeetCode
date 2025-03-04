package LinkedList;

public class LC0083_removeDuplicates {

//    由于本题链表是顺序排列的所以只需要挨个和后面一个元素比较
    public static ListNode removeDuplicates(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode currentNode = head;
        while(currentNode.next != null){
            if(currentNode.val == currentNode.next.val){
                currentNode.next = currentNode.next.next;
            }else{
                currentNode = currentNode.next;
            }
        }
        return head;
    }

    public static ListNode removeDuplicatesRecursive(ListNode head) {
        if(head == null || head.next == null) return head;
        head.next = removeDuplicatesRecursive(head.next);
        return head.val == head.next.val ? head.next : head;

    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(1, new ListNode(2)));
        ListNode l2 = removeDuplicatesRecursive(l1);
        while(l2 != null){
            System.out.println(l2.val);
            l2 = l2.next;
        }
    }

}
