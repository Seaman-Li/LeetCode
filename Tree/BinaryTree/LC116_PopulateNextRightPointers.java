package Tree.BinaryTree;

class Node {
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

class solution {

//    使用层次遍历，从上到下遍历树的每一层。
//    在每层中，通过遍历当前节点来设置每个节点的 next 指针。
    public Node connect0(Node root) {
        if (root == null) {
            return null;
        }

        Node leftmost = root; // 从根节点开始

        while (leftmost.left != null) { // 遍历每一层
            Node head = leftmost;
            while (head != null) {//遍历一层的每个节点
                // 设置左子节点的 next 指针
                head.left.next = head.right;
                // 设置右子节点的 next 指针（如果存在）
                if (head.next != null) {
                    head.right.next = head.next.left;
                }
                // 移动到本层的下一个节点
                head = head.next;
            }
            // 移动到下一层的最左侧节点
            leftmost = leftmost.left;
        }
        return root;
    }


//https://labuladong.online/algo/data-structure/binary-tree-part1/#%E7%AC%AC%E4%BA%8C%E9%A2%98%E3%80%81%E5%A1%AB%E5%85%85%E8%8A%82%E7%82%B9%E7%9A%84%E5%8F%B3%E4%BE%A7%E6%8C%87%E9%92%88
//    充分利用完美二叉树的性质，每个节点的左右子节点都存在。
//    每个节点的左子节点的 next 应该指向其右子节点。
//    每个节点的右子节点的 next 应该指向其父节点的 next 的左子节点（如果存在）。

    // 主函数
    public Node connect(Node root) {
        if (root == null) return null;
        // 遍历「三叉树」，连接相邻节点
        traverse(root.left, root.right);
        return root;
    }

    // 三叉树遍历框架
    void traverse(Node node1, Node node2) {
        if(node1 == null || node2 == null){
            return;
        }
        // *** 前序位置 ***
        // 将传入的两个节点穿起来
        node1.next = node2;
        // 连接相同父节点的两个子节点
        traverse(node1.left, node1.right);
        traverse(node2.left, node2.right);
        // 连接跨越父节点的两个子节点
        traverse(node1.right, node2.left);
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
        solution sol = new solution();
        Node root = new Node(1);
        root.left = new Node(2);
        root.right = new Node(3);
        root.left.left = new Node(4);
        root.left.right = new Node(5);
        root.right.left = new Node(6);
        root.right.right = new Node(7);

        System.out.println(sol.connect(root));
        sol.printNext(root);
    }
}

