package Tree.BinaryTree;


import java.util.LinkedList;
import java.util.Queue;

public class LC0101_SymmetricTree {

    public static boolean isSymmetricRecursive(BinaryTree.TreeNode root) {
        if(root == null) return true;

        return deepCheckRecursive(root.left, root.right);
    }

//    递归法
    public static boolean deepCheckRecursive(BinaryTree.TreeNode left, BinaryTree.TreeNode right) {
        if(left == null && right == null) return true;
        if(left == null || right == null) return false;
        if(left.val != right.val) return false;
        return deepCheckRecursive(left.left, right.right) && deepCheckRecursive(left.right, right.left);
    }

    //用队列
    public static boolean isSymmetricQueue(BinaryTree.TreeNode root) {

        if(root == null) return true;

        Queue<BinaryTree.TreeNode> queue = new LinkedList<BinaryTree.TreeNode>();
        BinaryTree.TreeNode leftNode = root.left;
        BinaryTree.TreeNode rightNode = root.right;

        queue.offer(leftNode);
        queue.offer(rightNode);

        while(!queue.isEmpty()) {
            leftNode = queue.poll();
            rightNode = queue.poll();
            if(leftNode == null && rightNode == null) continue;
            if(leftNode == null || rightNode == null) return false;
            if(leftNode.val != rightNode.val) return false;

            queue.offer(leftNode.left);
            queue.offer(rightNode.right);
            queue.offer(leftNode.right);
            queue.offer(rightNode.left);
        }
        return true;
    }


    public static void main(String[] args) {
        Integer[] values = {1, 2, 2, 3, 4, 4, 3, null, null, null, 5, 5, null, null, null};
        BinaryTree tree = new BinaryTree(values);
        System.out.println(isSymmetricQueue(tree.root));
    }

}
