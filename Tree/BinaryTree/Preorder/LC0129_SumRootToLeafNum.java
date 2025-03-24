package Tree.BinaryTree.Preorder;

import Tree.BinaryTree.BinaryTree;


//You are given the root of a binary tree containing digits from 0 to 9 only.
//Each root-to-leaf path in the tree represents a number.For example, the root-to-leaf path 1 -> 2 -> 3 represents the number 123.
//Return the total sum of all root-to-leaf numbers. Test cases are generated so that the answer will fit in a 32-bit integer.
//A leaf node is a node with no children.

//Input: root = [1,2,3]
//Output: 25
//Explanation:
//The root-to-leaf path 1->2 represents the number 12.
//The root-to-leaf path 1->3 represents the number 13.
//Therefore, sum = 12 + 13 = 25.

public class LC0129_SumRootToLeafNum {


    //Use preorder traversal, build the number as you go, and add it to the total at the leaf.
    public int sumNumbers(BinaryTree.TreeNode root) {
        return preorder(root, 0);
    }

    int preorder(BinaryTree.TreeNode node, int curNum) {
        if (node == null)
            return 0;
        curNum = curNum * 10 + node.val;
        // If it's a leaf, return the built number
        if(node.left == null && node.right == null){
            return curNum;
        }
        // Recur on left and right
        return preorder(node.left, curNum) + preorder(node.right, curNum);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        tree.root = new BinaryTree.TreeNode(1);
        tree.root.left = new BinaryTree.TreeNode(2);
        tree.root.right = new BinaryTree.TreeNode(3);

        LC0129_SumRootToLeafNum solution = new LC0129_SumRootToLeafNum();
        System.out.println(solution.sumNumbers(tree.root));
    }
}
