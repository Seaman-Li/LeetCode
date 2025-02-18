package Tree.BST;

public class LC0096_UniqueBST {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;// 空树的情况
        dp[1] = 1;
        for (int k = 2; k <= n; k++) {
            for (int i = 1; i <= k; i++) {
                dp[k] += dp[i - 1] * dp[k - i];
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        LC0096_UniqueBST bst = new LC0096_UniqueBST();
        System.out.println(bst.numTrees(3));
    }
}
