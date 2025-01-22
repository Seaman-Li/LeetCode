package Tree.BinaryTree;

import java.util.HashMap;
import java.util.Map;

//前序和中序的特性
//前序遍历：[根节点 | 左子树 | 右子树]
//第一个节点始终是当前子树的根节点。
//中序遍历：[左子树 | 根节点 | 右子树]
//根节点将数组分为左子树和右子树。
//通过结合这两种遍历序列，可以唯一确定二叉树的结构。
public class LC105_ConstructByPreorderAndInorder {

    public BinaryTree.TreeNode buildTree(int[] preorder, int[] inorder) {
        // 构建哈希表，存储中序遍历的值和索引
        Map<Integer, Integer> inorderIndexMap  = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderIndexMap.put(inorder[i], i);
        }

        return build(preorder,0,preorder.length-1,
                inorder,0,inorder.length-1,
                inorderIndexMap);

    }

    BinaryTree.TreeNode build(int[] preorder, int preStart, int preEnd,
                              int[] inorder, int inStart, int inEnd,
                              Map<Integer, Integer> inorderIndexMap) {
        // 递归终止条件
        if (preStart > preEnd || inStart > inEnd) {
            return null;
        }
        // 前序遍历的第一个节点是根节点
        int rootVal = preorder[preStart];
        BinaryTree.TreeNode root = new BinaryTree.TreeNode(rootVal);
        //在中序遍历中找到根节点的位置(本题二叉树中没有重复元素可以之间从hashmap中找到rootVal和其index)
        int rootIndex = inorderIndexMap.get(rootVal);//rootIndex 是根节点在中序遍历数组中的索引。
        // 计算左子树的节点数
        int leftSize = rootIndex - inStart;//leftSize 表示左子树的节点数量，即从 inStart 到 rootIndex 之间的节点个数。
        // 递归构造左子树,左子树在前序遍历中的范围是 preStart + 1 到 preStart + leftSize;左子树在中序遍历中的范围是 inStart 到 rootIndex - 1。
        root.left = build(preorder, preStart + 1, preStart + leftSize,
                inorder, inStart, rootIndex - 1, inorderIndexMap);
        // 递归构造右子树,右子树在前序遍历中的范围是 preStart + leftSize + 1 到 preEnd。右子树在中序遍历中的范围是 rootIndex + 1 到 inEnd。
        root.right = build(preorder, preStart + leftSize + 1, preEnd,
                inorder, rootIndex + 1, inEnd, inorderIndexMap);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        LC105_ConstructByPreorderAndInorder solution = new LC105_ConstructByPreorderAndInorder();
        BinaryTree tree = new BinaryTree();
        tree.root = solution.buildTree(preorder, inorder);
        tree.levelOrderTraversalWithNull(tree.root);
    }
}
