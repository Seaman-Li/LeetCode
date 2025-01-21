package Tree.BinaryTree;


public class LC110_BalancedBinaryTree {

    //自顶向下的递归,最直接的方法
    //此方法直接对每个节点计算左右子树的高度，并确保每个节点的子树高度差不超过 1。这种方法的时间复杂度较高，因为它可能会重复计算同一个节点多次。
    public static boolean isBalanced1(BinaryTree.TreeNode root) {

        if (root == null) return true;
        int leftHeight = height(root.left);
        int rightHeight = height(root.right);
        return Math.abs(leftHeight - rightHeight) <= 1
                && isBalanced1(root.left)
                && isBalanced1(root.right);
    }

    //求子树的高度
    public static int height(BinaryTree.TreeNode node) {
        if (node == null) return 0;
        return Math.max(height(node.left), height(node.right)) + 1;
    }


    //自底向上的递归
    //此方法通过递归一次遍历就完成判断，避免了重复计算。每个节点的平衡状态由其子节点决定，从底部开始判断，如果发现不平衡则立即停止进一步计算。
    public static boolean isBalanced2(BinaryTree.TreeNode root) {
//        如果出现了return -1，在后面一直把-1递归到最上层的root节点后递归才会终止，而不是一检测到-1就在当前节点终止递归
        return checkHeight(root) != -1;
    }

    public static int checkHeight(BinaryTree.TreeNode node) {
        if (node == null) return 0;

        int leftHeight = checkHeight(node.left);
        if(leftHeight == -1) return -1;// 左子树不平衡

        int rightHeight = checkHeight(node.right);
        if(rightHeight == -1) return -1;// 右子树不平衡

        if(Math.abs(leftHeight - rightHeight) > 1) return -1;// 当前节点不平衡

        return Math.max(leftHeight, rightHeight) + 1;// 返回当前节点的高度
    }

    public static void main(String[] args) {
        Integer[] values = {3, 5, 1, 6, 2, 0, 8, null, null, 7, 4};
        BinaryTree tree = new BinaryTree(values);
        System.out.println(isBalanced2(tree.root));
    }

}
