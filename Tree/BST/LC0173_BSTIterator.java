package Tree.BST;

import Tree.BinaryTree.BinaryTree;

import java.util.Stack;

class BSTIterator {

    private Stack<BinaryTree.TreeNode> stack;

    public BSTIterator(BinaryTree.TreeNode root){
        stack = new Stack<>();
        pushLeftBranch(root);// Initialize stack with leftmost path
    }

    private void pushLeftBranch(BinaryTree.TreeNode node){
        while(node != null){
            stack.push(node);
            node = node.left;
        }
    }

    public int next() {
        BinaryTree.TreeNode node = stack.pop();// Node with next smallest value
        if(node.right != null)
            pushLeftBranch(node.right);// Go right, then all the way left
        return node.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

    public static void main(String[] args) {
        Integer[] nums = {7, 3, 15, null, null, 9, 20};
        BinaryTree tree = new BinaryTree(nums);
        BSTIterator bSTIterator = new BSTIterator(tree.root);

        System.out.println(bSTIterator.next());   // return 3
        System.out.println(bSTIterator.next());    // return 7
        System.out.println(bSTIterator.hasNext()); // return True
        System.out.println(bSTIterator.next());    // return 9
        System.out.println(bSTIterator.hasNext()); // return True
        System.out.println(bSTIterator.next());    // return 15
        System.out.println(bSTIterator.hasNext()); // return True
        System.out.println(bSTIterator.next());    // return 20
        System.out.println(bSTIterator.hasNext()); // return False
    }

}
