package Tree.BST;

import Tree.BinaryTree.BinaryTree;

public class LC0450_DeleteInBST {

//    A 恰好是末端节点，两个子节点都为空，那么它可以当场去世了。
//    A 只有一个非空子节点，那么它要让这个孩子接替自己的位置。
//    A 有两个子节点，麻烦了，为了不破坏 BST 的性质，A 必须找到左子树中最大的那个节点，或者右子树中最小的那个节点来接替自己。
    public BinaryTree.TreeNode deleteNode(BinaryTree.TreeNode root, int key) {
        if (root == null)
            return null;
        if (root.val == key) {
            // 这两个 if 把情况 1 和 2 都正确处理了
            if(root.left == null) return root.right;
            if(root.right == null) return root.left;
            // 处理情况 3
            // 获得右子树最小的节点
            BinaryTree.TreeNode minNode = getMin(root.right);
            // 删除右子树最小的节点
            root.right = deleteNode(root.right, minNode.val);
            // 用右子树最小的节点替换 root 节点
            minNode.left = root.left;
            minNode.right = root.right;
            root = minNode;
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
            root.right = deleteNode(root.right, key);
        }
        return root;
    }

    BinaryTree.TreeNode getMin(BinaryTree.TreeNode node) {
        while (node.left != null) {// BST 最左边的就是最小的
            node = node.left;
        }
        return node;
    }

    public static void main(String[] args) {
        Integer[] arr = {5,3,6,2,4,null,7};
        BinaryTree tree = new BinaryTree(arr);
        LC0450_DeleteInBST sol = new LC0450_DeleteInBST();

        tree.levelOrderTraversalWithNull(sol.deleteNode(tree.root, 3));
    }
}
