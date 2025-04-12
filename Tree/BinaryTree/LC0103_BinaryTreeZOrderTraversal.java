package Tree.BinaryTree;

import Hashmap.LC0128_LongestConsecutiveSequence;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC0103_BinaryTreeZOrderTraversal {

    public List<List<Integer>> zigzagLevelOrder(BinaryTree.TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if(root == null)
            return res;
        Queue<BinaryTree.TreeNode> queue = new LinkedList<>();
        queue.add(root);
        boolean leftToRight = true;// leftToRight control the output order of each level

        while(!queue.isEmpty()) {
            int size = queue.size();
            LinkedList<Integer> level = new LinkedList<>();
            for(int i = 0; i < size; i++) {
                BinaryTree.TreeNode node = queue.poll();
                // Add to list depending on direction
                if(leftToRight) {
                    level.addLast(node.val);
                }else{
                    level.addFirst(node.val);// insert at front for reverse order
                }
                // Add child nodes to queue for next level
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            res.add(level);
            leftToRight = !leftToRight;
        }
        return res;
    }

    public static void main(String[] args) {
        LC0103_BinaryTreeZOrderTraversal solution = new LC0103_BinaryTreeZOrderTraversal();

        Integer[] nums = {3, 9, 20, null, null, 15, 7};
        BinaryTree newTree = new BinaryTree(nums);
        List<List<Integer>> out = solution.zigzagLevelOrder(newTree.root);
        for(List<Integer> list : out) {
            System.out.println(list);
        }
    }



}
