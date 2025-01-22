package Tree.BinaryTree;

import java.util.HashMap;
//遍历特性
//后序遍历：[左子树 | 右子树 | 根节点]
//postorder[postEnd] 是当前子树的根节点。
//中序遍历：[左子树 | 根节点 | 右子树]
//根节点将数组分为左子树和右子树。
public class LC106_ConstructByInorderAndPostorder {
    HashMap<Integer, Integer> valToIndex = new HashMap<>();
    public BinaryTree.TreeNode buildTree(int[] inorder, int[] postorder) {

        for (int i = 0; i < inorder.length; i++) {
            valToIndex.put(inorder[i], i);
        }
        return build(inorder,0,inorder.length-1,
                postorder,0,postorder.length-1);
    }

    BinaryTree.TreeNode build(int[] inorder, int inStart, int inEnd,
                              int[] postorder, int postStart, int postEnd){
        if (inStart > inEnd)
            return null;

        int rootVal = postorder[postEnd]; // root 节点对应的值就是后序遍历数组的最后一个元素
        int index = valToIndex.get(rootVal);// rootVal 在中序遍历数组中的索引

        int leftSize = index - inStart;
        BinaryTree.TreeNode root = new BinaryTree.TreeNode(rootVal);

        // 递归构造左右子树
        //递归构造左子树 中序范围：从 inStart 到 rootIndex - 1。后序范围：从 postStart 到 postStart + leftSize - 1。
        root.left = build(inorder, inStart, index - 1,
                postorder, postStart, postStart + leftSize - 1);
        //递归构造右子树 中序范围：从 rootIndex + 1 到 inEnd。后序范围：从 postStart + leftSize 到 postEnd - 1。
        root.right = build(inorder, index + 1, inEnd,
                postorder, postStart + leftSize, postEnd - 1);
        return root;
    }

    public static void main(String[] args) {
        int[] postorder = {9,15,7,20,3};
        int[] inorder = {9,3,15,20,7};
        LC106_ConstructByInorderAndPostorder sol = new LC106_ConstructByInorderAndPostorder();
        BinaryTree tree = new BinaryTree();
        tree.root = sol.buildTree(inorder, postorder);
        tree.levelOrderTraversalWithNull(tree.root);
    }
}
