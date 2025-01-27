package Tree.BST;

import Tree.BinaryTree.BinaryTree;

public class LC538_BSTtoGreaterTree {
    int sum = 0;// 记录累加和

    public BinaryTree.TreeNode convertBST(BinaryTree.TreeNode root) {
        traverse(root);
        return root;
    }

    void traverse(BinaryTree.TreeNode root) {
        if (root == null) return;
        traverse(root.right);
        sum += root.val; // 维护累加和
        root.val = sum;// 将 BST节点 转化成累加树节点
        traverse(root.left);
    }

    public static void main(String[] args) {
        LC538_BSTtoGreaterTree sol = new LC538_BSTtoGreaterTree();
        Integer[] arr = {4,1,6,0,2,5,7,null,null,null,3,null,null,null,8};
        BinaryTree tree = new BinaryTree(arr);
        sol.convertBST(tree.root);
        tree.levelOrderTraversalWithNull(tree.root);
    }

}
