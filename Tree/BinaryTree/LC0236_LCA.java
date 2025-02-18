package Tree.BinaryTree;



public class LC0236_LCA {

    public static BinaryTree.TreeNode lowestCommonAncestor(BinaryTree.TreeNode root, BinaryTree.TreeNode p, BinaryTree.TreeNode q){
        // 如果到达叶子节点的下面或找到 p 或 q，则返回
        if (root == null || root == p || root == q) {
            return root;
        }

        // 在左右子树中分别查找
        BinaryTree.TreeNode left = lowestCommonAncestor(root.left, p, q);
        BinaryTree.TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 如果左右子树查找结果都不为空，说明 p 和 q 在两侧，当前 root 为 LCA
        if (left != null && right != null) {
            return root;
        }

        // 否则，返回非空的一侧
        return left != null ? left : right;
    }

    public static void main(String[] args) {

//        // 构建测试用的二叉树
//        BinaryTree.TreeNode root = new BinaryTree.TreeNode(3);
//        root.left = new BinaryTree.TreeNode(5);
//        root.right = new BinaryTree.TreeNode(1);
//        root.left.left = new BinaryTree.TreeNode(6);
//        root.left.right = new BinaryTree.TreeNode(2);
//        root.right.left = new BinaryTree.TreeNode(0);
//        root.right.right = new BinaryTree.TreeNode(8);
//        root.left.right.left = new BinaryTree.TreeNode(7);
//        root.left.right.right = new BinaryTree.TreeNode(4);
//
//        // 设置需要查询的两个节点
//        BinaryTree.TreeNode p = root.left; // 节点 5
//        BinaryTree.TreeNode q = root.right; // 节点 1

        Integer[] values = {3, 5, 1, 6, 2, 0, 8, null, null, 7, 4};
        BinaryTree tree = new BinaryTree(values);

        BinaryTree.TreeNode root = tree.root;
        BinaryTree.TreeNode p = tree.findNode(5);
        BinaryTree.TreeNode q = tree.findNode(1);


        BinaryTree.TreeNode lca =  lowestCommonAncestor(root, p, q);
        System.out.println(lca.val);


    }
}
