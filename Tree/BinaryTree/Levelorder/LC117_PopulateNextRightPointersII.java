package Tree.BinaryTree.Levelorder;


import java.util.LinkedList;
import java.util.Queue;

public class LC117_PopulateNextRightPointersII {
    // Definition for a Node.
    public static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;

        public Node() {}

        public Node(int _val) {
            val = _val;
        }

        public Node(int _val, Node _left, Node _right, Node _next) {
            val = _val;
            left = _left;
            right = _right;
            next = _next;
        }
    };

    //Universal solution levelOrder Traverse
    public Node connect(Node root) {
        if (root == null)
            return null;
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node cur = queue.poll();
                if(cur != null && i < size - 1){
                    cur.next = queue.peek();
                }

                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
        }
        return root;
    }

    //Space O(1)
    //Instead of using a queue, use the .next pointers to traverse level by level.
    //Use a dummy node (dummy) to track the next level's start.
    public Node connect1(Node root) {
        if (root == null) return null;

        Node head = root; // Start at the root

        while (head != null) {
            Node dummy = new Node(0); // Dummy node for the next level
            Node temp = dummy; // Pointer to track the connection

            while (head != null) {
                if (head.left != null) {
                    temp.next = head.left;
                    temp = temp.next;
                }
                if (head.right != null) {
                    temp.next = head.right;
                    temp = temp.next;
                }
                head = head.next; // Move to next node in the current level
            }

            head = dummy.next; // Move to the next level
        }

        return root;
    }

    //通过next打印每一层的节点来验证算法
    public void printNext(Node root) {
        if (root == null) return;
        Node leftmost = root; // 从根节点开始
        while (leftmost != null) {
            Node head = leftmost;
            while (head != null) {
                System.out.print(head.val + " ");
                head = head.next;
            }
            // 移动到下一层的最左侧节点
            leftmost = leftmost.left;
            System.out.println("\n");
        }
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        LC117_PopulateNextRightPointersII solution = new LC117_PopulateNextRightPointersII();
        solution.connect(root);
        solution.printNext(root);
    }
}
