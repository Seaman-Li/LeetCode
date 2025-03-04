package LinkedList;

import java.util.Stack;

public class LC0234_PalindromeList {
    //迭代法
    public static boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null)
            return true;
        ListNode slow = head, fast = head;
        // 找到链表的中点（慢指针停的位置）
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // 如果链表长度是奇数(此时中间元素不影响回文)，移动慢指针一步，跳过中间元素
        if(fast!=null)
            slow = slow.next;
        // 反转链表的后半部分
        slow = LC0206_reverseList.reverseList(slow);
        fast = head;
        // 比较前半部分和反转后的后半部分
        while(slow != null){
            if(slow.val != fast.val) return false;
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }

    //用栈的方法
    public static boolean isPalindromeStack(ListNode head) {
        if(head == null || head.next == null)
            return true;
        Stack<Integer> stack = new Stack<>();
        ListNode slow = head, fast = head;

        // 将前半部分节点的值入栈
        while (fast != null && fast.next != null) {
            stack.push(slow.val);
            slow = slow.next;
            fast = fast.next.next;
        }
        // 如果链表长度为奇数，跳过中间节点
        if (fast != null) {
            slow = slow.next;
        }
        while (slow != null) {
            int top = stack.pop();
            if (top != slow.val) return false;
            slow = slow.next;
        }
        return true;
    }

    //判断是否回文以及返回回文的部分
    public static ListNode palindromeSubList(ListNode head) {
        if (head == null || head.next == null) return head;

        if (!isPalindrome(head)) return null; // 先检查是否是回文

        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;

        // 找到中点或中点的前一个节点
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }

        // 如果链表长度为奇数，中点是单独的节点
        if (fast != null) {
            prev = slow;
        }

        // 断开链表，返回前半部分
        if (prev != null) prev.next = null;
        return head;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(2, new ListNode(1))));
        System.out.println(isPalindromeStack(l1));

        ListNode Palindrome = palindromeSubList(l1);
        while(Palindrome != null){
            System.out.print(Palindrome.val);
            Palindrome = Palindrome.next;
        }
    }
}
