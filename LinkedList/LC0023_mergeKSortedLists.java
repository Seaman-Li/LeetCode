package LinkedList;

import java.util.PriorityQueue;

import static LinkedList.ListNode.printList;

public class LC0023_mergeKSortedLists {

//    合并 k 个有序链表的逻辑类似合并两个有序链表，难点在于，如何快速得到 k 个节点中的最小节点，接到结果链表上？
//    这里我们就要用到优先级队列这种数据结构，把链表节点放入一个最小堆，就可以每次获得 k 个节点中的最小节点。
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;

        ListNode dummy = new ListNode(-1);// 虚拟头结点
        ListNode tail = dummy;

        //(a, b) -> a.val - b.val：比较两个 ListNode 的值，按 升序排序。即 val 小的 ListNode 先出队。
        PriorityQueue<ListNode> pq = new PriorityQueue<>(// 优先级队列，最小堆
                lists.length, (a, b) -> a.val - b.val
        );
        // 将 k 个链表的头结点加入最小堆
        for(ListNode head : lists){
            if(head != null){
                pq.add(head);
            }
        }
        while(!pq.isEmpty()){
            ListNode minNode = pq.poll();// 取出当前最小节点
            tail.next = minNode;
            if(minNode.next != null){
                pq.add(minNode.next);// 推入下一个节点
            }
            tail = tail.next;
        }
        return dummy.next;
    }

    //直接将所有节点一次性加入 PriorityQueue，然后逐个弹出,更直观
    //PriorityQueue 需要存储所有 N 个节点，而方法 1 只存储 最多 k 个 节点（K 是链表个数）。排序成本更高：
    public ListNode mergeKLists2(ListNode[] lists) {
        if (lists.length == 0) return null;
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        // 仅存入值，而不存入原 ListNode 的引用
        for (ListNode list : lists) {
            while (list != null) {
                pq.add(new ListNode(list.val)); // 创建新节点
                list = list.next;
            }
        }

        while(!pq.isEmpty()){
            tail.next = pq.poll();
            tail = tail.next;
        }
        return dummy.next;
    }

    public ListNode mergeKLists3(ListNode[] lists) {
        return  merge(lists, 0, lists.length - 1);
    }

    public static ListNode merge(ListNode[] lists, int start, int end) {

        if(start == end)
            return lists[start];
        int mid = start + (end - start) / 2;
        ListNode l1 = merge(lists, start, mid);
        ListNode l2 = merge(lists, mid + 1, end);
        return mergeProcess(l1, l2);
    }

    public static ListNode mergeProcess(ListNode l1, ListNode l2) {

        ListNode temp = new ListNode(0);
        ListNode tail = temp;
        while(l1 != null && l2 != null) {
            if(l1.val < l2.val) {
                tail.next = l1;
                l1 = l1.next;
            }else{
                tail.next = l2;
                l2 = l2.next;
            }
            tail = tail.next;
        }
        tail.next = l1 == null ? l2 : l1;
        return temp.next;
    }


    public static void main(String[] args) {
        LC0023_mergeKSortedLists sol = new LC0023_mergeKSortedLists();
        ListNode l1 = new ListNode(1, new ListNode(4, new ListNode(5)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
        ListNode l3 = new ListNode(2, new ListNode(6));
        ListNode[] lists = new ListNode[]{l1, l2, l3};
        ListNode result = sol.mergeKLists2(lists);
        printList(result);
    }

}
