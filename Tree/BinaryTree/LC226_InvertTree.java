package Tree.BinaryTree;

import java.util.Queue;
import java.util.LinkedList;

public class LC226_InvertTree {

    public static BinaryTree.TreeNode invertTree2(BinaryTree.TreeNode root) {
        // 遍历二叉树，交换每个节点的子节点
        traverse(root);
        return root;
    }

    // 二叉树遍历函数
    static void traverse(BinaryTree.TreeNode root) {
        if (root == null) {
            return;
        }
        // *** 前序位置 ***
        // 每一个节点需要做的事就是交换它的左右子节点
        BinaryTree.TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        // 遍历框架，去遍历左右子树的节点
        traverse(root.left);
        traverse(root.right);
    }

//    递归法的思想是自顶向下的，但是实际执行过程是自底向上的：实际是先交换最下层的左右节点再向上。而迭代法的执行过程是自顶向下的：先交换上层的左右节点在交换下层的。
    //自顶向下交换每个节点的左右子节点，属于后续遍历
    public static BinaryTree.TreeNode invertTree(BinaryTree.TreeNode root) {
        if (root == null) return null;
        BinaryTree.TreeNode left = invertTree(root.left);
        BinaryTree.TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;
        return root;
    }

    //使用队列实现广度优先搜索（BFS）翻转二叉树
    public static BinaryTree.TreeNode invertTreeIteration(BinaryTree.TreeNode root) {
        if (root == null) return null;

        Queue<BinaryTree.TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            BinaryTree.TreeNode node = queue.poll();
            BinaryTree.TreeNode temp = node.left;
            node.left = node.right;
            node.right = temp;

            if (node.left != null) queue.add(node.left);
            if (node.right != null) queue.add(node.right);
        }
        return root;
    }

    public static void main(String[] args) {
        Integer[] values = {3, 5, 1, 6, 2, 0, 8, null, null, 7, 4};
        BinaryTree tree = new BinaryTree(values);
        invertTreeIteration(tree.root);

        tree.levelOrderTraversal(tree.root);
    }
}
