package List;

    public class ListNode {
        int val;          // 节点值
        ListNode next;    // 指向下一个节点的指针

        ListNode() {}     // 空构造函数

        ListNode(int val) {
            this.val = val;
        } // 构造函数初始化节点值

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        } // 构造函数初始化节点值和下一个节点
    }

