from typing import Optional, List


# Definition for a Node.
class Node:
    def __init__(self, x: int, next: 'Node' = None, random: 'Node' = None):
        self.val = int(x)
        self.next = next
        self.random = random

def build_list(data: List[List[Optional[int]]]) -> Optional[Node]:
    if not data:
        return None

    # Step 1: create all nodes
    # same: nodes = [Node(val) for val, random_index in data]
    nodes = []
    for val, random_index in data:
        nodes.append(Node(val))

    # Step 2: connect next pointers
    for i in range(len(nodes) - 1):
        nodes[i].next = nodes[i + 1]

    # Step 3: connect random pointers
    for i, (val, random_index) in enumerate(data):
        if random_index is not None:
            nodes[i].random = nodes[random_index]

    return nodes[0]



class Solution:
    # although old_to_new[current] and old_to_new.get(current) returns the same when current exists as a key
    # we can't use old_to_new.get(current) = Node(current.val)
    # Because the left side of = must be something assignable, like:
    # variable = value
    # dict[key] = value
    # object.field = value
    # The difference is when the key does not exist.
    # old_to_new[current] will raise an error:KeyError
    # But:old_to_new.get(current) returns:None

    # old_to_new = {
    #     old_node_7: new_node_7,
    #     old_node_13: new_node_13,
    #     old_node_11: new_node_11,
    #     old_node_10: new_node_10,
    #     old_node_1: new_node_1,
    # }
    def copyRandomList(self, head: 'Optional[Node]') -> 'Optional[Node]':
        if head is None:
            return None

        old_to_new = dict()
        # build old_to_new dict
        current = head
        while current:
            old_to_new[current] = Node(current.val)  # create dict: key = current, value = Node(current.val)
            current = current.next
        # connect copied nodes
        current = head
        while current:
            # eg: current = old_node_7, old_to_new.get(current.next) means new_node_13, old_to_new[current] means new_node_7
            old_to_new[current].next = old_to_new.get(current.next)
            # eg: current = old_node_13, old_to_new.get(current.random) means new_node_7
            old_to_new[current].random = old_to_new.get(current.random)
            current = current.next
        return old_to_new[head]

def main():
    data = [[7,None],[13,0],[11,4],[10,2],[1,0]]
    head = build_list(data)
    solution = Solution()
    result = solution.copyRandomList(head)
    while result:
        print(result.val)
        result = result.next

if __name__ == '__main__':
    main()

