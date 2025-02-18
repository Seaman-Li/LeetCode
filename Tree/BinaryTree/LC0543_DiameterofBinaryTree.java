package Tree.BinaryTree;

public class LC0543_DiameterofBinaryTree {
//    每一条二叉树的「直径」长度，就是一个节点的左右子树的最大深度之和
    int maxDiameter = 0;
    public int diameterOfBinaryTree(BinaryTree.TreeNode root) {
        traverse(root);
        return maxDiameter;
    }

    void traverse(BinaryTree.TreeNode root) {
        if (root == null) return ;
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        maxDiameter = Math.max(maxDiameter, leftMax + rightMax);
        traverse(root.left);
        traverse(root.right);
    }

    int maxDepth(BinaryTree.TreeNode root) {
        if (root == null) return 0;
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        return 1 + Math.max(leftMax, rightMax);
    }
//    这个解法是正确的，但是运行时间很长，原因也很明显，traverse 遍历每个节点的时候还会调用递归函数 maxDepth，而 maxDepth 是要遍历子树的所有节点的，所以最坏时间复杂度是 O(N^2)。
//    这就出现了刚才探讨的情况，前序位置无法获取子树信息，所以只能让每个节点调用 maxDepth 函数去算子树的深度。
//    那如何优化？我们应该把计算「直径」的逻辑放在后序位置，准确说应该是放在 maxDepth 的后序位置，因为 maxDepth 的后序位置是知道左右子树的最大深度的。

    public int diameterOfBinaryTree2(BinaryTree.TreeNode root){
        maxDepth2(root);
        return maxDiameter;
    }

    int maxDepth2(BinaryTree.TreeNode root) {
        if (root == null)
            return 0;
        int leftMax = maxDepth2(root.left);
        int rightMax = maxDepth2(root.right);
        // 后序位置，顺便计算最大直径
        int thisDiameter = leftMax + rightMax;
        maxDiameter = Math.max(maxDiameter, thisDiameter);
        return 1 + Math.max(leftMax, rightMax);
    }

    public static void main(String[] args) {
        BinaryTree.TreeNode root = new BinaryTree.TreeNode(1);
        root.left = new BinaryTree.TreeNode(2);
        root.right = new BinaryTree.TreeNode(3);
        root.left.left = new BinaryTree.TreeNode(4);
        root.left.right = new BinaryTree.TreeNode(5);

        LC0543_DiameterofBinaryTree sol = new LC0543_DiameterofBinaryTree();

        System.out.println(sol.diameterOfBinaryTree2(root));
    }

}
