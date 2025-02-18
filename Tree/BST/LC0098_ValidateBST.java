package Tree.BST;


import Tree.BinaryTree.BinaryTree;

public class LC0098_ValidateBST {
    public boolean isValidBST(BinaryTree.TreeNode root) {
        return _isValidBST(root, null, null);
    }
    // 定义：该函数返回 root 为根的子树的所有节点是否满足 max.val > root.val > min.val
    public boolean _isValidBST(BinaryTree.TreeNode root, BinaryTree.TreeNode min, BinaryTree.TreeNode max) {
        // base case
        if (root == null)
            return true;
        // 若 root.val 不符合 max 和 min 的限制，说明不是合法 BST
        if (min != null && root.val <= min.val)
            return false;
        if (max != null && root.val >= max.val)
            return false;
        // 根据定义，限定左子树的最大值是 root.val，右子树的最小值是 root.val
        return _isValidBST(root.left, min, root) && _isValidBST(root.right, root, max);
    }

    public static void main(String[] args) {
        LC0098_ValidateBST bst = new LC0098_ValidateBST();
        Integer[] arr = new Integer[]{2,1,3};
        BinaryTree tree = new BinaryTree(arr);
        System.out.println(bst.isValidBST(tree.root));
    }
}
