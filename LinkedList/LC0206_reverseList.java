package LinkedList;

public class LC0206_reverseList {

//    迭代法
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;  // 保存下一个节点
            curr.next = prev;               // 反转当前节点的指针
            prev = curr;                    // 移动prev和curr
            curr = nextTemp;
        }
        return prev;  // 新的头节点
    }

//    递归法
    public static ListNode reverseListRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;  // 基本情况：链表为空或只有一个节点
        }
        ListNode newHead = reverseListRecursive(head.next);  // 递归反转剩余链表
        head.next.next = head;  // 修改head.next的指针
        head.next = null;       // 防止链表循环
        return newHead;         // 返回新的头节点
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode result =  reverseList(l1);
        while(result != null) {
            System.out.print(result.val + " ");
            result = result.next;
        }

    }
}
