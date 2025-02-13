package Array;

public class LC122_BuyandSellII {

//    贪心法（只要价格上涨就卖出）
//    只要今天的价格比昨天高，就买入并在当天卖出，相当于累加所有上涨的部分。
//    贪心策略：
//    如果 prices[i] > prices[i-1]，累加 prices[i] - prices[i-1]。
//    否则跳过（不交易）。
//    时间复杂度：O(n)，空间复杂度 O(1)
    public int maxProfit(int[] prices) {
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            // 只要今天的价格比昨天高，就计算利润
            if (prices[i] > prices[i - 1]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }

//    动态规划
//    定义 dp[i][0]：第 i 天 不持有股票 时的最大利润。
//    定义 dp[i][1]：第 i 天 持有股票 时的最大利润。
//    dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i]); // 今天卖出 或 保持不持有
//    dp[i][1] = max(dp[i-1][1], dp[i-1][0] - prices[i]); // 今天买入 或 保持持有

    public int maxProfit2(int[] prices) {
        int n = prices.length;
        if(n == 0) return 0;

        int[][] dp = new int[n][2];
        dp[0][0] = 0;// 第 0 天不持有
        dp[0][1] = -prices[0];// 第 0 天持有（买入）
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);// 卖出
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);// 买入
        }
        return dp[n - 1][0];// 最后一天不持有时的最大利润
    }



    public static void main(String[] args) {
        LC122_BuyandSellII solution = new LC122_BuyandSellII();
        int[] prices = {7,1,5,3,6,4};
        System.out.println(solution.maxProfit(prices));
    }
}
