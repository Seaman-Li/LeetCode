package Tree.BinaryTree;

public class LC114_BianryTreeToLinkedList {
    // 定义：将以 root 为根的树拉平为链表
    // 用后序的方式，把左子树先拉到右边变成链表，在把这段子树接在右边
    public void flatten(BinaryTree.TreeNode root) {

        if (root == null) return;

        // 利用定义，把左右子树拉平
        flatten(root.left);
        flatten(root.right);

        // *** 后序遍历位置 ***
        // 1、左右子树已经被拉平成一条链表
        BinaryTree.TreeNode left = root.left;
        BinaryTree.TreeNode right = root.right;
        // 2、将左子树作为右子树
        root.left = null;
        root.right = left;
        // 3、将原先的右子树接到当前右子树的末端
        BinaryTree.TreeNode temp = root;
        while (temp.right != null) {
            temp = temp.right;//遍历到最右
        }
        temp.right = right;//把之前的right节点接到后面
    }

    public static void main(String[] args) {
        LC114_BianryTreeToLinkedList solution = new LC114_BianryTreeToLinkedList();
        Integer[] values = {1,2,5,3,4,null,6};//用层序遍历的序列构造二叉树
        BinaryTree newTree = new BinaryTree(values);
        newTree.levelOrderTraversal(newTree.root);
        System.out.println();
        solution.flatten(newTree.root);
        newTree.levelOrderTraversal(newTree.root);
    }
}
