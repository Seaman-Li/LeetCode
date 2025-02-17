package Tree.BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LC199_BinaryTreeRightSideView {
    List<Integer> res = new ArrayList<>();
    public List<Integer> rightSideView(BinaryTree.TreeNode root) {
        if(root == null)
            return res;
        levelOrderTraversal(root);
        return res;
    }

    void levelOrderTraversal(BinaryTree.TreeNode node){
        Queue<BinaryTree.TreeNode> queue = new LinkedList<>();
        queue.offer(node);

        while (!queue.isEmpty()){
            int sz = queue.size();
            BinaryTree.TreeNode rightmost = null;

            for (int i = 0; i<sz;i++){
                BinaryTree.TreeNode cur = queue.poll();
                rightmost = cur; //rightmost will be the last element when the iteration ends
                // Add left and right children to queue
                if (cur.left != null) queue.offer(cur.left);
                if (cur.right != null) queue.offer(cur.right);
            }

            res.add(rightmost.val);
        }
    }

    public static void main(String args[]){
        Integer[] arr = {1,2,3,4,null,null,null,5};
        BinaryTree tree = new BinaryTree(arr);
        LC199_BinaryTreeRightSideView sol = new LC199_BinaryTreeRightSideView();
        List<Integer>[] res = new List[]{sol.rightSideView(tree.root)};
        for(int i=0; i < res.length; i++){
            System.out.println(res[i]);
        }
    }
}
