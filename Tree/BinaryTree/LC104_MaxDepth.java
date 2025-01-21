package Tree.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

public class LC104_MaxDepth {

    public static int maxDepth(BinaryTree.TreeNode root) {
        if (root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

//    迭代法：广度优先搜索可以通过层级遍历来实现，每遍历完一层，深度就增加1。
    public static int maxDepthQueue(BinaryTree.TreeNode root) {
        if (root == null) return 0;
        Queue<BinaryTree.TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();//这里记录每一层的节点数量，在下一次迭代时把这些节点出队搜索
            for (int i = 0; i < levelSize; i++) {
                BinaryTree.TreeNode currentNode = queue.poll();
                if (currentNode.left != null)
                    queue.add(currentNode.left);
                if (currentNode.right != null)
                    queue.add(currentNode.right);
            }
            depth++;
        }

        return depth;
    }

    public static void main(String[] args) {
        Integer[] values = {3, 5, 1, 6, 2, 0, 8, null, null, 7, 4};
        BinaryTree tree = new BinaryTree(values);
        System.out.println(maxDepthQueue(tree.root));
    }
}
