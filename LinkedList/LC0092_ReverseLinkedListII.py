# Definition for singly-linked list.
from typing import Optional


class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def reverseBetween(self, head: Optional[ListNode], left: int, right: int) -> Optional[ListNode]:
        nodes = []
        cur = head
        # store all nodes
        while cur:
            nodes.append(cur)
            cur = cur.next
        # Because Python list index starts from 0, but LeetCode position starts from 1
        left_index = left - 1
        right_index = right - 1
        # Then reverse this part:
        nodes[left_index:right_index + 1] = reversed(nodes[left_index:right_index + 1])
        for i in range(len(nodes) - 1):
            nodes[i].next = nodes[i + 1]
        # 把最终链表的最后一个节点指向 None，防止形成 cycle
        nodes[-1].next = None
        return nodes[0]

    def reverseBetween2(
            self,
            head: Optional[ListNode],
            left: int,
            right: int
        ) -> Optional[ListNode]:

            if not head or left == right:
                return head

            dummy = ListNode(0)
            dummy.next = head

            pre = dummy

            for _ in range(left - 1):
                pre = pre.next

            cur = pre.next

            for _ in range(right - left):
                # Every iteration removes cur.next and inserts it immediately after pre.
                temp = cur.next  # choose the node to move
                cur.next = temp.next  # remove it from the old position
                temp.next = pre.next  # connect it before the reversed part
                pre.next = temp  # insert it after pre

            return dummy.next