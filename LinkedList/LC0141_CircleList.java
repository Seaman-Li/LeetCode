package LinkedList;

import java.util.HashSet;
import java.util.Set;

public class LC0141_CircleList {

    //快慢指针
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) return true;

        }
        return false;
    }

    //hash表法
    public static boolean hasCycleHash(ListNode head) {
        Set<ListNode> nodesSeen = new HashSet<>();
        while (head != null) {
            if (nodesSeen.contains(head)) {
                return true; // 发现环
            }
            nodesSeen.add(head);
            head = head.next;
        }
        return false; // 无环
    }


    //leetcode 142: 返回环的入口：当 slow 和 fast 相遇后，将其中一个指针（通常是 fast）重新指向链表的头部，但这次两个指针都以相同的速度（每次一步）移动。
    //当两个指针再次相遇时，它们相遇的节点就是环的起始节点。
    //    数学解释
    //假设：链表头部到环入口点的距离是 D。
    //环入口点到两指针首次相遇点的距离是 S。
    //环的长度是 C。
    //当 slow 和 fast 首次相遇时，slow 指针已经走了 D+S 的距离。
    //fast 指针由于速度是 slow 的两倍，所以它走的距离是 slow 指针的两倍，即 2(D+S)。因为 fast 指针可能已经在环里转了多圈，所以其行走的总距离可以表示为 D+S + nC，其中 n 是 fast 指针在环中转的圈数。
    //由此，我们可以得出以下等式：
    //2(𝐷+𝑆)=𝐷+𝑆+𝑛𝐶
    //简化后得到：
    //𝐷+𝑆=𝑛𝐶
    //这个等式表明，从链表头部到环入口点的距离 D，加上从环入口到首次相遇点的距离 S，等于环的长度 C 的整数倍。从这里，我们可以进一步推断出：
    //从首次相遇点再到达环入口点的距离是 C - S。
    //由于 D 等于 nC - S，这意味着从链表头部走到环入口的距离 D，和从首次相遇点走到环入口的距离（C - S）相同。
    public static ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        boolean hasCycle = false;

        // 第一步：使用快慢指针确定是否有环
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                hasCycle = true;
                break;
            }
        }

        // 如果有环，找到环的起始节点
        if (hasCycle) {
            fast = head;
            while (fast != slow) {
                fast = fast.next;
                slow = slow.next;
            }
            return slow;
        }

        return null; // 没有环
    }

    public static void main(String[] args) {
        // 创建链表节点
        ListNode node1 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(0);
        ListNode node4 = new ListNode(-4);

        // 构建有环的链表
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2; // 创建环：指向node2

        System.out.println(hasCycleHash(node1));
        System.out.println(detectCycle(node1).val);
    }
}
