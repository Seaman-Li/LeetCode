package Tree.BST;

import Tree.BinaryTree.BinaryTree;

public class LC701_InsertToBST {

    public BinaryTree.TreeNode insertIntoBST(BinaryTree.TreeNode root, int val) {
        if(root == null)
            return new BinaryTree.TreeNode(val); // 找到空位置插入新节点
        if(root.val < val) // 去右子树找插入位置
            root.right = insertIntoBST(root.right, val);
        if(root.val > val)// 去左子树找插入位置
            root.left = insertIntoBST(root.left, val);
        return root;// 返回 root，上层递归会接收返回值作为子节点
    };

    public static void main(String[] args) {
        LC701_InsertToBST sol = new LC701_InsertToBST();
        Integer[] arr = {4,2,7,1,3};
        BinaryTree tree = new BinaryTree(arr);
        tree.levelOrderTraversalWithNull(sol.insertIntoBST(tree.root, 5) );
    }

}
