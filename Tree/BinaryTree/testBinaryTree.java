package Tree.BinaryTree;

public class testBinaryTree {
    public static void main(String[] args) {

        Integer[] values = {3, 5, 1, 6, 2, 0, 8, null, null, 7, 4};
        BinaryTree newTree = new BinaryTree(values);


        System.out.println("Preorder traversal:");
        newTree.preorderTraversal(newTree.root);
        System.out.println("\nPreorder traversal with Iteration:");
        newTree.preorderTraversalIteration(newTree.root);

        System.out.println("\nInorder traversal:");
        newTree.inorderTraversal(newTree.root);
        System.out.println("\nInorder traversal with Iteration:");
        newTree.inorderTraversalIteration(newTree.root);

        System.out.println("\nPostorder traversal:");
        newTree.postorderTraversal(newTree.root);
        System.out.println("\nPostorder traversal with Iteration:");
        newTree.postorderTraversalIteration(newTree.root);

        System.out.println("\nlevelOrderTraversal traversal:");
        newTree.levelOrderTraversal(newTree.root);
        System.out.println("\nlevelOrderTraversalWithNull:");
        newTree.levelOrderTraversalWithNull(newTree.root);
        System.out.println("\nlevelOrderTraverseWithDepth:");
        newTree.levelOrderTraverseWithDepth(newTree.root);
    }
}
