package Tree.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC639_AverageLevels {

    public List<Double> averageOfLevels(BinaryTree.TreeNode root) {
        List<Double> res = new ArrayList<>();
        if (root == null) return res;
        Queue<BinaryTree.TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();

            double sum = 0.0;
            for (int i = 0; i < size; i++) {
                BinaryTree.TreeNode cur = queue.poll();
                sum += cur.val;
                if (cur.left != null) queue.add(cur.left);
                if (cur.right != null) queue.add(cur.right);
            }
            res.add(sum / size);
        }
        return res;
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[]{3,9,20,null,null,15,7};
        BinaryTree Tree = new BinaryTree(arr);
        LC639_AverageLevels sol = new LC639_AverageLevels();
        List<Double> res = sol.averageOfLevels(Tree.root);
        for (Double d : res) {
            System.out.println(d);
        }
    }
}
