package List;

public class LC0021_mergeTwoSortedLists {

// 遍历解法：   比较两个链表的头节点，将较小的节点添加到结果链表resultNode中，然后移动该链表的头指针。重复此过程，直到一个链表为空，最后将非空链表的剩余部分链接到结果链表的末尾。
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2){
        ListNode resultNode = new ListNode(0);
        ListNode tail = resultNode;

        while (list1 != null && list2 != null) {
            //结果链表的尾部tail指向较小的元素节点，然后移动对应的list指针
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            //更新尾部指针
            tail = tail.next;
        }

        if (list1 != null) {
            tail.next = list1;
        } else if (list2 != null) {
            tail.next = list2;
        }

        return resultNode.next;
    }

//    递归解法
    public static ListNode mergeTwoListsWithRecursive(ListNode list1, ListNode list2) {
        // 终止条件：如果任一链表为空，返回另一链表
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }

        // 选择较小的头节点，并递归处理剩余部分
        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }

    public static void main(String[] args) {
        // 创建链表 1 -> 2 -> 4
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(4)));

        // 创建链表 1 -> 3 -> 4
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        ListNode mergedList = mergeTwoListsWithRecursive(l1, l2);

        // 打印合并后的链表
        while (mergedList != null) {
            System.out.print(mergedList.val + " ");
            mergedList = mergedList.next;
        }
    }


}
