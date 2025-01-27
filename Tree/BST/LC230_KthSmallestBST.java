package Tree.BST;

import Tree.BinaryTree.BinaryTree;

public class LC230_KthSmallestBST {

    int res = 0;// 记录结果
    int rank = 0;// 记录当前元素的排名

    public int kthSmallest(BinaryTree.TreeNode root, int k) {
        traverse(root, k);// 利用 BST 的中序遍历特性
        return res;
    }

    void traverse(BinaryTree.TreeNode root, int k) {
        if(root == null)
            return;
        traverse(root.left,k);//先递归到最左边的节点，是最小值节点
        //从最小值节点开始记录节点值的排序
        rank++;// 中序代码位置
        if(rank == k){
            res = root.val;// 找到第 k 小的元素
            return;
        }
        traverse(root.right,k);
    }

    public static void main(String[] args) {
        Integer[] nums = {3,1,4,null,2};
        BinaryTree bt = new BinaryTree(nums);
        LC230_KthSmallestBST sol = new LC230_KthSmallestBST();
        System.out.println(sol.kthSmallest(bt.root,1));

    }
}
