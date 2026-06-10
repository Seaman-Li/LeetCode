# Definition for singly-linked list.
from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def addTwoNumbers(self, l1: Optional[ListNode], l2: Optional[ListNode]) -> Optional[ListNode]:
        carry = 0  #进位
        head = ListNode()
        current = head

        p1 = l1
        p2 = l2
        # 考虑到l1或l2遍历完还有进位的情况所以carry要加入循环条件
        while p1 or p2 or carry:
            val1 = p1.val if p1 else 0
            val2 = p2.val if p2 else 0

            sum = val1 + val2 + carry
            carry = sum // 10  # The carry is the quotient when the sum is divided by 10.
            currentVal = sum % 10  # The current digit is the remainder when the sum is divided by 10.

            current.next = ListNode(currentVal)
            current = current.next

            if(p1):
                p1 = p1.next
            if(p2):
                p2 = p2.next


        return head.next

def main():
    l1 = ListNode(2, ListNode(4, ListNode(3)))
    l2 = ListNode(5, ListNode(6, ListNode(4)))
    solution = Solution()
    result = solution.addTwoNumbers(l1, l2)

    while result:
        print(result.val)
        result = result.next

if __name__ == '__main__':
    main()