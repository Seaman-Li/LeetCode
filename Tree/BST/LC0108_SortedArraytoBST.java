package Tree.BST;

import Tree.BinaryTree.BinaryTree;

public class LC0108_SortedArraytoBST {
    public BinaryTree.TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums, 0, nums.length - 1);
    }

    BinaryTree.TreeNode buildBST(int[] nums, int left, int right) {
        if (left > right) // Base case: empty range
            return null;
        int mid = left + (right - left) / 2;// Find the middle index
        BinaryTree.TreeNode root = new BinaryTree.TreeNode(nums[mid]);// Create root node
        // Recursively build left and right subtrees
        root.left = buildBST(nums, left, mid - 1);
        root.right = buildBST(nums, mid + 1, right);
        return root;

    }


    public static void main(String[] args) {
        LC0108_SortedArraytoBST sol = new LC0108_SortedArraytoBST();
        int[] nums = new int[]{-10,-3,0,5,9};


        BinaryTree BST = new BinaryTree(sol.sortedArrayToBST(nums)) ;

        BST.levelOrderTraversalWithNull(BST.root);

    }
}
