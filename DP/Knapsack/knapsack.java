package DP.Knapsack;

public class knapsack {
    // W 为背包总体积
    // N 为物品数量
    // weights 数组存储 N 个物品的重量
    // values 数组存储 N 个物品的价值
    public static int knapsack(int W, int[] weight, int[] value, int n) {
        // dp[i][j] 表示在可用重量为 j 的情况下，前 i 个物品能够达到的最大价值
        int[][] dp = new int[n + 1][W + 1];

        for (int i = 1; i <= n; i++) {
            for (int w = 1; w <= W; w++) {
                if (weight[i - 1] <= w) {
                    // 如果当前物品的重量小于等于当前的可用重量
                    // 可以选择拿或者不拿当前的物品
                    dp[i][w] = Math.max(value[i - 1] + dp[i - 1][w - weight[i - 1]], dp[i - 1][w]);
                } else {
                    // 当前物品重量大于可用重量，不能选择当前物品
                    dp[i][w] = dp[i - 1][w];
                }
            }
        }

        // 返回装入背包的最大价值
        return dp[n][W];
    }

//避免了使用二维数组，减少了内存使用，同时因为是从后向前更新，确保了每个物品只用一次。对于较小的数据集，这种方法更有效，因为它减少了不必要的数组空间和一些重复计算。
    public static int knapsack2(int W, int[] weight, int[] value, int n) {
        // 使用一维数组进行动态规划
        int[] dp = new int[W + 1];

        // 只使用一维数组更新最大价值
        for (int i = 0; i < n; i++) {
            for (int w = W; w >= weight[i]; w--) {
                dp[w] = Math.max(dp[w], dp[w - weight[i]] + value[i]);
            }
        }

        return dp[W];
    }

    public static void main(String[] args) {
        int[] value = {60, 100, 120};
        int[] weight = {10, 20, 30};
        int W = 50;
        int n = value.length;
        System.out.println(knapsack(W, weight, value, n));
    }
}
