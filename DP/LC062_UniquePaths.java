package DP;
//统计从矩阵左上角到右下角的路径总数，每次只能向右或者向下移动。
public class LC062_UniquePaths {
    public static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];//dp[i][j] 表示从左上角到达 (i, j) 位置的不同路径的数量

        // 初始化第一行和第一列
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }

        // 填充dp表
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }

        return dp[m-1][n-1];
    }

    public int uniquePaths2(int m, int n) {
        int[] dp = new int[n];
        dp[0] = 1;

        for (int i = 0; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[j] += dp[j - 1];
            }
        }
        return dp[n - 1];
    }



    public static void main(String[] args) {
        int m = 3;
        int n = 3;

        int paths = uniquePaths(m, n);
        System.out.println("Number of unique paths from top left to bottom right of a "
                + m + "x" + n + " grid is: " + paths);
    }
}
