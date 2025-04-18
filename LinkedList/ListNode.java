package LinkedList;

    public class ListNode {
        int val;          // 节点值
        ListNode next;    // 指向下一个节点的指针

        ListNode() {}     // 空构造函数

        ListNode(int val) {
            this.val = val;
        } // 构造函数初始化节点值

        ListNode(int val, ListNode next) {// 构造函数初始化节点值和下一个节点
            this.val = val;
            this.next = next;
        }

        public static void printList(ListNode head){
            while(head != null){
                System.out.print(head.val + "->");
                head = head.next;
            }
            System.out.println("null");
        }
    }


