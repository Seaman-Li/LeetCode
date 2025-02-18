package Tree.BST;

import Tree.BinaryTree.BinaryTree;


//Inorder traversal (Left → Root → Right) sorts BST nodes in ascending order.
//The minimum absolute difference must be between two adjacent nodes in the inorder traversal.
public class LC530_MinAbsDifference {
    private int minDiff = Integer.MAX_VALUE;
    private Integer prev = null;// Track previous node in inorder sequence

    public int getMinimumDifference(BinaryTree.TreeNode root) {
        inorder(root);
        return minDiff;
    }
    private void inorder(BinaryTree.TreeNode node) {
        if (node == null) return;

        inorder(node.left);// Visit left subtree

        // Compare with previous node
        if (prev != null)
            minDiff = Math.min(minDiff, Math.abs(prev - node.val));
        prev = node.val;// Update previous node value

        inorder(node.right);// Visit right subtree
    }


    public static void main(String[] args) {
        Integer[] arr = {1,0,48,null,null,12,49};
        BinaryTree bt = new BinaryTree(arr);
        LC530_MinAbsDifference sol = new LC530_MinAbsDifference();
        System.out.println(sol.getMinimumDifference(bt.root));
    }
}
