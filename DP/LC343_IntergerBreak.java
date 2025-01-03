package DP;

import java.sql.SQLOutput;

public class LC343_IntergerBreak {

//    令 dp[i] 表示将整数i 拆分后的最大乘积。
//    转移方程
//    对于整数𝑖i，可以将其拆分为两个部分：j 和i−j。
//    此时有两种可能：j×(i−j)：直接将i 拆分为两个数。
//    j×dp[i−j]：继续拆分 i−j。
//    因此状态转移方程为：dp[i]=max(dp[i],max(j×(i−j),j×dp[i−j]))
//    遍历j 从 1 到 i−1，依次更新 dp[i]。
//    初始条件
//    dp[2]=1：当 n=2 时，唯一的拆分是
//        1+1，乘积为 1。
//    最终结果 dp[n]。

    public static int integerBreak(int n){
        if (n == 2) return 1;
        if (n == 3) return 2;

        int[] dp = new int[n + 1];
        dp[2] = 1;

        for(int i = 3; i <= n; i++){
            for(int j = 1; j < i; j++){
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }

        return dp[n];
    }

//    数学解法（贪心法）
//    理论上，整数拆分的最佳方式是尽可能多地分成 3，因为3^x > 2^y,当 x+2y=n 时，3 的幂次效果更好。
//    如果剩余部分是 4，则保留为2×2，因为4>3+1。
    public static int integerBreak2(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;

        int product = 1;
        while (n > 4) {
            product *= 3;
            n -= 3;
        }

        product *= n; // 剩下的部分直接乘上
        return product;
    }


    public static void main(String[] args){
        System.out.println(integerBreak2(10));
    }

}
