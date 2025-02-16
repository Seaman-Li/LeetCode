package Tree.BinaryTree;


public class LC100_SameTree {
//    Preorder Traversal
//1. Process the current node
//2. Recursively traverse the left subtree
//3. Recursively traverse the right subtree

    public boolean isSameTree(BinaryTree.TreeNode p, BinaryTree.TreeNode q) {
        if (p == null && q == null) return true;
        if (p == null || q == null) return false;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        Integer[] arr1 = {1,2,3};
        BinaryTree tree1 = new BinaryTree(arr1);
        Integer[] arr2 = {1,2,3};
        BinaryTree tree2 = new BinaryTree(arr2);
        LC100_SameTree sol = new LC100_SameTree();
        System.out.println(sol.isSameTree(tree1.root,tree2.root));

    }


}
