package DP;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LC064_MinimumPathSum {
    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];

        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }

        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        return dp[m - 1][n - 1];
    }

    public static List<int[]> minPathSum2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        int[][] parent = new int[m][n];  // 用于追踪路径

        dp[0][0] = grid[0][0];
        // 初始化第一行和第一列
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
            parent[0][j] = 0;  // 来自左边
        }
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
            parent[i][0] = 1;  // 来自上面
        }

        // 填充dp表和parent表
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (dp[i - 1][j] < dp[i][j - 1]) {
                    dp[i][j] = dp[i - 1][j] + grid[i][j];
                    parent[i][j] = 1;  // 来自上面
                } else {
                    dp[i][j] = dp[i][j - 1] + grid[i][j];
                    parent[i][j] = 0;  // 来自左边
                }
            }
        }

        // 回溯找路径
        List<int[]> path = new ArrayList<>();
        int i = m - 1, j = n - 1;
        while (i > 0 || j > 0) {
            path.add(new int[]{i, j});
            if (parent[i][j] == 1) { // 上面
                i--;
            } else { // 左边
                j--;
            }
        }
        path.add(new int[]{0, 0});  // 添加起始点
        Collections.reverse(path);  // 翻转路径为从起点到终点

        return path;
    }



    public static void main(String[] args) {
        int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        System.out.println(minPathSum(grid));
        for(int[] arr : minPathSum2(grid)) {
            System.out.println(Arrays.toString(arr));
        }
    }

}
