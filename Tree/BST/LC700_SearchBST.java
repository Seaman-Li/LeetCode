package Tree.BST;

import Tree.BinaryTree.BinaryTree;

public class LC700_SearchBST {
//    在一棵普通的二叉树中寻找
    BinaryTree.TreeNode searchBST(BinaryTree.TreeNode root, int target) {
        if(root == null)
            return null;
        if(root.val == target)
            return root;
        BinaryTree.TreeNode left = searchBST(root.left, target);
        BinaryTree.TreeNode right = searchBST(root.right, target);

        return left != null ? left : right;
    }

//    二分查找思想，根据 target 和 root.val 的大小比较，就能排除一边。
    BinaryTree.TreeNode searchBST2(BinaryTree.TreeNode root, int target) {
        if(root == null)
            return null;
        if(root.val > target)// 去左子树搜索
            return searchBST2(root.left, target);
        if(root.val < target)// 去右子树搜索
            return searchBST2(root.right, target);
        // 当前节点就是目标值
        return root;
    }


    public static void main(String[] args) {
        Integer[] arr = {4,2,7,1,3};
        BinaryTree tree = new BinaryTree(arr);
        LC700_SearchBST bst = new LC700_SearchBST();
        System.out.println(bst.searchBST(tree.root, 2).val);
    }
}
