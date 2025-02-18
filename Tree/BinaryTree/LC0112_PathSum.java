package Tree.BinaryTree;

import java.util.Stack;

public class LC0112_PathSum {
    int sum = 0;
    public boolean hasPathSum(BinaryTree.TreeNode root, int targetSum) {
        if(root == null)// Base case: Empty tree
            return false;
        // If it's a leaf node, check if the sum matches
        if(root.left == null && root.right == null)
            return root.val == targetSum;

        // Recursively check left and right subtrees with the updated targetSum
        //use || ， once get the true answer, the function will finally return true
        return hasPathSum(root.left, targetSum - root.val) ||
                hasPathSum(root.right, targetSum - root.val);
    }

    public boolean hasPathSum2(BinaryTree.TreeNode root, int targetSum) {
        if (root == null) return false;

        Stack<BinaryTree.TreeNode> stack = new Stack<>();
        Stack<Integer> sumStack = new Stack<>();
        stack.push(root);
        sumStack.push(targetSum - root.val);

        while (!stack.isEmpty()) {
            BinaryTree.TreeNode node = stack.pop();
            int currSum = sumStack.pop();

            // If it's a leaf node and sum matches, return true
            if (node.left == null && node.right == null && currSum == 0) {
                return true;
            }

            // Push right child (if exists)
            if (node.right != null) {
                stack.push(node.right);
                sumStack.push(currSum - node.right.val);
            }

            // Push left child (if exists)
            if (node.left != null) {
                stack.push(node.left);
                sumStack.push(currSum - node.left.val);
            }
        }

        return false;
    }

    public boolean hasPathSum3(BinaryTree.TreeNode root, int targetSum) {
        return dfs(root, 0, targetSum);
    }

    private boolean dfs(BinaryTree.TreeNode node, int sum, int targetSum) {
        if (node == null) return false;

        sum += node.val; // Update sum

        if (node.left == null && node.right == null) { // Leaf node check
            return sum == targetSum;
        }

        // Recursively traverse left and right
        boolean left = dfs(node.left, sum, targetSum);
        boolean right = dfs(node.right, sum, targetSum);

        return left || right;
    }

    public static void main(String[] args) {
        LC0112_PathSum pathSum = new LC0112_PathSum();
        Integer[] arr = {5,4,8,11,null,13,4,7,2,null,null,null,1};
        BinaryTree tree = new BinaryTree(arr);
        System.out.println(pathSum.hasPathSum(tree.root, 22));
    }


}
