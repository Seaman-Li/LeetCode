package DP;

public class LC0063_UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;

        // 如果起点或终点有障碍物，直接返回 0
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1) {
            return 0;
        }

        int[][] dp = new int[m][n];
        dp[0][0] = 1; // 起点路径数为 1

        // 初始化第一列
        for (int i = 1; i < m; i++) {
            dp[i][0] = obstacleGrid[i][0] == 0 ? dp[i-1][0] : 0;
        }

        // 初始化第一行
        for (int j = 1; j < n; j++) {
            dp[0][j] = obstacleGrid[0][j] == 0 ? dp[0][j-1] : 0;
        }

        // 填充 dp 表
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i-1][j] + dp[i][j-1];
                } else {
                    dp[i][j] = 0; // 当前有障碍物
                }
            }
        }

        return dp[m-1][n-1];
    }


    public static void main(String[] args) {
        int[][] obstacleGrid = {{0,0,0},{0,1,0},{0,0,0}};

    }
}
