package DP;
//题目描述：假设农场中成熟的母牛每年都会生 1 头小母牛，并且永远不会死。第一年有 1 只小母牛，从第二年开始，母牛开始生小母牛。每只小母牛 3 年之后成熟又可以生小母牛。给定整数 N，求 N 年后牛的数量。
//第 i 年成熟的牛的数量为：
//dp[i] = dp[i-1]+dp[i-3]
public class cow {
    public static void main(String[] args) {
        int y = 10;
        System.out.println(cow(y));
    }


    public static int cow(int N) {
        if (N == 0) {
            return 0;
        }
        int[] dp = new int[N + 1];
        dp[1] = 1;
        dp[2] = 1;
        dp[3] = 2;
        for (int i = 4; i <= N; i++) {
            dp[i] = dp[i - 1] + dp[i - 3];
        }
        return dp[N];
    }

}
