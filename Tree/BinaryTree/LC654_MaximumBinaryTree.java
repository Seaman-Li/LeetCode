package Tree.BinaryTree;

public class LC654_MaximumBinaryTree {

    public BinaryTree.TreeNode constructMaximumBinaryTree(int[] nums) {
        return  build(nums, 0, nums.length - 1);
    }

    BinaryTree.TreeNode build(int[] nums, int low, int high)    {
        if (low > high)
            return null;
        int index = -1, maxVal = Integer.MIN_VALUE;
        for (int i = low; i <= high; i++) {
            if (nums[i] > maxVal) {
                maxVal = nums[i];
                index = i;
            }
        }
        BinaryTree.TreeNode root = new BinaryTree.TreeNode(maxVal);

        root.left = build(nums, low, index - 1);
        root.right = build(nums, index + 1, high);
        return root;
    }

    public static void main(String[] args) {
        LC654_MaximumBinaryTree sol = new LC654_MaximumBinaryTree();
        int[] nums = {3, 2, 1, 6, 5, 0};
        BinaryTree.TreeNode root =  sol.constructMaximumBinaryTree(nums);
        BinaryTree tree = new BinaryTree();
        tree.root = root;
        tree.levelOrderTraversal(root);
    }
}
