package Array;

public class LC0121_BuyandSell {

    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            int BuyIn = prices[i];
            for (int j = i + 1; j < prices.length; j++) {
                int SellOut = prices[j];
                int Profit = SellOut - BuyIn;
                maxProfit = Math.max(maxProfit, Profit);
            }
        }
        return maxProfit;
    }

//    一次遍历（动态维护最小价格）
//    核心思想：(贪心)
//    维护历史最低买入价格（贪心选择：总是以最小的成本买入）。
//    在每一天计算最大可能利润（贪心选择：以当前价格卖出时的最大收益）。
//    不断更新最大利润，确保最终获得最大值。
    public int maxProfit2(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int price : prices) {
            minPrice = Math.min(minPrice, price);
            maxProfit = Math.max(maxProfit, price - minPrice);
        }
        return maxProfit;
    }



    public static void main(String[] args) {
        LC0121_BuyandSell sol = new LC0121_BuyandSell();
        int[] prices = {7,1,5,3,6,4};
        System.out.println(sol.maxProfit(prices));
    }
}
