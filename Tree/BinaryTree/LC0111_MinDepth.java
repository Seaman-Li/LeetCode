package Tree.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class LC0111_MinDepth {
    // 记录最小深度（根节点到最近的叶子节点的距离）
    private int minDepth = Integer.MAX_VALUE;
    // 记录当前遍历到的节点深度
    private int currentDepth = 0;

    //DFS从左到右，一条树枝一条树枝进行遍历的,每当遍历到一条树枝的叶子节点，就会更新最小深度，当遍历完整棵树后，就能算出整棵树的最小深度。
    public int minDepthDFS(BinaryTree.TreeNode root) {
        if (root == null) return 0;
        // 从根节点开始 DFS 遍历
        dfs(root);
        return minDepth;
    }

    public void dfs(BinaryTree.TreeNode root) {
        if (root == null) return;

        // 递归前序位置进入节点时增加当前深度
        currentDepth++;
        // 如果当前节点是叶子节点，更新最小深度
        if(root.left == null && root.right == null) {
            minDepth = Math.min(minDepth, currentDepth);
        }

        dfs(root.left);
        dfs(root.right);
        // 跳出递归后序位置离开节点时减少当前深度
        currentDepth--;
    }

    //BFS is better than DFS when solving minimum depth problems since it's no need to iterate all the tree nodes
    //按照 BFS 从上到下逐层遍历二叉树的特点，当遍历到第一个叶子节点时，就能得到最小深度
    public int minDepthBFS(BinaryTree.TreeNode root) {
        if (root == null) return 0;
        Queue<BinaryTree.TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 1;// root 本身就是一层，depth 初始化为 1
        while (!queue.isEmpty()) {
            int size = queue.size();
            // 遍历当前层的节点
            for (int i = 0; i < size; i++) {
                BinaryTree.TreeNode currentNode = queue.poll();
                // 判断是否到达叶子结点,即左右子树都是null
                if (currentNode.left == null && currentNode.right == null) {
                    return depth;
                }
                // 将下一层节点加入队列
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
            // 当一层的节点遍历完后，这里增加深度
            depth++;
        }
        return depth;
    }





    public static void main(String[] args) {
        Integer[] arr = {3,9,20,null,null,15,7};
        BinaryTree tree = new BinaryTree(arr);
        LC0111_MinDepth sol = new LC0111_MinDepth();
        System.out.println(sol.minDepthBFS(tree.root));
    }

}
