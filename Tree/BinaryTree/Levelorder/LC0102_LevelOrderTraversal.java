package Tree.BinaryTree.Levelorder;

import Tree.BinaryTree.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC0102_LevelOrderTraversal {

    public List<List<Integer>> levelOrder(BinaryTree.TreeNode root) {
        if (root == null)
            return new LinkedList<>();
        Queue<BinaryTree.TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<List<Integer>> res = new LinkedList<>();
        while (!queue.isEmpty()) {
            List<Integer> list = new LinkedList<>();
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                BinaryTree.TreeNode cur = queue.poll();
                list.add(cur.val);
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            res.add(list);
        }
        return res;
    }

    //levelOrderRecursive
    List<List<Integer>> ans = new ArrayList<>();

    public void order(BinaryTree.TreeNode node, int level) {
        if (node == null) return; // Base case: Stop if node is null

        // If we reach a new level, create a new list
        if (ans.size() == level) {
            ans.add(new ArrayList<Integer>());
        }

        // Add the current node's value to its level list
        ans.get(level).add(node.val);

        // Recur for left and right children, increasing level
        order(node.left, level + 1);
        order(node.right, level + 1);
    }

    public List<List<Integer>> levelOrderRecursive(BinaryTree.TreeNode root) {
        if (root == null) return ans;

        order(root, 0);
        return ans;
    }

    public static void main(String[] args) {
        Integer[] arr = {3,9,20,null,null,15,7};
        BinaryTree tree = new BinaryTree(arr);
        LC0102_LevelOrderTraversal sol = new LC0102_LevelOrderTraversal();
        List<List<Integer>> res = sol.levelOrder(tree.root);

        for (List<Integer> list : res) {
            System.out.println(list);
        }
    }
}
