package List;

public class LC0019_removeNthNodefromEnd {

    //在长度为t的链表中找倒数第n个节点，可转化为找整数第t-n+1个节点
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || n <= 0) return null;
        ListNode temp = new ListNode(0); // 添加一个哑节点，方便处理边界情况，如删除头节点
        temp.next = head;
        ListNode fast = temp;
        ListNode slow = temp;

        // fast 指针先移动 N+1 步，使其与 slow 指针之间有 n 个节点
        for (int i = 1; i <= n+1; i++) {
            fast = fast.next;
        }

        // 移动 fast 到链表末尾，同时移动 slow
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        // fast移动了t+1步，slow移动了t-n步
        // 此时 slow.next就是倒数第n个节点(即正数第t-n+1个节点)，现在删除 slow 的下一个节点
        slow.next = slow.next.next;

        return temp.next; // 返回哑节点的下一个节点，即链表的新头节点

    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        int n = 1;
        ListNode res = removeNthFromEnd(l1, n);
        while (res != null) {
            System.out.println(res.val);
            res = res.next;
        }
    }
}
