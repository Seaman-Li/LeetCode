# Definition for singly-linked list.
from typing import Optional

# 每次处理一组节点，主要做四件事：
#
# 找到当前组的第一个节点 left
# 找到当前组的第 k 个节点 right
# 判断这一组是否真的有 k 个节点
# 反转 [left, right]，然后连接前后部分
#
# 可以把链表分成三部分：
#
# 前面已经处理好的部分 | 当前要反转的组 | 后面还没处理的部分

class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next
class Solution:
    def reverse_segment(
            self,
            left: ListNode,
            group_next: Optional[ListNode]
    ) -> ListNode:
        """
        “反转半开区间”模板 反转区间：[left, stop)
        """
        # 在每轮的第一次循环中，prev还起到原来的 left 会变成新组尾（将初始left.next = group_next）的作用
        prev = group_next
        current = left

        while current != group_next:
            next_node = current.next
            current.next = prev
            prev = current
            current = next_node

        return prev

    def reverseKGroup(
            self,
            head: Optional[ListNode],
            k: int
    ) -> Optional[ListNode]:

        dummy = ListNode(0, head)
        group_prev = dummy # 当前组前面的节点

        while True:
            right = group_prev # 当前组第 k 个节点

            # find right boundary
            for _ in range(k):
                right = right.next
                if right is None:
                    # 剩余的节点不足k了，返回头节点
                    return dummy.next

            left = group_prev.next # 当前组第一个节点
            group_next = right.next # 当前组后面的第一个节点

            new_group_head = self.reverse_segment(left, group_next)

            group_prev.next = new_group_head

            # old left is now the tail
            group_prev = left
