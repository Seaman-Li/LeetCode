package List;

public class LC082_removeDuplicatesII {

    public ListNode deleteDuplicates(ListNode head) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;// 指向最后一个未重复的节点
        ListNode cur = head;// 当前遍历的节点
        while (cur.next != null) {
            // 检查是否有重复
            boolean isDuplicated = false;
            while(cur.val == cur.next.val) {
                cur = cur.next;// 跳过重复节点
                isDuplicated = true;
            }
            //在当前节点值和next节点值不一致时，此时若isDuplicated为true表示存在重复区间，删除这个区间
            if(isDuplicated){
                // 删除整个重复区间
                prev.next = cur.next;
            }else {
                // 当前节点没有重复，prev 向前移动
                prev = prev.next;
            }
            cur = cur.next;
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(1, new ListNode(1, new ListNode(2, new ListNode(3)))));
        LC082_removeDuplicatesII solution = new LC082_removeDuplicatesII();
        ListNode head = solution.deleteDuplicates(l1);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

}
