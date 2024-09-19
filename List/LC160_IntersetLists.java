package List;

import java.util.HashSet;
import java.util.Set;

public class LC160_IntersetLists {

//    当一个指针（比如指向链表A的指针pA）到达链表A的末尾时，将其移至链表B的头部继续遍历，反之亦然。这样，每个指针都将遍历长度为 A长度 + B长度 的路径。
//    相遇：如果两个链表相交，那么两个指针最终将在交点相遇，因为他们遍历的总长度相同，且交点之前的路径长度也相同。
//    不相遇：如果两个链表不相交，那么两个指针最终会同时到达各自的末尾（null），因为他们各自都遍历了完整的两个链表。
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) return null;

        ListNode pA = headA, pB = headB;

        while (pA != pB) {
            // 如果达到末尾，则移动到另一个链表的头部
            pA = (pA == null) ? headB : pA.next;
            pB = (pB == null) ? headA : pB.next;
        }

        // 相遇点即为相交节点，或者两个都为null说明不相交
        return pA;
    }

//    使用一个哈希表来存储链表 A 的所有节点，然后遍历链表 B 并检查每个节点是否已经在哈希表中。第一个出现在哈希表中的节点即为相交的起始节点。
    public static ListNode getIntersectionNodeHash(ListNode headA, ListNode headB) {
        Set<ListNode> visited = new HashSet<>();

        ListNode node = headA;
        while (node != null) {
            visited.add(node);
            node = node.next;
        }

        node = headB;
        while (node != null) {
            if (visited.contains(node)) {
                return node;
            }
            node = node.next;
        }

        return null;
    }

    public static void main(String[] args) {
        // 创建链表A: 4 -> 1
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);

        // 创建链表B: 5 -> 0 -> 1
        ListNode headB = new ListNode(5);
        headB.next = new ListNode(0);
        headB.next.next = new ListNode(1);

        // 创建交点后的链表部分: 8 -> 4 -> 5
        ListNode intersect = new ListNode(8);
        intersect.next = new ListNode(4);
        intersect.next.next = new ListNode(5);

        // 将交点接入两个链表
        headA.next.next = intersect;
        headB.next.next.next = intersect;

        System.out.println(getIntersectionNode(headA, headB).val);
    }
}
